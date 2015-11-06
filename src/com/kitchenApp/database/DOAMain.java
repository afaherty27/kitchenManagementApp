package com.kitchenApp.database;

/**
 * @author afaherty
 * 11/2/2015
 */

public class DOAMain {

    /**
     * main processing method of this test
     * @param args
     */
    public static void main(String[] args) {

        UserDoa doa = new UserDoa();
        User user = new User(0, "gfaherty", "gpassword", "123 Some St.", "1234567890", "gfaherty@domain.com", "1234567890");
        doa.addUser(user);
    }
}
