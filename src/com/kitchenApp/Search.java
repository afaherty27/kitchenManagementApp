package com.kitchenApp;

import java.util.*;

/**
 * @author afaherty
 */

public class Search {

    private String searchTerm = "";
    private List<Employee> searchList;
    private boolean employeeFound;

    /**
     * Zero value constructor.  Instantiates the searchList as an ArrayList
     */
    public Search() {

        searchList = new ArrayList<>();
    }

    /**
     *
     * @return searchTerm value of searchTerm String
     */
    public String getSearchTerm() {

        return searchTerm;
    }

    /**
     *
     * @return value of employeeFound boolean
     */
    public boolean getEmployeeFound() {

        return employeeFound;
    }

    /**
     * Sets the value of employeeFound
     * @param employeeFound value assigned to employeeFound
     */
    public void setEmployeeFound(boolean employeeFound) {

        this.employeeFound = employeeFound;
    }


    public void addFoundEmployee(Employee employee) {

        searchList.add(employee);
    }
}
