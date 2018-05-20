/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.web.MyLibrery;
import com.web.helper.HelperFileUserUpload;

import com.web.modelFileUser.Fileuser;
import java.io.File;

import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
import static org.apache.commons.fileupload.FileUploadBase.isMultipartContent;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
//org.apache.commons.fileupload.servlet.ServletFileUpload
//  org.apache.commons.fileupload.disk.
//org.apache.commons.fileupload.servlet.
// org.apache.commons.fileupload.

/**
 *
 * @author Utente
 */
public class ControllerUploadFile extends HttpServlet {

    private HelperFileUserUpload helperUploadFileUser;

    public ControllerUploadFile() {
        helperUploadFileUser = new HelperFileUserUpload();
    }

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       getFile(request, response );

      
        // doPost( request,  response);
   }

    private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    /**
     * *
     * @Override protected void doGet(HttpServletRequest request,
     * HttpServletResponse response) throws ServletException, IOException {
     * processRequest(request, response); }
     */

    /* */// @Override
    protected void getFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);

        boolean isMultipart = false;
        String filePath = null;
        int maxFileSize = 1000000000 * 1000000000;
        int maxMemSize = 1000000000 * 1000000000;
        File file = null;

        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");//

        init();

        // Check that we have a file upload request
        isMultipart = isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("C:/Users/Utente/Music/tmp/"));
        //C:/Users/Utente/Music/solo_se_me_occurre_amarte_Ajenadro_Sanz.mp4
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        boolean risp=true;
        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();
            
            String desc= request.getParameter("descrizione_");
            String tit =  request.getParameter("titolo_") ;

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    if (file != null) {
                        //*******************USO DEL DATABASE XAMMP*******************
                      
                        byte[] b = MyLibrery.getBytesFromFile(file);
                        //*******************************************************
                        out.print("lengt bytes array [] --->> " + b.length);
                        Fileuser fu = new Fileuser();
                        //*******************************************************
                        //fu.setCodfile(new Long(1));
                        fu.setData(new Date());
                        fu.setTitolo(tit);
                        fu.setDescrizione(desc);
                        fu.setFile(b);
                        risp =helperUploadFileUser.uploadFile(fu);  
                        if(!risp){
                            out.println("<h1>INSERIMENTO FATTOO!!!! </h1>");
                            out.println("Uploaded Filename: ========= " + fileName + "<br>");
                            out.println("Uploaded fieldName: ========= " + fieldName + "<br>");
                            out.println("Uploaded contentType: ========= " + contentType + "<br>");
                            out.println("Uploaded isInMemory: isInMemory " + isInMemory + "<br>");
                            out.println("Uploaded sizeInBytes: sizeInBytes " + sizeInBytes + "<br>");
                            out.println("(\"descrizione\") " + desc + "<br>");
                            out.println("(\"titolo\") " +  tit + "<br>");
                        }else
                            request.getRequestDispatcher("/success.jsp").forward(request, response);
                        //*******************************************************
                      // 
                    } else if (file == null) {
                        //this.forward(request, response, "/fail.jsp");
                        request.getRequestDispatcher("/fail.jsp").forward(request, response);
                    }
                    //  request.getRequestDispatcher("/success.jsp").forward(request, response);
                    // this.forward(request, response, "/success.jsp");
                }
            }

             this.forward(request, response, "/fail.jsp");
            //  request.getRequestDispatcher("/success.jsp").forward(request, response);
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
