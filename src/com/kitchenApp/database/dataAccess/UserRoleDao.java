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

    /**
     * Method to add a userRole to the database
     * @param userRole UserRole object reference
     * @return userRoleId
     */
    public Integer addUserRole(UserRole userRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

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

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

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
    public void updateUserRole(UserRole userRole) {

    }

    public void deleteUserRole(Integer userRoleId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
}
