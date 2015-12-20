package com.kitchenApp.application;

import com.kitchenApp.application.action.RecipeUploadAction;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Properties;

@WebServlet(
        name = "recipeUploadServlet",
        urlPatterns = { "/chef/uploadRecipe" }
)

/**
 *  Servlet class to handle uploading recipe files to the server
 *  @author afaherty
 *  @version 2.0 on 12/9/2015
 */
@MultipartConfig
public class RecipeUploadServlet extends HttpServlet {

    private Properties properties = new Properties();
    private RecipeUploadAction recipeAction;

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Posts recipe and related data to a folder for later use.
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        properties = (Properties)context.getAttribute("kitchenAppProperties");
        String uploadDirectory = properties.getProperty("upload.location");
        String accessUpload = properties.getProperty("upload.storage.location");

        uploadFile(request, uploadDirectory, accessUpload);
       forwardToResultsPage(response);
    }



    /**
     * Handles actions to upload file to server
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void uploadFile(HttpServletRequest request, String uploadDirectory, String accessUpload)
            throws ServletException, IOException {

        recipeAction = new RecipeUploadAction();

        Part filePart = request.getPart("recipeFile");
        String fileName = filePart.getSubmittedFileName();

        recipeAction.uploadFileToServer(fileName, filePart, uploadDirectory);

        receiveInputParameters(request, fileName, accessUpload);
        placePathInSession(request, fileName, uploadDirectory);
    }

    /**
     * Redirects user to chef main page
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet exception
     * @throws IOException if there is an input/output exception
     */
    public void forwardToResultsPage(HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef";
        log.debug(url);
        response.sendRedirect(url);
    }

    /**
     * Displays the path name of the file uploaded to the server
     * @param request HttpServletResponse object
     * @param fileName ref to display name of file
     */
    public void placePathInSession(HttpServletRequest request, String fileName, String uploadDirectory) {

        String fileLocation = uploadDirectory + fileName;

        HttpSession session = request.getSession();
        session.setAttribute("uploadedFilePath", fileLocation);
    }

    /**
     * Instantiates a RecipeUpLoadAction object to add recipe details to database
     * @param category ref to recipe category
     * @param recipeName ref to recipe name
     * @param fileName ref to file location
     */
    public void addRecipe(String category, String recipeName, String fileName, String accessUpload) {

        recipeAction = new RecipeUploadAction();

        String filePath = accessUpload + fileName;

        recipeAction.addRecipeData(filePath, category, recipeName);
    }

    /**
     * Receives form data the database will require
     * @param request HttpServletRequest object
     * @param fileName reference to the file name
     */
    public void receiveInputParameters(HttpServletRequest request, String fileName, String accessUpload) {

        String category = request.getParameter("selectCategory");
        String recipeName = request.getParameter("recipeName");

        addRecipe(category, recipeName, fileName, accessUpload);
    }
}