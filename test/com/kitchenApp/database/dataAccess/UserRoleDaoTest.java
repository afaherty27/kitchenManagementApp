package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.UserRole;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    public void getUserRole() {

    }


    /**
     * method test for getUserRoleList method
     */
    @Test
    public void getUserListRole() {

    }

    /**
     * method test for updateUserRole method
     */
    @Test
    public void updateUserRole() {

    }

    /**
     * method test for deleteUserRole method
     */
    @Test
    public void deleteUserRole() {


    }
}
