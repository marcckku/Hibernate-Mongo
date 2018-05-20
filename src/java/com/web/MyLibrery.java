/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import com.web.controller.ControllerUploadFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utente
 */
public class MyLibrery {
    
    
    
    
    
    
     public static byte[] getBytesFromFile(File f) {
        FileInputStream fis = null;
        byte[] arrb = null;
         int index = 0;
        try {
            fis = new FileInputStream(f);

            try {
                arrb = new byte[fis.available()]; // [268435456] ; ///1048576
            } catch (IOException ex) {
                Logger.getLogger(ControllerUploadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // new input stream created
                fis = new FileInputStream(f.getPath()); //"C://test.txt"
                System.out.println("Characters printed:");
                int i = 0;
               
                // reads till the end of the stream
                while ((i = fis.read()) != -1) {
                    // converts int to byte
                    byte b = (byte) i;
                    // prints character
                    arrb[index++] = b;
                }
            } catch (Exception e) {
                // if any I/O error occurs
                e.printStackTrace();
            } finally {
                // releases system resources associated with this stream
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ControllerUploadFile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerUploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ControllerUploadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        byte [] barr=new byte [index];
        for(int i=0; i < arrb.length ; i++)
            barr[i] = arrb[i];
        
        return barr;
    }
    
    
}
