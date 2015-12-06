package com.kitchenApp.database.entity;

/**
 * @author afaherty
 * 10/30/2015
 */

public class User {

    // inst vars relating to DB columns w/get/set methods
    private int userId;
    private String userName;
    private String password;
    private String address;
    private String email;
    private String phone;

    /**
     * zero arg constructor
      */
    public User() {

    }

    /**
     * Overloaded constructor for a User Object
     * @param userId ref to users id number
     * @param userName ref to users name
     * @param password ref to users password
     * @param address ref to users address
     * @param email ref to users email
     */
    public User(int userId, String userName, String password, String address,  String phone,
                String email) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Receive userId value
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set value to userId
     * @param userId value of user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Receive userName value
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set value to userName
     * @param userName value of users name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Receive password value
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value of password
     * @param password value of users password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Receive value of address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value of address
     * @param address value of users address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Receive value of email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value of email
     * @param email value of users email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Receive value of phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set value of phone
     * @param phone value of users phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Provides string data of employee information
     * @return string of employee details
     */
    public String toString() {
        return  System.lineSeparator() +
                "New User: " + " "
                + userName + " "
                + password + " "
                + address + " "
                + email + " "
                + phone;
    }

}
