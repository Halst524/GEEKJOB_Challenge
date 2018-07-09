<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>消去しました</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            int pID = Integer.parseInt(request.getParameter("ID"));
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                db_st = db_con.prepareStatement("delete from profiles where profilesID = ?;");
                db_st.setInt(1,pID);
                
                db_st.executeUpdate();

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
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");
                db_st = db_con.prepareStatement("select * from profiles");
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.print(db_data.getString("profilesID") + " " + db_data.getString("name") + " " + db_data.getString("tel") + " " + db_data.getString("age") + " " + db_data.getString("birthday") + "<br>");
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
        %>
    </body>
</html>
