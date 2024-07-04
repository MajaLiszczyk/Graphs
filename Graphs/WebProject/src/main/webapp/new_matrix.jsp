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
                       <label class="label">Set size of the matrix:</label>
                       <select name="size" id="size">
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                       </select>
                       <div class="clear"></div>
                            <!-- <input type=text class="txBox" name=size> -->
                       <label class="label">Set name of the matrix:</label>
                       <input type=text class="txBox" name=nameMatrix>
                       <div class="clear"></div>
                       <input type="submit" value="OK" /> 
                </form>
            </div>
        </div>
    </body>
</html>
