package com.kitchenApp.application.action;

import com.kitchenApp.database.dataAccess.UserDao;
import com.kitchenApp.database.dataAccess.UserRoleDao;
import com.kitchenApp.database.entity.User;
import com.kitchenApp.database.entity.UserRole;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class for DeleteUserAction class
 * @author afaherty
 * @version 1.0 on 12/17/2015
 */
public class DeleteUserActionTest {

    private User user;
    private UserDao userDao = new UserDao();
    private UserRole role;
    private UserRoleDao userRoleDao = new UserRoleDao();
    private DeleteUserAction delete = new DeleteUserAction();

    @Before
    public void before() {
        role = new UserRole(0, "refRole", "refUserName");
        user = new User(0, "refUserName", "refPass", "refAddress", "refPhone", "refEmail", role);
        userRoleDao.addUserRole(role);
        userDao.addUser(user);


    }

    @Test
    public void deleteUserData() {

        int listLength = userDao.getUserList().size();

        String idString = String.valueOf(user.getUserId());
        delete.deleteUserData(idString);

        //delete related user role from database
        userRoleDao.deleteUserRole((role.getRoleId()));

        assertNotNull("DeleteUserAction object not instantiated", delete);
        assertTrue("updating incorrect user id", idString.equals(String.valueOf(user.getUserId())));
        assertFalse("incorrect list size after delete", listLength <= userDao.getUserList().size());
    }

    @Test
    public void deleteUserRoleData() {

        int listLength = userRoleDao.getUserRoleList().size();

        String idString = String.valueOf(user.getUserId());
        delete.deleteUserRoleData(idString);

        //delete related user from database
        userDao.deleteUser(user.getUserId());

        assertNotNull("DeleteUserAction object not instantiated", delete);
        assertTrue("updating incorrect user role id", idString.equals(String.valueOf(role.getRoleId())));
        assertFalse("incorrect list size after delete", listLength <= userRoleDao.getUserRoleList().size());
    }
}
