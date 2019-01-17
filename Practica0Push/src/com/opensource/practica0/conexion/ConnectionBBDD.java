package com.opensource.practica0.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emmanuel Valenzuela
 */
public class ConnectionBBDD {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //El puerto es opcional
    private static final String JDBC_SERVER_NAME = "localhost";
    private static final String JBDC_DATABASE_NAME = "layoutopensource";
    private static final String JDBC_URL = "jdbc:mysql://" + JDBC_SERVER_NAME + "/" + JBDC_DATABASE_NAME + "?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1234";
    private static Driver driver = null;

    //Para que no haya problemas al obtener la conexion de
    //manera concurrente, se usa la palabra synchronized
    public static synchronized Connection getConnection()
            throws SQLException {

        if (driver == null) {
            try {
                //Se registra el driver
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    //Cierre del resultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    //Cierre del PrepareStatement
    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    //Cierre de la conexion
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
