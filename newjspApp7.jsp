<%-- 
    Document   : newjspApp7
    Created on : 2018/06/01, 10:51:30
    Author     : guest1Day
--%>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<String> hi02 = new ArrayList<String>();
                    hi02.add("10");
                    hi02.add("100");
                    hi02.add("soeda");
                    hi02.add("hayashi");
                    hi02.add("-20");
                    hi02.add("118");
                    hi02.add("END");
                    for(int i = 0; i < hi02.size();i++){
                        out.print(hi02.get(i));
                    }
                    %>
    </body>
</html>
