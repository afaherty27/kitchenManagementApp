package com.kitchenApp.database.entity;

/**
 * JavaBean class for recipe table
 * @author afaherty
 * @version 1.0 on 12/8/2015
 */
public class Recipe {

    private int recipeId;
    private String filePath;
    private String category;
    private String recipeName;

    /**
     * zero arg constructor
     */
    public Recipe() {

    }

    /**
     * Overloaded Recipe Constructor
     * @param recipeId ref to recipe id in database
     * @param filePath ref to recipe filepath
     * @param category ref to recipe catagory
     * @param recipeName ref to recipe name
     */
    public Recipe(int recipeId, String filePath, String category, String recipeName) {

        this.recipeId = recipeId;
        this.filePath = filePath;
        this.category = category;
        this.recipeName = recipeName;
    }

    /**
     * retrieves recipeId
     * @return recipeId
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * sets recipeId value
     * @param recipeId ref to recipe id in database
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * retrieves recipes filepath
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * sets recipeFile path
     * @param filePath ref to recipe file path in database
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * retrieves recipe category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * sets recipe catagory
     * @param category ref to recipe catagory in database
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * retrieves recipe name
     * @return recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * sets recipe name
     * @param recipeName ref to recipe name in database
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String toString() {

        return "New Recipe: " + recipeName +
                " Location: " + filePath +
                " Catagory: " + category;
    }

}
