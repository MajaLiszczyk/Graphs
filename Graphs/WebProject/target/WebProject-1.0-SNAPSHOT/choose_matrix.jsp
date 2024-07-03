<%-- 
    Document   : choose_matrix
    Created on : 30 maj 2024, 18:54:09
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="pl.polsl.mliszczyk.model.Matrix" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet ChooseMatrixServlet</title>
    </head>
    <body>
        <div class="container">
            <div id="title">
                <h1>Choose Matrix</h1>
            </div>
            <div class="box">
            <form action= "Calculation">
            
                 <!--combobox with matrix -->
                <select name="matrixToChoose" id="matrixToChoose">
                <%
                List<Matrix> matrixList = (List<Matrix>)session.getAttribute("matrix");
                for (Matrix matrix : matrixList) { %>
                    <option value="<%= matrix.getID()%>"> <%= matrix.getMatrixName()%> </option>
                <% }
                %>
                </select>

                <input type="submit" value="I want to start calculation">
                </form>
                </div>

           
            
        </div>
       
    </body>
</html>
