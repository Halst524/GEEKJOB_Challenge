package jbdCon;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErHan7 {
    
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");
            
            db_st = db_con.prepareStatement("UPDATE profiles SET name = ?, tel = ?, age = ?, birthday = ? WHERE profilesID = ?");
            db_st.setString(1,"田中 悟");
            db_st.setString(2,"011-235-8314");
            db_st.setInt(3,8);
            db_st.setDate(4,new java.sql.Date(sdf.parse("2010-05-05").getTime()));
            db_st.setInt(5,1);
            db_st.executeUpdate();
                
            db_st.close();
            db_con.close();
        } catch (SQLException e_sql){
            out.print("接続エラー:" + e_sql.toString());
        } catch (ClassNotFoundException | ParseException ex) {
            Logger.getLogger(ErHan7.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db_con.close();
            } catch (SQLException e_con) {
                System.out.println(e_con.getMessage());
            }
        }
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");
            
            db_st = db_con.prepareStatement("select * from profiles");
            
            db_data = db_st.executeQuery();
            while(db_data.next()){
                out.print(db_data.getString("profilesID") + "\t" + db_data.getString("name") + db_data.getString("tel") + "\t" + db_data.getString("age") + "\t" + db_data.getString("birthday") + "\n");
            }
            
            db_data.close();
            db_st.close();
            db_con.close();
        } catch (SQLException e_sql){
            out.print("接続エラー:" + e_sql.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db_con.close();
            } catch (SQLException e_con) {
                System.out.println(e_con.getMessage());
            }
        }
    }
}