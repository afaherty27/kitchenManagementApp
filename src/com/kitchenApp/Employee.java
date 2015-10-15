package com.kitchenApp;

/**
 * JavaBean class to receive user credential key values pairs
 *
 * @author afaherty
 * Date: 10/15/2015
 */

public class Employee {

    //declare instance variables
    private String user_name;
    private String user_role;


    /**
     * @return user_name value
     */
    public String getUserName() {
        return user_name;
    }

    /**
     * Sets the user_name value
     * @param user_name value assigned to user_name
     */
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return user_role value
     */
    public String getUserRole() {
        return user_role;
    }

    /**
     * Sets the user_role value
     * @param user_role value assigned to user_role
     */
    public void setUserRole(String user_role) {
        this.user_role = user_role;
    }
}
