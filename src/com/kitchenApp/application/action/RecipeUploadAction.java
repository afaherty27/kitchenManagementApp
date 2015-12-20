package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.RecipeDao;
import com.kitchenApp.database.entity.Recipe;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Adds recipe data to database
 * @author afaherty
 * @version 1.0 on 12/8/2015
 */
public class RecipeUploadAction {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Handles file uploading
     * @param fileName reference to name of file being uploaded
     * @param filePart reference to the form field value containing the file uploaded
     * @param UPLOAD_DIRECTORY directory file is loaded into application
     * @throws IOException if there is an IOException
     */
    public void uploadFileToServer(String fileName, Part filePart, String UPLOAD_DIRECTORY) throws IOException {

        File file = new File(UPLOAD_DIRECTORY , fileName);

        try (InputStream fileContent = filePart.getInputStream()) {

            log.debug("attempting to upload file");
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        log.info(fileName + " was uploaded successfully");
    }

    /**
     * adds recipe data to database
     * @param filePath ref to recipe file location
     * @param category ref to category of recipe
     * @param recipeName ref to recipe name
     * @return recipe
     */
    public Recipe addRecipeData(String filePath, String category, String recipeName) {

        RecipeDao dao = new RecipeDao();

        Recipe recipe = new Recipe(0, filePath, category, recipeName);

        dao.addRecipe(recipe);

        log.debug(recipe.toString());

        return recipe;
    }
}
