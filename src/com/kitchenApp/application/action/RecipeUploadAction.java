package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.RecipeDao;
import com.kitchenApp.database.entity.Recipe;
import org.apache.log4j.Logger;

/**
 * Adds recipe data to database
 * @author afaherty
 * @version 1.0 on 12/8/2015
 */
public class RecipeUploadAction {

    private static final int ID_PLACEHOLDER = 0; //for hibernate auto increment

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * adds recipe data to database
     * @param filePath ref to recipe file location
     * @param category ref to category of recipe
     * @param recipeName ref to recipe name
     * @return recipe
     */
    public Recipe addRecipeData(String filePath, String category, String recipeName) {

        RecipeDao dao = new RecipeDao();
        Recipe recipe = new Recipe(ID_PLACEHOLDER, filePath, category, recipeName);

        dao.addRecipe(recipe);

        log.info(recipe.toString());

        return recipe;
    }
}
