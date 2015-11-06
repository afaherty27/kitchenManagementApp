package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

/**
 *
 * @author afaherty
 */

public class UserDoa {

    /**
     * Method to add user to the database
     * @param user User object reference
     * @return userId
     */
    public Integer addUser(User user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userId = null;

        try {

            transaction = session.beginTransaction();
            userId = (Integer) session.save(user);
            transaction.commit();

        } catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                //logger.info(e.printStackTrace());
            }
        } finally {
            session.close();
        }

        return userId;
    }

    // TODO getUser(int userId)

    // TODO getAllUsers()

    // TODO updateUser(User user)

    // TODO deleteUser(User user)


}
