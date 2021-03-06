package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for UpdateUserAction class
 * @author afaherty
 * @version 1.0 on 12/17/2015
 */
public class UpdateUserActionTest {

    private User user;
    private UserDao userDao = new UserDao();
    private UserRole role;
    private UserRoleDao userRoleDao = new UserRoleDao();
    private UpdateUserAction update = new UpdateUserAction();

    /**
     * creates user & roles to refer to at the end of the test.  Adds to database.
     */
    @Before
    public void before() {
        role = new UserRole(0, "refRole", "refUserName");
        user = new User(0, "refUserName", "refPass", "refAddress", "refPhone", "refEmail", role);
        userRoleDao.addUserRole(role);
        userDao.addUser(user);
    }

    /**
     *  method test for updateUserData method
     */
    @Test
    public void updateUserData() {

        String idString = String.valueOf(user.getUserId());
        String preUpdate = String.valueOf(userDao.getUser(user.getUserId()));

        update.updateUserData(idString, "updateAddress", "updatePhone", "updateEmail", userDao);

        String postUpdate = String.valueOf(userDao.getUser(user.getUserId()));

        assertTrue("updating incorrect user id", idString.equals(String.valueOf(user.getUserId())));
        assertFalse("user data update failed", preUpdate.equals(postUpdate));
        assertTrue("UpdateUserAction object not instantiated", update != null);

    }

    /**
     * method test for updateUserRoleData method
     */
    @Test
    public void updateUserRoleData() {

        //System.out.println(String.valueOf(userDao.getUser(user.getUserId())));

        String idString = String.valueOf(user.getUserId());
        System.out.println("id used"  + idString);
        System.out.println("user id: " + user.getUserId() + " role id: " + user.getRole().getRoleId());
        String preUpdate = String.valueOf(userRoleDao.getUserRole(role.getRoleId()));
        System.out.println("preupdate: " + preUpdate);

        update.updateUserRoleData(idString, "updateRole", userDao, userRoleDao);

        String postUpdate = String.valueOf(userRoleDao.getUserRole(role.getRoleId()));

        assertTrue("updating incorrect user role id", user.getRole().getRoleId() == role.getRoleId());
        assertFalse("user role data update failed", preUpdate.equals(postUpdate));
        assertNotNull("UpdateUserAction object not instantiated", update);
    }

    /**
     * Cleans test data out of database
     */
    @After
    public void after() {

        userDao.deleteUser(user.getUserId());
        userRoleDao.deleteUserRole((role.getRoleId()));
    }
}
