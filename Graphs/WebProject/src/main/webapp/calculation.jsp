<%-- 
    Document   : calculation
    Created on : 30 maj 2024, 19:23:58
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.lang.Integer" %>
<%@page import="pl.polsl.mliszczyk.model.Matrix" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet CalculationServlet</title>
    </head>
    <body>
        <div class="container">
            <div id="title">
                <h1>Find the way</h1>
            </div>
            <div class="box">
                <form action= "FindWay">
                <div>
                    <label class="label" for="nodesF">Choose start node: </label>
                    <select name="nodesF" id="nodesF">
                    <%
                        Matrix matrix = (Matrix)session.getAttribute("graph");
                        int size = matrix.getSize();
                        for(int i = 1; i <= size; i++){ %>
                            <option value="<%=i %>"> <%=Integer.toString(i) %> </option>
                        <% } %>
                    </select>
                    <div class="clear"></div>
                </div>
                <div>
                    <label class="label" for="nodesE">Choose end node: </label>
                    <select name="nodesE" id="nodesE">
                    <% for(int i = 1; i <= size; i++){ %>
                        <option value="<%=i %>"> <%=Integer.toString(i) %> </option>
                    <% } %>
                    </select>
                    <div class="clear"></div>
                </div>
                <input type="submit" value="Calculate">
                </form>
            </div>
            <form action= "Return">
                <input type="submit" id="returnSubmit" value="Start from the begginig">
            </form>
        </div>   
    </body>
</html>
