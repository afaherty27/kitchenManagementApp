package com.kitchenApp;

import java.sql.*;

/**
 * @author afaherty
 */

public class DatabaseConnection {

    private Employee employee;
    private ResultSet resultSet = null;

    /**
     * Private method that will establish a connection to the database
     *
     * @return Reference to the database connection
     * @throws SQLException if there is a SQL error
     * @throws ClassNotFoundException if a Class is not found
     */
    private Connection establishConnection() throws SQLException, ClassNotFoundException {

        String url = "jdbc:mysql://localhost/student";
        String userName = "student";
        String password = "student";

        Connection connection = DriverManager.getConnection(url, userName, password);

        return connection;
    }

    public void retrieveUserRole(Search search) {

        createNewEmployee();

        try (Connection connection = this.establishConnection();
                Statement statement = connection.createStatement()) {

            String queryString = "SELECT * FROM user_roles"
                    + "WHERE user_name LIKE " + search.getSearchTerm();

            runQuery(queryString, statement);

            determineBooleanCondition(search);

            loopResultSet(search);
        } catch (ClassNotFoundException classNotFound) {

            System.err.println("Cannot find database driver");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {

            System.err.println("Error in connecting to database");
            sqlException.printStackTrace();
        } catch (Exception exception) {

            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    /**
     *  Executes queryString
     * @param queryString reference to SQL query command
     * @param statement reference to SQL statement\
     * @throws SQLException if    there is a SQL error
     */
    public void runQuery(String queryString, Statement statement) throws SQLException {

        resultSet =  statement.executeQuery(queryString);
    }

    /**
     * Instantiate a new Employee object
     * @return reference to Employee object
     */
    public Employee createNewEmployee() {

        employee = new Employee();
        return employee;
    }

    /**
     *
     * @param search Reference to a Serch object
     */
    public void determineBooleanCondition(Search search) {

        if (resultSet != null) {

            search.setEmployeeFound(true);
        } else {

            search.setEmployeeFound(false);
        }
    }

    /**
     * Loop resultSet to set employee data
     * @param search reference to Search object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void loopResultSet(Search search) throws SQLException, ClassNotFoundException {

        while (resultSet.next()) {

            if (search.getEmployeeFound() == true) {

                createNewEmployee();

                employee.setUserName(resultSet.getString("user_name"));
                employee.setUserRole(resultSet.getString("user_role"));

                search.addFoundEmployee(employee);
            }
        }
    }
}
