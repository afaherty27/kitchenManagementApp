package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.Recipe;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for RecipeDao class
 * @author afaherty
 * @version 1.0 on 12/18/2015
 */
public class RecipeDaoTest {

    private Recipe recipe;
    private RecipeDao dao = new RecipeDao();

    @Before
    public void before() {

        recipe = new Recipe(0, "testPath", "testCat", "testName");
    }

    /**
     * method test for addRecipe method
     */
    @Test
    public void addRecipe() throws HibernateException {

        dao.addRecipe(recipe);

        assertEquals("testPath", recipe.getFilePath());
        assertNotNull("recipeId was not created", recipe.getRecipeId());

        dao.deleteRecipe(recipe.getRecipeId());
    }

    /**
     * method test for getRecipe method
     */
    @Test
    public void getRecipe() {

    }


    /**
     * method test for getRecipeList method
     */
    @Test
    public void getRecipeList() {

    }

    /**
     * method test for updateRecipe method
     */
    @Test
    public void updateRecipe() {

    }

    /**
     * method test for deleteRecipe method
     */
    @Test
    public void deleteRecipe() {

    }
}
