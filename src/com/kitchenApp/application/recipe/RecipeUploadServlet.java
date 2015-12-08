package com.kitchenApp.application.recipe;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "recipeUploadServlet",
        urlPatterns = { "/chef/uploadRecipe" }
)

public class RecipeUploadServlet extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:/tomcat/webapps/upload"; //set up in properties file.

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){

            try {
                List<FileItem> fileList = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : fileList){

                    if(!item.isFormField()){

                        String fileName = new File(item.getName()).getName();

                        item.write( new File(UPLOAD_DIRECTORY + File.separator + fileName));
                        placePathInSession(request, fileName);
                    }
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

        }else{

            request.setAttribute("message",

                    "Sorry this Servlet only handles file upload request");

        }

        //add file path to session

        forwardToResultsPage(response);
    }

    public void forwardToResultsPage(HttpServletResponse response) throws ServletException, IOException {

        String url = "/chef";
        response.sendRedirect(url);
    }

    public void placePathInSession(HttpServletRequest request, String fileName) {

        String fileLocation = UPLOAD_DIRECTORY + fileName;

        HttpSession session = request.getSession();
        session.setAttribute("uploadedFilePath", fileLocation);
    }
}