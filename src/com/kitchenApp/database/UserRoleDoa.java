package com.kitchenApp.database;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * @author afaherty
 * 11/2/2015
 */

public class UserRoleDoa {

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
}
