package com.kitchenApp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Creates a connection to the mySQL database
 * @author afaherty
 */

public class DBConnection {

    private Connection establishConnection() throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/student";
        String userName = "student";
        String userPassword = "student";

        Connection connection = DriverManager.getConnection(url, userName, userPassword);

        return connection;
    }
}
