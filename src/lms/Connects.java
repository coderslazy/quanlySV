package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connects {

        Connection con;
    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TienQLSV;user=sa;password=1234");
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Không kết nối được Server");
            }
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi" + ex);
        }
        return con;
    }
    public static void main(String[] args) {
   Connects a = new Connects();
    
}
}


