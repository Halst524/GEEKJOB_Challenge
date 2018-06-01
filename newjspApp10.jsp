<%-- 
    Document   : newjspApp10
    Created on : 2018/06/01, 13:33:22
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int th = 1000;
            while(th >= 100){
                th /= 2;
            }
            out.print(th);
        %>
    </body>
</html>
