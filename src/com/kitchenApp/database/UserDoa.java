package com.kitchenApp.database;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;


/**
 *
 * @author afaherty
 */

public class UserDoa {

    private final Logger logger = Logger.getLogger(UserDoa.class);

    public User addUser(String userName, String userPass, String address, int phone,
                        String email, int social) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userId = 0;

        try {
            transaction = session.beginTransaction();
            User user = new User(userName, userPass, address, email, phone, social);
            userId = (int) session.save(user);

            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
                //logger.info(e.printStackTrace());
            }
        } finally {
            session.close();
        }

        return null; // TODO change value
    }

    // TODO getUser(int userId)

    // TODO getAllUsers()

    // TODO updateUser(User user)

    // TODO deleteUser(User user)


}
