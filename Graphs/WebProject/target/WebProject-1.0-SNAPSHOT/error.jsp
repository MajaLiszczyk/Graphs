<%-- 
    Document   : error
    Created on : 30 maj 2024, 21:26:55
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet ErrorServlet</title>
    </head>
    <body>
        <div class="container">
            <div id="title">
                <h1>Error</h1>
            </div>
            <div class="box">
                <%String s = (String)request.getAttribute("error"); %>
                <form action= "Return">
                    <%=s%>
                    <input type="submit" value="Try again"></p>
                </form>
            </div>
        </div>       
    </body>
</html>
