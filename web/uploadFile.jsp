<%-- 
    Document   : uploadFile
    Created on : 12-mag-2018, 18.22.12
    Author     : Utente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page uploadFile</title>
    </head>
    <body>
        <h1>uploadFile!</h1>


        <!-- 
        
                         private Long codfile;
     private String titolo;
     private String descrizione;
     private Date data;
     private byte[] file; 
            
        -->
        
        
        
        
        
        
        

        *///////////////Se vuoi puoi usare la query string  mappingAction?desc=COMIDAS DEL ECUADOR ma NON è sicuro/////////////////***
        
         <form method="POST" action="mappingAction?titolo=FOTO&descrizione=PROFILO" enctype="multipart/form-data" name="form_uploadFile">
            File:
            <label for="file_">FILE UPLOAD</label>
            <input type="file" name="file" id="file" /> <br/><br/>
            Destination:
            <input type="text" value="/tmp" name="destination"  id="dest"/><br/><br/>
            TITOLO
            <input type="text" name="titolo_"  id="tit"/><br/><br/>
            DESCRIZIONE
            <input type="text" name="descrizione_"  id="descr"/><br/><br/>
            </br>
            <input type="submit" value="Upload" name="upload" id="upload" />
        </form>

        *//////////////////////////////////////////***
<!--
        <div> 
            <h3>File Upload:</h3>
            Select a file to upload: <br />
            <form action="controllerUploadFileMapping" method="post"  enctype="multipart/form-data">
               TITOLO <input type="text" name="tit1" /> <br/> <br/>
               DESCRIZIONE <input type="text" name="desc1" /><br/> <br/>
                <input type="file" name="f1" size="500" /> <br />
                <input type="submit" value="Upload File" />
            </form>
        </div>

        -->
        <br/> <br/><br/> <br/>

        *//////////////////////////////////////////***

        *//////////////////////////////////////////***
 <!--       <div>  
            <form method="post" action="controllerUploadFileMapping" enctype="multipart/form-data">
                Select file to upload:
                <input type="file" name="f2" id="fileChooser"/><br/><br/>
                TITOLO<input type="text" name="tit2" /><br/> <br/>
                DESCRIZIONE<input type="text" name="desc2" /><br/> <br/>
                <input type="submit" value="Upload" />
            </form>

        </div>


-->








    </body>
</html>
