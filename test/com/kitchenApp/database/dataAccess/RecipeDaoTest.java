package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.Recipe;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void getRecipe() throws HibernateException {

        dao.addRecipe(recipe);

        dao.getRecipe(recipe.getRecipeId());

        assertEquals(String.valueOf(dao.getRecipe(recipe.getRecipeId())), recipe.toString());
        assertFalse(recipe.getRecipeId() == 1);

        dao.deleteRecipe(recipe.getRecipeId());
    }


    /**
     * method test for getRecipeList method
     */
    @Test
    public void getRecipeList() throws HibernateException {

        List list = dao.getRecipeList();

        int i; //reference to count of messages in database

        for (i = 0; i < list.size(); i++) {
            i++;
        }

        assertNotNull("list is not null", list.size());
        assertTrue(list.size() == i); //line runs strange.  sometimes need " - 1" sometimes dont
    }

    /**
     * method test for updateRecipe method
     */
    @Test
    public void updateRecipe() throws HibernateException {

        dao.addRecipe(recipe);

        String recipePre = String.valueOf(dao.getRecipe(recipe.getRecipeId()));
        dao.updateRecipe(recipe.getRecipeId(), "update", "update", "update");
        String recipePost = String.valueOf(dao.getRecipe(recipe.getRecipeId()));

        Transaction tx = null;
        assertFalse(tx != null);

        assertFalse("user data should not be same", recipePre.equals(recipePost));
        assertEquals("New Recipe: update Location: update Catagory: update",
                String.valueOf(dao.getRecipe(recipe.getRecipeId())));

        dao.deleteRecipe(recipe.getRecipeId());
    }

    /**
     * method test for deleteRecipe method
     */
    @Test
    public void deleteRecipe() throws HibernateException {

        dao.addRecipe(recipe);

        int listLength = dao.getRecipeList().size();
        assertNotNull("integer is null", recipe.getRecipeId());

        dao.deleteRecipe(recipe.getRecipeId());

        assertTrue("post delete list size must be smaller than pre delete",
                listLength > dao.getRecipeList().size());
        assertNull("recipe data should not exist", dao.getRecipe(recipe.getRecipeId()));

        Transaction tx = null;
        assertFalse(tx != null);
    }
}
