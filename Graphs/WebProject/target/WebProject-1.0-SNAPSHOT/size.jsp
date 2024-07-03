<%-- 
    Document   : size
    Created on : 30 maj 2024, 20:45:13
    Author     : Maja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" href="css/style.css" type="text/css"/>
        <title>Servlet SizeServlet</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="jquery.scrollTo.min"></script>
    </head>
    <body>
        <div class="container">
            <a href="#" class="scrollup">
                <form action= "Return">
                <input type="submit" id="returnSubmit" value="Start from the begginig">
                </form>
            </a>
            <div id="title">
                <h1>Create your matrix</h1>
            </div>
            <div class="box">
                <p>Fill in the fields. Write x if it is infinity: </p>
                <!--Setup form begginig -->
                <form action= "Setup">
                    
                    <%
                    Integer size = (Integer)session.getAttribute("size");
                    for(int i = 0; i < size ; i++){ %>
                        <tr>
                        <%for(int j = 0; j < size ; j++){ %>
                            <td><input type="text" id="matrixElement" size=2 name="weight<%=i%><%=j%>" ></td>
                    <% } %>
                    <br/>
                    </tr>
                    <%}%>
                    <p><input type="submit" value="OK"></p>
                </form>
                    <!--Setup form end -->
            </div>
            <!--Return form beggining -->
            
           <!--Return form end -->
        </div>
        
    </body>
</html>
