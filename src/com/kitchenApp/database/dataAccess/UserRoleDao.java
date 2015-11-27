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

    /**
     * Updates users role within the application
     * @param UserRoleId reference to users role id number
     * @param userRoleType reference to the type of role user has within application
     */
    public void updateUserRole(Integer UserRoleId, String userRoleType) {

        beginSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            UserRole userRole =
                    (UserRole)session.get(UserRole.class, UserRoleId);
            userRole.setUserRole(userRoleType);
            session.update(userRole);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * allows admin to delete user from database
     * @param userRoleId reference to primary key in user_role table
     */
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

    /**
     * opens a new session for a hibernate transaction
     */
    public void beginSession() {

         session = SessionFactoryProvider.getSessionFactory().openSession();
    }
}
