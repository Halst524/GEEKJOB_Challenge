<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DataGetJSP</title>
    </head>
    <body>
        <h1>情報</h1>
        <%
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("txtName");
            String gender = request.getParameter("gender");
            String hobby = request.getParameter("hobby");
            out.println(name);
            out.println(gender);
            out.println(hobby);
        %>
    </body>
</html>
