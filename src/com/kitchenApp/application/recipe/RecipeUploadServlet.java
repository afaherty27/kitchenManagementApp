package com.kitchenApp.application.recipe;

import com.kitchenApp.application.action.RecipeUploadAction;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

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

    private final String UPLOAD_DIRECTORY = "C:/Users/Student/Dropbox/enterpriseJava/kitchenManagementApp/recipeUpload/"; //set up in properties file.4
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

        uploadFile(request);
        forwardToResultsPage(response);
    }

    /**
     * Handles actions to upload file to server
     * @param request HttpServletRequest object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void uploadFile(HttpServletRequest request) throws ServletException, IOException {

        Part filePart = request.getPart("recipeFile");
        String fileName = filePart.getSubmittedFileName();
        receiveInputParameters(request, fileName);

        try (Writer output = new BufferedWriter(new FileWriter(UPLOAD_DIRECTORY + fileName))){

            placePathInSession(request, fileName);
            log.info("Writing File " + fileName);

        } catch (FileNotFoundException fileNotFound)  {

            fileNotFound.printStackTrace();
            log.error(fileNotFound);
        }
    }

    /**
     * Redirects user to chef main page
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet exception
     * @throws IOException if there is an input/output exception
     */
    public void forwardToResultsPage(HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef";
        response.sendRedirect(url);
    }

    /**
     * Displays the path name of the file uploaded to the server
     * @param request HttpServletResponse object
     * @param fileName ref to display name of file
     */
    public void placePathInSession(HttpServletRequest request, String fileName) {

        String fileLocation = UPLOAD_DIRECTORY + fileName;

        HttpSession session = request.getSession();
        session.setAttribute("uploadedFilePath", fileLocation);
    }

    /**
     * Instantiates a RecipeUpLoadAction object to add recipe details to database
     * @param category ref to recipe category
     * @param recipeName ref to recipe name
     * @param fileName ref to file location
     */
    public void addRecipe(String category, String recipeName, String fileName) {

        RecipeUploadAction recipeAction = new RecipeUploadAction();

        String filePath = UPLOAD_DIRECTORY + fileName;

        recipeAction.addRecipeData(filePath, category, recipeName);
    }

    /**
     * Receives form data the database will require
     * @param request HttpServletRequest object
     * @param fileName reference to the file name
     */
    public void receiveInputParameters(HttpServletRequest request, String fileName) {

        String category = request.getParameter("selectCategory");
        String recipeName = request.getParameter("recipeName");

        addRecipe(category, recipeName, fileName);
    }
}