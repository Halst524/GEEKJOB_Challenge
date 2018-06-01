<%-- 
    Document   : newjspApp6-2
    Created on : 2018/06/01, 11:06:43
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
        <h1>Hello World!</h1>
        <%
            char lan = 'A';
            switch(lan){
                case 'A':
                    out.print("英語");
                    break;
               case 'あ':
                    out.print("日本語");
                    break;
            }
            %>
    </body>
</html>
