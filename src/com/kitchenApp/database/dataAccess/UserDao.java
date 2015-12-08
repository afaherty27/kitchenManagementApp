package com.kitchenApp.database.dataAccess;

import com.kitchenApp.database.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for users table
 * @author afaherty
 */
public class UserDao {

    private Session session;
    private final Logger log = Logger.getLogger(this.getClass());

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

            e.printStackTrace();
            log.error(e);

            if (transaction != null) {

                log.debug("performing rollback");
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return userId;
    }

    /**
     * Retrieves user data from database
     * @param userId reference to userId in database
     * @return user
     */
    public User getUser(int userId) {

        beginSession();
        User user = null;

        try {

            user = (User) session.get(User.class, userId);

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

        } finally {

            session.close();
        }

        return user;
    }

    /**
     * Retrieves a list of users in database
     * @return users
     */
    public List getUserList() {

        List<User> users = new ArrayList<>();

        beginSession();

        //criteria
        Criteria criteria = session.createCriteria(User.class);
        try {

            users = criteria.list(); //may need to edit for employee contact list

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

        } finally {

            session.close();
        }

        return users;
    }

    /**
     * Updates users information in the database
     * @param UserId reference to primary key in database
     * @param address reference to users address
     * @param email reference to users email
     * @param phone reference to users phone
     */
    public void updateUser(Integer UserId, String address, String phone, String email) {

        beginSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            User user = (User)session.get(User.class, UserId);

            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);

            session.update(user);
            tx.commit();

        }catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

            if (tx != null) {

                log.debug("performing rollback");
                tx.rollback();
            }

        }finally {

            session.close();
        }
    }

    /**
     * method to delete user from database
     * @param userId reference to user id in database
     */
    public void deleteUser(Integer userId) {

        beginSession();
        Transaction trans = null;

        try {
            trans = session.beginTransaction();
            User user = (User)session.get(User.class, userId);
            session.delete(user);
            trans.commit();

        } catch (HibernateException e) {

            e.printStackTrace();
            log.error(e);

            if (trans != null) {

                log.debug("performing rollback");
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
