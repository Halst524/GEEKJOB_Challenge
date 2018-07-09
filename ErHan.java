package jbdCon;

import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErHan {
    public static void main(String[] arcs){
        Connection cdb_con = null;
        PreparedStatement cdb_st = null;
        ResultSet cdb_data = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cdb_con = DriverManager.getConnection("jdbc:mysql://localhost:Challenge_db","root","");
            
            cdb_st = cdb_con.prepareStatement("select * from user where age >= ?");
            cdb_st.setInt(1, 30);
            
            cdb_data = cdb_st.executeQuery();
            while(cdb_data.next()){
                out.print("名前:" + cdb_data.getString("name") + "\n");
            }
            
            cdb_data.close();
            cdb_st.close();
            cdb_con.close();
        } catch (SQLException e_sql){
            out.print("接続エラー:" + e_sql.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ErHan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cdb_con.close();
            } catch (SQLException e_con) {
                System.out.println(e_con.getMessage());
            }
        }
    }
}