package com.kitchenApp.database;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.apache.log4j.Logger;

/**
 * @author afaherty
 * 11/2/2015
 */

public class DOAMain {

    private static final Logger log = Logger.getLogger(DOAMain.class);
    /**
     * main processing method of this test
     * @param args
     */
    public static void main(String[] args) {

        UserRoleDao dao = new UserRoleDao();
        UserRole userRole = new UserRole();
        //dao.getUserRole("afaherty");
        System.out.println(dao.getUserRoleList());

    }
}
