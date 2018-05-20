/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.util;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Marco Pavon
 */
public class SessionFactorySingleton {

    //versione 1
    // @Autowired(required = true)
    /*  private static final SessionFactory sessionFactory=null;
    
    private static final Session session;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            session = sessionFactory.getCurrentSession();
           // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("FALLITA APERTURA SESSION-FACTORY !!! ERRORE INIZIALIZZAZIONE!!" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() {
        return session;
    }
     */
    //versione 2
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
           /* sessionFactory = new Configuration().configure() // configura la SessionFactory utilizzando l' hibernate.cfg.xml
                    .buildSessionFactory();*/
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();

            } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //versione 3
    /*  private static final SessionFactory sessionFactory=null;

    static {
		try {

			SessionFactory sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")    //classpath:/META-INF/resources/webjars/
					.addResource("Fileuser.hbm.xml")
					.buildSessionFactory();

			//return sessionFactory;

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
    
    
    
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
     */
}
