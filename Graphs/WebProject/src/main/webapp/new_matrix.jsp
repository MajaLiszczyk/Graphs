<%-- 
    Document   : new_matrix
    Created on : 30 maj 2024, 18:39:25
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet NewMatrixServlet</title>
    </head>
    <body>
        <div class="container">
            <div id="title">
                <h1>New Matrix </h1>
            </div>
            <div class="box">
               <form action= "Size">
                   <div id="withTextBox">
                       <div>
                            Set size of the matrix:
                            <input type=text class="txBox" name=size>
                        </div>
                        <div>
                            Set name of the matrix: 
                            <input type=text class="txBox" name=nameMatrix>
                            
                        </div>
                       <input type="submit" value="OK" /> 
                   </div> 
                </form>
            </div>
        </div>
    </body>
</html>
