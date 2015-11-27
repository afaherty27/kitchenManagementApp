package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.UserRole;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author afaherty
 * 11/2/2015
 */

public class UserRoleDao {

    private Session session;

    /**
     * Method to add a userRole to the database
     * @param userRole UserRole object reference
     * @return userRoleId
     */
    public Integer addUserRole(UserRole userRole) {

        //open new session
        beginSession();

        Transaction trans = null;
        Integer userRoleId = null;

        try {
            trans = session.beginTransaction();
            userRoleId = (Integer) session.save(userRole);
            trans.commit();

        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userRoleId;
    }

    /**
     * To retrieve user role data relating to an individual employee
     * @param userRoleId reference to user role id in database
     * @return userRoleId
     */
    public UserRole getUserRole(int userRoleId) {

        //open new session
        beginSession();

        UserRole userRole = null;

        try {
            userRole = (UserRole) session.get(UserRole.class, userRoleId);

            if (userRole != null) {
                return userRole;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userRole;
    }

    /**
     * Retrieves a list of all user roles in the database
     * @return userRoles
     */
    public List getUserRoleList() {

        List<UserRole> userRoles = new ArrayList<>();

        //open new session
        beginSession();

        //criteria
        Criteria criteria = session.createCriteria(UserRole.class);
        try {

            userRoles = criteria.list();
        } catch (HibernateException e) {

            e.printStackTrace();
        } finally {

            session.close();
        }

        return userRoles;
    }

    // TODO updateUser(User user)
    public void updateUserRole(Integer UserRoleId, String userRoleName) {


    }

    public void deleteUserRole(Integer userRoleId) {

        beginSession();

        Transaction trans = null;

        try {
            trans = session.beginTransaction();
            UserRole userRole = (UserRole)session.get(UserRole.class, userRoleId);
            session.delete(userRole);
            trans.commit();
        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
        } finally {
            session.close();
        }

    }

    public void beginSession() {

         session = SessionFactoryProvider.getSessionFactory().openSession();

        //return session;
    }
}
