<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>no title</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String usID = request.getParameter("ID");
            String pas = request.getParameter("pass");
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            HttpSession sss = request.getSession();
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                db_st = db_con.prepareStatement("select * from user1 where userID=?");
                db_st.setString(1, usID);

                db_data = db_st.executeQuery();
                
                db_data.next();
                
                if(pas.equals(db_data.getString("pass"))){
                    sss.setAttribute("address","./item.html");
                } else {
                    sss.setAttribute("address","./login.html");
                }

                db_data.close();
                db_st.close();
                db_con.close();
            } catch (SQLException e_sql){
                out.print("接続エラー:" + e_sql.toString());
            } finally {
                try {
                    db_con.close();
                } catch (SQLException e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
        response.sendRedirect(sss.getAttribute("address").toString());
        %>
    </body>
</html>
