package com.kitchenApp.database.dataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * @author sasdfd
 */

public class SessionFactoryProvider {


    private static SessionFactory sessionFactory;

    /**
     * Instantiates a new SessionFactory object.  Loads configuration details.
     */
    public static void createSessionFactory() {

        Configuration config = new Configuration(); // new Configuration obj

        // use mappings and properties specified in hibernate.cfg.xml
        config.configure();

        //build on ServiceRegistry inst. Apply value of config var
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();
        //apply all properties

        //instantiate new SessionFactory using properties & mappings
        sessionFactory = config.buildSessionFactory(registry);

    }

    /**
     * Instantiates a SessionFactory if none exists
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null) {

            createSessionFactory();

        }

        return sessionFactory;
    }
}
