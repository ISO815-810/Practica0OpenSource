package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LeerArchivo extends Conexion {

    public static String muestraContenido(String archivo) throws FileNotFoundException, IOException {

        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement ps;
        String cadena = "a";
        String[] partes;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        String fecha_trans_nomina = "";
        String rnc_empresa = "";
        
        while ((cadena = b.readLine()) != null) {

            switch (cadena.charAt(0)) {

                case 'E':

                    partes = cadena.split(",");

                    String tipo_reg = partes[0];
                    String rnc = partes[1];
                    String cuentaEmpresa = partes[2];
                    String fecha_transmision = partes[3];
                    String fecha_corte = partes[4];
                    
                    //Para hacer relacion
                    fecha_trans_nomina = fecha_transmision;
                    rnc_empresa = rnc;

                        try {
                            ps = conexion.prepareStatement("insert into Nomina values (?,?,?,?,?)");

                            ps.setString(1, fecha_transmision);
                            ps.setString(2, rnc);
                            ps.setString(3, tipo_reg);
                            ps.setString(4, cuentaEmpresa);
                            ps.setString(5, fecha_corte);

                            int res = ps.executeUpdate();

                            if (res > 0) {
                            }

                        } catch (SQLException ex) {
                        }

                    break;

                case 'D':

                    partes = cadena.split(",");

                    String tipo_registro = partes[0];
                    String cedula = partes[1];
                    String cuentaEmpleado = partes[2];
                    String sueldoNeto = partes[3];

                        try {
                            ps = conexion.prepareStatement("insert into DetalleNomina values (?,?,?,?,?,?,?)");
                            ps.setString(1, null);
                            ps.setString(2, tipo_registro);
                            ps.setString(3, cedula);
                            ps.setString(4, cuentaEmpleado);
                            ps.setInt(5, Integer.parseInt(sueldoNeto));
                            ps.setString(6, fecha_trans_nomina);
                            ps.setString(7, rnc_empresa);

                            int res = ps.executeUpdate();

                            if (res > 0) {
                            }

                        } catch (SQLException ex) {
                        }

                    break;
            }
        }

        b.close();
        return cadena;
    }
}
