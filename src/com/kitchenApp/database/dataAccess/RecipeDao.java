package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.Recipe;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for recipe table in database
 * @author afaherty
 * @version 1.0 on 12/8/2015
 */

public class RecipeDao {

    private Session session;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method to add a recipe to the database
     * @param recipe Recipe object reference
     * @return userRoleId
     */
    public Integer addRecipe(Recipe recipe) {

        beginSession();
        Transaction trans = null;
        Integer recipeId = null;

        try {

            trans = session.beginTransaction();
            recipeId = (Integer) session.save(recipe);
            trans.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

            if (trans != null) {

                log.debug("performing rollback");
                trans.rollback();
            }

        } finally {

            session.close();
        }

        return recipeId;
    }

    /**
     * To retrieve user role data relating to an individual employee
     * @param recipeId reference to recipeid in database
     * @return userRoleId
     */
    public Recipe getRecipe(int recipeId) {

        beginSession();
        Recipe recipe = null;

        try {

            recipe = (Recipe) session.get(Recipe.class, recipeId);

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

        } finally {

            session.close();
        }

        return recipe;
    }

    /**
     * Retrieves a list of all recipes in the database
     * @return recipes
     */
    public List getRecipeList() {

        List<Recipe> recipes = new ArrayList<>();

        beginSession();

        //criteria
        Criteria criteria = session.createCriteria(Recipe.class);
        try {

            recipes = criteria.list();

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

        } finally {

            session.close();
        }

        return recipes;
    }

    /**
     * updates recipe through the web app
     * @param RecipeId ref to recipe id in database
     * @param filePath ref to recipe file path in database
     * @param category ref to recipe catagory in database
     * @param recipeName ref to recipe name in database
     */
    public void updateRecipe(Integer RecipeId, String filePath, String category, String recipeName) {

        beginSession();
        Transaction tx = null;

        try{

            tx = session.beginTransaction();
            Recipe recipe = (Recipe)session.get(Recipe.class, RecipeId);
            recipe.setFilePath(filePath);
            recipe.setCategory(category);
            recipe.setRecipeName(recipeName);

            session.update(recipe);
            tx.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

            if (tx != null) {

                log.debug("performing rollback");
                tx.rollback();
            }

        } finally {

            session.close();
        }
    }

    /**
     * allows admin to delete recipe from database
     * @param recipeId reference to primary key in user_role table
     */
    public void deleteRecipe(Integer recipeId) {

        beginSession();
        Transaction trans = null;

        try {

            trans = session.beginTransaction();
            Recipe recipe = (Recipe)session.get(Recipe.class, recipeId);
            session.delete(recipe);
            trans.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

            if (trans != null) {

                log.debug("performing rollback");
                trans.rollback();
            }
        } finally {

            session.close();
        }
    }

    /**
     * opens a new session for a hibernate transaction
     */
    public void beginSession() {

        session = SessionFactoryProvider.getSessionFactory().openSession();
    }
}
