/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.web.modelFileUser.Fileuser;
import com.web.util.SessionFactorySingleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Marco Pavon
 */
public class TestHibernate {

    private static SessionFactory sessionFactory;
    private static Session session = null;

    protected static void setUp() throws Exception {

        // Otteniamo una SessionFactory per la nostra applicazione
        sessionFactory = new Configuration().configure() // configura la SessionFactory utilizzando l' hibernate.cfg.xml
                .buildSessionFactory();

        //aggiunta mia apro session quindi creo un obj session
        session = sessionFactory.openSession();
    }

    /**
     * Le ultime due istruzioni sono banali, esse servono una a creare una
     * SessionFactory, ovvero un oggetto thread-safe in grado di generare
     * session l'altra invece serve a generare una sessione, una unit of work,
     * un'oggetto NON thread safe in grado di rappresentare la conversazione con
     * il persistence context e il db. SessionFactory sf =
     * configuration.buildSessionFactory(); Session ses = sf.openSession();
     */
    protected static void initSession() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();//
        session = sessionFactory.openSession();
    }

    protected static void shutDown() throws Exception {

        if (sessionFactory != null) {

            sessionFactory.close();

        }

    }

    public void testBasicUsage() {

        // creiamo ed inseriamo degli eventi
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.getTransaction().commit();

        session.close();

        // visualizziamo gli eventi memorizzati su db
        session = sessionFactory.openSession();

        session.beginTransaction();

        List<Fileuser> result = session.createQuery("from Fileuser").list();

        for (Fileuser fileUser : (List<Fileuser>) result) {
            System.out.println("" + fileUser);
        }

        session.getTransaction().commit();

        session.close();

    }

    protected static void getAll() throws Exception {

        // Session session =  HibernateUtil.getSessionFactory().openSession();
        //initSession();
        setUp();

        session.beginTransaction();
        Query query = session.createQuery("from Fileuser");
        List<Fileuser> l = (List<Fileuser>) query.list();

        for (Fileuser file : l) {
            System.out.println("\n\t" + " file nome " + file.getCodfile());
            System.out.println("\n\t" + " file titolo " + file.getTitolo());
            System.out.println("\n\t" + " file desc " + file.getDescrizione());
            System.out.println("\n\t" + " file data " + file.getData());
            System.out.println("\n\t" + " file data " + file.getFile().toString());
            System.out.println("\n");
        }
    }

    protected static void insert() throws Exception {
        try {
            Fileuser fu = new Fileuser();
            fu.setCodfile(new Long(11));
            fu.setData(new Date());
            fu.setTitolo("foto");
            // File file = new File("C:\\myRepoFiles\\");
            fu.setFile(null);
            session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(fu);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                session.close();
                System.out.println(" ERRORE " + ex.getMessage());
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main(String arg[]) throws Exception {

        /*TestHibernate test= new TestHibernate();

        test.setUp();

        test.testBasicUsage();

        test.shutDown();*/
        insert();
        getAll();
        shutDown();

    }

    // C:\\myRepoFiles\\
    

}
