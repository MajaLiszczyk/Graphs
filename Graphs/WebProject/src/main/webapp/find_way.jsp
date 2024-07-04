<%-- 
    Document   : find_way
    Created on : 30 maj 2024, 20:13:56
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet FindWay</title>
    </head>
    <body>
        <div id="container">
            <div id="title">
                <h1>Result</h1>
            </div>
            <div id="box">                      
                <%String cost = (String)session.getAttribute("cost");%>
                The lowest cost is: <%=cost %>
                <form action= "Calculation">
                    <input type="submit" value="Return"></p>
                </form>
            </div>
            <form action= "Return">
                <input type="submit" id="returnSubmit" value="Start from the begginig"></p>
            </form>
            </div>
    </body>
</html>
