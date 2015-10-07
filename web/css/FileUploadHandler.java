package java112.project4;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

/**
 * Servlet to handle File upload request from Client
 *
 * @author Javin Paul 
 *  !!comments and Project/Ubuntu specific changes by Adam Faherty!!
 * Source: www.javacodegeeks.com/2013/08/file-upload-example-in-servlet-and-jsp.html
 * 
 */
public class FileUploadHandler extends HttpServlet {
   
    // direct where uploaded file will be stored
    private final String UPLOAD_DIRECTORY = "student/upload";
    
    /**
     * This does what?
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output exception
     */
    //@Override //override 
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
    
        if (ServletFileUpload.isMultipartContent(request)) {
            
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                 
                for (FileIte item : multipats) {
                    
                    if (!item.isFormField())) {
                        
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator 
                                + name));
                    }
                }
                
                //File upload success
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Failed to Upload due to " 
                        + ex);
            }
            
        } else {
        
            request.setAttribute("message", "Sorry this Servlet only handles"
                    + "file upload request");     
        }
    
        request.getRequestDispatcher("/result.jsp").forward(request, respond);
    }
}
