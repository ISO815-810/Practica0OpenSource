package app;

import com.mysql.jdbc.Connection;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Nomina extends Conexion {
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ResultSet obtenerDatos() {

        String sql = "select * from nomina";

        con = Conexion.obtenerConexion();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            
        }

        return rs;
    }
}

    

