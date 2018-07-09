<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品管理</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String itID = request.getParameter("ID");
            String nam = request.getParameter("name");
            int pr = Integer.parseInt(request.getParameter("price"));
            int spr = Integer.parseInt(request.getParameter("Sprice"));
            int stk = Integer.parseInt(request.getParameter("stock"));
            String Act = request.getParameter("act");
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            HttpSession sss = request.getSession();

            if(sss.getAttribute("address").equals("./item.html")){

                if(Act.equals("INSERT")){
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                        db_st = db_con.prepareStatement("insert into item(itemID,name,price,Sprice,stock) values(?,?,?,?,?);");
                        db_st.setString(1,itID);
                        db_st.setString(2,nam);
                        db_st.setInt(3,pr);
                        db_st.setInt(4,spr);
                        db_st.setInt(5,stk);

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
                    out.print(itID + "の商品の登録完了しました。");
                } else if(Act.equals("UPDATE")){
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                        db_st = db_con.prepareStatement("update item set(name=?,price=?,Sprice=?,stock=?) where itemID=?;");
                        db_st.setString(5,itID);
                        db_st.setString(1,nam);
                        db_st.setInt(2,pr);
                        db_st.setInt(3,spr);
                        db_st.setInt(4,stk);

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
                    out.print(itID + "の商品の更新完了しました。");
                } else if(Act.equals("DELETE")){
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");

                        db_st = db_con.prepareStatement("delete from item where itemID=?;");
                        db_st.setString(1,itID);

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
                    out.print(itID + "の商品の消去完了しました。");
                } else {
                    out.print("エラーが発生しました。");
                }
            } else {
                out.print("再ログインをお願いします");
            }
        %>
        <br>
        <a href="./item.html">戻る</a>
    </body>
</html>
