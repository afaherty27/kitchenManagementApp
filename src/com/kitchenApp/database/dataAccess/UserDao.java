package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

/**
 *
 * @author afaherty
 */

public class UserDao {

    private Session session;

    /**
     * Method to add user to the database
     * @param user User object reference
     * @return userId
     */
    public Integer addUser(User user) {

        beginSession();
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

    public void deleteUser(Integer userId) {

        beginSession();
        Transaction trans = null;

        try {
            trans = session.beginTransaction();
            User user = (User)session.get(User.class, userId);
            session.delete(user);
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
