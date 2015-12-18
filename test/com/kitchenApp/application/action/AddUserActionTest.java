package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for AddUserAction class
 * @author afaherty
 * @version 1.0 on 12/17/2015
 */
public class AddUserActionTest {

    private int ID_PLACEHOLDER = 0;
    private String userName = "userNameTest";
    private String roleType = "roleTypeTest";
    private String password = "passwordTest";
    private String address = "addressTest";
    private String phone = "testPhone";
    private String email = "testEmail";


    /**
     * Test case for addUserData method
     */
    @Test
    public void addUserData() {

        UserDao userDao = new UserDao();

        AddUserAction add = new AddUserAction();
        int listLength = userDao.getUserList().size();

        add.addUserData(userName,password,address, phone, email, roleType);

        assertNotNull(add);
        assertTrue("list size should be larger than held size", listLength < userDao.getUserList().size() );
    }

    /**
     * Cleans test data out of database
     */
    @After
    public void after() {

        UserDao userDao = new UserDao();
        UserRoleDao userRoleDao = new UserRoleDao();
        UserRole role = new UserRole(0, "ref", "ref");
        User user = new User(0, "ref", "ref", "ref", "ref", "ref", role);
        userRoleDao.addUserRole(role);
        userDao.addUser(user);

        userDao.deleteUser(user.getUserId());
        userDao.deleteUser(user.getUserId() - 1);
        userRoleDao.deleteUserRole(role.getRoleId());
        userRoleDao.deleteUserRole(role.getRoleId() - 1);
    }

}
