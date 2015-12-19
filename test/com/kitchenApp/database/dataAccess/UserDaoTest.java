package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
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

        Transaction tx = null;
        assertFalse(tx != null);

        roleDao.deleteUserRole(role.getRoleId());
        dao.deleteUser(user.getUserId());
    }

    /**
     * method test for getUser method
     */
    @Test
    public void getUser() throws HibernateException {

        dao.addUser(user);

        dao.getUser(user.getUserId());

        assertEquals(String.valueOf(dao.getUser(user.getUserId())), user.toString());
        assertFalse(user.getUserId() == 4);

        roleDao.deleteUserRole(role.getRoleId());
        dao.deleteUser(user.getUserId());
    }

    /**
     * method test for getUserList method
     */
    @Test
    public void getUserList() throws HibernateException {

        List list = dao.getUserList();

        int i; //reference to count of messages in database

        for (i = 0; i < list.size(); i++) {
            i++;
        }

        assertNotNull("list is not null", list.size());
        // i - 1 -> i is getting incremented after final iteration, before exiting loop
        assertTrue(list.size() == i);
    }

    /**
     * method test for updateUser method
     */
    @Test
    public void updateUser() throws HibernateException {

        dao.addUser(user);

        dao.updateUser(user.getUserId(), "update", "update", "update", role.getRoleId());

        Transaction tx = null;
        assertFalse(tx != null);

        roleDao.deleteUserRole(role.getRoleId());
        dao.deleteUser(user.getUserId());
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

        Transaction tx = null;
        assertFalse(tx != null);
    }
}
