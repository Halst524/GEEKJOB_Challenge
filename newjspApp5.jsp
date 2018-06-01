<%-- 
    Document   : newjspApp5
    Created on : 2018/06/01, 10:47:22
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
            int i = 1;
            if(i == 2){
                System.out.println("プログラミングキャンプ！");
            } else if(i == 1){
                System.out.println("1です！");
            } else {
                System.out.println("その他です！");
            }
                %>
    </body>
</html>
