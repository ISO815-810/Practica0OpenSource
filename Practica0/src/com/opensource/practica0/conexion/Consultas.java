package com.opensource.practica0.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class Consultas {

    private static final String SQL_SELECT_ENCABEZADO = "SELECT Tipo_Registro, RNC, No_Cuenta, Fecha_Transmision, Fecha_Corte\n"
            + "FROM encabezados\n"
            + "WHERE Fecha_Corte = ?";

    private static final String SQL_SELECT_DETALLES = "SELECT d.Tipo_Registro, d.Cedula, d.No_Cuenta, d.Sueldo_Neto\n"
            + "FROM Detalles AS d\n"
            + "INNER JOIN encabezado_detalle AS ed ON ed.IdDetalle = d.Id\n"
            + "INNER JOIN Encabezados        AS e  ON e.Id = ed.IdEncabezado\n"
            + "WHERE e.Fecha_Corte = ?";

    private static final String SQL_SELECT_SUMARIO = "SELECT  COUNT(d.Id) AS Total_Empleados, SUM(d.Sueldo_Neto) AS Total_Nomina \n"
            + "FROM Detalles AS d \n"
            + "INNER JOIN encabezado_detalle AS ed ON ed.IdDetalle = d.Id\n"
            + "INNER JOIN Encabezados        AS e  ON e.Id = ed.IdEncabezado\n"
            + "WHERE e.Fecha_Corte = ?";

    public static List<String> getEncabezado(String fechaCorte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> encabezado = new ArrayList<>();

        try {
            conn = ConnectionBBDD.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ENCABEZADO);
            stmt.setString(1, fechaCorte);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Tipo_Registro = rs.getString(1);
                String RNC = rs.getString(2);
                String No_Cuenta = rs.getString(3);
                String Fecha_Transmision = rs.getString(4);
                String Fecha_Corte = rs.getString(5);

                encabezado.add(Tipo_Registro + "," + RNC + "," + No_Cuenta + ","
                        + Fecha_Transmision + "," + Fecha_Corte);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            ConnectionBBDD.close(rs);
            ConnectionBBDD.close(stmt);
            ConnectionBBDD.close(conn);
        }
        return encabezado;
    }

    public static List<String> getSumario(String fechaCorte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> sumario = new ArrayList<>();

        try {

            conn = ConnectionBBDD.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SUMARIO);
            stmt.setString(1, fechaCorte);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int totalEmpleados = rs.getInt(1);
                int totalNomina = rs.getInt(2);

                sumario.add("S," + totalEmpleados + "," + totalNomina);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionBBDD.close(rs);
            ConnectionBBDD.close(stmt);
            ConnectionBBDD.close(conn);
        }

        return sumario;
    }

    public static List<String> getDetalles(String fechaCorte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> detalles = new ArrayList<>();

        try {

            conn = ConnectionBBDD.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_DETALLES);
            stmt.setString(1, fechaCorte);
            rs = stmt.executeQuery();

            while (rs.next()) {

                String Tipo_Registro = rs.getString(1);
                String Cedula = rs.getString(2);
                String No_Cuenta = rs.getString(3);
                String Sueldo_Neto = rs.getString(4);

                detalles.add(Tipo_Registro + "," + Cedula + "," + No_Cuenta + ","
                        + Sueldo_Neto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionBBDD.close(rs);
            ConnectionBBDD.close(stmt);
            ConnectionBBDD.close(conn);
        }

        return detalles;
    }
}
