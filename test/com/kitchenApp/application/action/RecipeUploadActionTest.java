package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.RecipeDao;
import com.kitchenApp.database.entity.Recipe;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.Part;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test class for RecipeUploadAction
 * @author afaherty
 * @version 1.0 on 12/18/2015
 */
public class RecipeUploadActionTest {

    private String filePath = "C:/testRecipePath";
    private String category = "testCategory";
    private String recipeName = "test name";
    private Recipe recipe;
    private RecipeDao dao;

   @Before
   public void before() {
       recipe = new Recipe(0, filePath, category, recipeName);
       dao = new RecipeDao();
       dao.addRecipe(recipe);
   }

    @Test
    public void addRecipeData() {

        RecipeUploadAction upload = new RecipeUploadAction();

        int listLength = dao.getRecipeList().size();

        upload.addRecipeData(filePath, category, recipeName);

        assertNotNull(upload);
        assertTrue("list size should be larger than held size", listLength < dao.getRecipeList().size() );
    }

    @After
    public void after() {

        dao.deleteRecipe(recipe.getRecipeId());
        dao.deleteRecipe(recipe.getRecipeId() - 1);
    }
}
