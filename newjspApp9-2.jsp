<%-- 
    Document   : newjspApp9-2
    Created on : 2018/06/01, 13:12:39
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
            String as = "";
            for(int i = 0;i < 30;i++){
                as += "A";
            }
            out.print(as);
        %>
    </body>
</html>
