package com.kitchenApp.com.kitchenApp.database;

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
    private int phone;
    private int social;


    /**
     * Overloaded constructor for a User Object
     * @param userId  ref to users ID number
     * @param userName ref to users name
     * @param password ref to users password
     * @param address ref to users address
     * @param email ref to users email
     * @param social ref to users social security number
     */
    public User(int userId, String userName, String password, String address, String email,
                int phone, int social) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this. social = social;
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
    public int getPhone() {
        return phone;
    }

    /**
     * Set value of phone
     * @param phone value of users phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Receive value of social
     * @return social
     */
    public int getSocial() {
        return social;
    }

    /**
     * Set value of social
     * @param social value of users social
     */
    public void setSocial(int social) {
        this.social = social;
    }


}