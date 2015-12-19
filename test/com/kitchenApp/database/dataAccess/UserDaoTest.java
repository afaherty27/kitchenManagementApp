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

    private User user;
    private UserRole role;
    private UserRoleDao roleDao;
    private UserDao dao;

    /**
     * Instantiates a UserRole object to be used in each method. Adds to database.
     */
    @Before
    public void before() {

        role = new UserRole(0, "role", "name");
        user = new User(0, "test", "test", "test", "test", "test", role);

        roleDao = new UserRoleDao();
        dao = new UserDao();

        roleDao.addUserRole(role);
    }

    /**
     * method test for addUser method
     */
    @Test
    public void addUser() throws HibernateException {


        dao.addUser(user);

        assertEquals("New User:  test test test test test " + role.getRoleId() ,
                String.valueOf(dao.getUser(user.getUserId())));
        assertNotNull("integer is null", user.getUserId());

        roleDao.deleteUserRole(role.getRoleId());
        dao.deleteUser(user.getUserId());

    }

    /**
     * method test for getUser method
     */
    @Test
    public void getUser() throws HibernateException {


    }


    /**
     * method test for getUserList method
     */
    @Test
    public void getUserList() throws HibernateException {

    }

    /**
     * method test for updateUser method
     */
    @Test
    public void updateUser() throws HibernateException {

    }

    /**
     * method test for deleteUser method
     */
    @Test
    public void deleteUser() throws HibernateException {

        dao.addUser(user);

        int listLength = dao.getUserList().size();
        assertNotNull("integer is null", user.getUserId());

        roleDao.deleteUserRole(role.getRoleId());
        dao.deleteUser(user.getUserId());

        assertTrue("post delete list size must be smaller than pre delete",
                listLength > dao.getUserList().size());
        assertNull("user should not exist", dao.getUser(user.getUserId()));
    }

    @After
    public void after() {


    }
}
