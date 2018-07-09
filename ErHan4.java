package jbdCon;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErHan4 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HAL","ill11","1lil");
            
            db_st = db_con.prepareStatement("select * from profiles where profilesID = ?");
            db_st.setString(1, "1");
            
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