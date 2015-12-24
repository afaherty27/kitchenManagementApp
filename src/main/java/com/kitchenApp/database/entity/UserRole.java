package com.kitchenApp.database.entity;

import java.util.Set;

/**
 * @author afaherty
 *  @version 2.0 on 11/2/2015
 */

public class UserRole {

    private int roleId;
    private String userName;
    private String userRole;

    /**
     * zero arg constructor
     */
    public UserRole() {

    }

    /**
     * loaded constructor for UserRole objects
     * @param userName value of user name
     * @param userRole value of user role
     */
    public UserRole(int roleId, String userRole,String userName) {

        this.roleId = roleId;
        this.userName = userName;
        this.userRole = userRole;
    }

    /**
     * recieves roleId value
     * @return roleId
     */
    public int getRoleId() {

        return roleId;
    }

    /**
     * Set value of roleId
     * @param roleId value of role Id
     */
    public void setRoleId(int roleId) {

        this.roleId = roleId;
    }

    /**
     * recieves userName value
     * @return userName
     */
    public String getUserName() {

        return userName;
    }

    /**
     * Set value of userName
     * @param userName value of users name
     */
    public void setUserName(String userName) {

        this.userName = userName;
    }

    /**
     * recieves userRole value
     * @return userRole
     */
    public String getUserRole() {

        return userRole;
    }

    /**
     * Set value of userRole
     * @param userRole value of users role
     */
    public void setUserRole(String userRole) {

        this.userRole = userRole;
    }

    /**
     * retrieves a Set object of User objects
     * @return user
     */
//    public Set<User> getUser() { return user; }

    /**
     * Sets a Set object of User objects
     * @param user ref to User object
     */
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }

    /**
     * Provides string data of users role information
     * @return string of user role details
     */
    public String toString() {
        return  "User " + " "
                + userName + " has been authorized as "
                + userRole;
    }
}
