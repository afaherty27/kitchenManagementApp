package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for UserDao class
 * @author afaherty
 * @version 1.0 on 12/18/2015
 */
public class UserDaoTest {

    private UserRole role;
    private UserRoleDao roleDao;

    /**
     * Instantiates a UserRole object to be used in each method. Adds to database.
     */
    @Before
    public void before() {
        role = new UserRole(0, "role", "name");
        roleDao = new UserRoleDao();
        roleDao.addUserRole(role);
    }

    /**
     * method test for addUser method
     */
    @Test
    public void addUser() throws HibernateException {

        UserDao dao = new UserDao();
        User user = new User(0, "test", "test", "test", "test", "test", role);

        try {
            dao.addUser(user);

            assertEquals("New User:  test test test test test " + role.getRoleId() ,
                    String.valueOf(dao.getUser(user.getUserId())));
            assertNotNull("integer is null", user.getUserId());


        } catch (HibernateException e) {
            fail("hibernate exception was caught");
        }

        dao.deleteUser(user.getUserId());
        roleDao.deleteUserRole(role.getRoleId());
    }

    /**
     * method test for getUser method
     */
    @Test
    public void getUser() {

    }


    /**
     * method test for getUserList method
     */
    @Test
    public void getUserList() {

    }

    /**
     * method test for updateUser method
     */
    @Test
    public void updateUser() {

    }

    /**
     * method test for deleteUser method
     */
    @Test
    public void deleteUser() {

    }
}
