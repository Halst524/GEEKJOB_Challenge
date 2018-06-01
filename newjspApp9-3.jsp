<%-- 
    Document   : newjspApp9-3
    Created on : 2018/06/01, 13:16:11
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
            int i = 0;
            for(int j =0;j <= 100;j++){
                i += j;
            }
            out.print(i);
        %>
    </body>
</html>
