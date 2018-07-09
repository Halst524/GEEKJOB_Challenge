<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品一覧</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            HttpSession sss = request.getSession();
            
            if(sss.getAttribute("address").equals("./item.html")){
            
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                    db_st = db_con.prepareStatement("select * from item where price >= ?");
                    db_st.setString(1, "0");

                    out.print("<table border='1'><tr>"
                            + "<th bgcolor='#33EE33'><font color='#FFFFFF'>商品ID</font></th>"
                            + "<th bgcolor='#33EE33'><font color='#FFFFFF'>商品名</font></th>"
                            + "<th bgcolor='#33EE33'><font color='#FFFFFF'>仕入価格</font></th>"
                            + "<th bgcolor='#33EE33'><font color='#FFFFFF'>売価</font></th>"
                            + "<th bgcolor='#33EE33'><font color='#FFFFFF'>在庫</font></th><tr>");
                    db_data = db_st.executeQuery();
                    while(db_data.next()){
                        out.print("<tr><td>" + db_data.getString("itemID") + "</td><td>" + db_data.getString("name") + "</td><td>" + db_data.getString("price") + "</td><td>" + db_data.getString("Sprice") + "</td><td>" + db_data.getString("stock") + "</td></tr>>");
                    }
                    out.print("</table>");

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
            } else {
                out.print("再ログインをお願いします");
            }
        %>
        <a href="./item.html">戻る</a>
    </body>
</html>
