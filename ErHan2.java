package jbdCon;

import static java.lang.System.out;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErHan2 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        int num;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");
            
            db_st = db_con.prepareStatement("insert into profiles(profilesID,name,tel,age,birthday) values(?,?,?,?,?)");
            db_st.setInt(1, 6);
            db_st.setString(2, "田中 角栄");
            db_st.setString(3, "0120-117-117");
            db_st.setInt(4, 100);
            db_st.setDate(5,new java.sql.Date(sdf.parse("1918-05-04").getTime()));
            
            num = db_st.executeUpdate();
            
            db_st.close();
            db_con.close();
        } catch (SQLException e_sql){
            out.print("接続エラー:" + e_sql.toString());
        } catch (ClassNotFoundException | ParseException ex) {
            Logger.getLogger(ErHan2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db_con.close();
            } catch (SQLException e_con) {
                System.out.println(e_con.getMessage());
            }
        }
    }
}