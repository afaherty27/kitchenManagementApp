package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Test class for UserRoleDao class
 * @author afaherty
 * @version 1.0 on 12/18/2015
 */
public class UserRoleDaoTest {

    private UserRole role;
    private UserRoleDao dao = new UserRoleDao();

    @Before
    public void before() {

        role = new UserRole(0, "testRole", "testName");
    }

    /**
     * method test for addUserRole method
     */
    @Test
    public void addUserRole() throws HibernateException {

        dao.addUserRole(role);

        assertEquals("testRole", role.getUserRole());
        assertNotNull("roleId was not created", role.getRoleId());

        dao.deleteUserRole(role.getRoleId());
    }

    /**
     * method test for getUserRole method
     */
    @Test
    public void getUserRole() throws HibernateException {

        dao.addUserRole(role);

        dao.getUserRole(role.getRoleId());

        assertEquals(String.valueOf(dao.getUserRole(role.getRoleId())), role.toString());
        assertFalse(role.getRoleId() == 1);

        dao.deleteUserRole(role.getRoleId());
    }


    /**
     * method test for getUserRoleList method
     */
    @Test
    public void getUserRoleList() throws HibernateException {

        List list = dao.getUserRoleList();

        int i; //reference to count of messages in database

        for (i = 0; i < list.size(); i++) {
            i++;
        }

        assertNotNull("list is not null", list.size());
    }

    /**
     * method test for updateUserRole method
     */
    @Test
    public void updateUserRole() throws HibernateException {

        dao.addUserRole(role);

        String rolePre = String.valueOf(dao.getUserRole(role.getRoleId()));
        dao.updateUserRole(role.getRoleId(), "update");
        String rolePost = String.valueOf(dao.getUserRole(role.getRoleId()));

        Transaction tx = null;
        assertFalse(tx != null);

        assertFalse("user data should not be same", rolePre.equals(rolePost));
        assertEquals("User  testName has been authorized as update", String.valueOf(dao.getUserRole(role.getRoleId())));

        dao.deleteUserRole(role.getRoleId());
    }

    /**
     * method test for deleteUserRole method
     */
    @Test
    public void deleteUserRole() {

        dao.addUserRole(role);

        int listLength = dao.getUserRoleList().size();
        assertNotNull("integer is null", role.getRoleId());

        dao.deleteUserRole(role.getRoleId());

        assertTrue("post delete list size must be smaller than pre delete",
                listLength > dao.getUserRoleList().size());
        assertNull("recipe data should not exist", dao.getUserRole(role.getRoleId()));

        Transaction tx = null;
        assertFalse(tx != null);
    }
}
