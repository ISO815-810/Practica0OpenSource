package app;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/apap_nominas";
    public static final String USER = "Carlos";
    public static final String PASS = "12345";

    public static Connection obtenerConexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = (Connection) DriverManager.getConnection(URL, USER, PASS);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
        }
        return con;
    }
}
