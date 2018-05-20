/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.helper;

import com.web.modelFileUser.Fileuser;
import com.web.util.SessionFactorySingleton;
import org.hibernate.Session;

/**
 *
 * @author Utente
 */
public class HelperFileUserUpload {
    
    
    Session session;
    
    
        //salvataggio
     public boolean uploadFile(Fileuser fileUser) {
        try {
            session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(fileUser);//persist.(fileUser);//.
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                session.close();
                System.out.println(" ERRORE " + ex.getMessage() );
            }
            ex.printStackTrace();
            return false;
        } //finally {
          //  session.close();
       // }
        return true;
    }
 
   
}
