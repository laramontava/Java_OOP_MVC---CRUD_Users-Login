/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 *
 * @author Lara
 */
public class ConnectionBBDD {

    /**
     * abrimos conexion en la base de datos
     *
     * @return
     */
    public Connection AbrirConexion() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/admin";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }

    /**
     * cerramos la conexion en la bd
     *
     * @param con
     */
    public void CerrarConexion(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }

    /* Pool de conexiones */
    public static BasicDataSource dataSource;

    /* Logger */
    private static final Logger log = Logger.getLogger("ejemplo2");

    public static void inicializa_BasicDataSourceFactory() {
        Properties propiedades = new Properties();
        /*
        setMaxActive(): Nº máx de conexiones que se pueden abrir simultáneamente.
        setMinIdle(): Nº mín de conexiones inactivas que queremos que haya. Si el nº de conexiones baja de este nº, se abriran más.
        setMaxIdle(): Nº máx de conexiones inactivas que queremos que haya. Si hay más, se irán cerrando.
         */
        propiedades.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        propiedades.setProperty("url", "jdbc:mysql://127.0.0.1:3306/admin");
        propiedades.setProperty("maxActive", "10");
        propiedades.setProperty("maxIdle", "8");
        propiedades.setProperty("minIdle", "0");
        propiedades.setProperty("maxWait", "500");
        propiedades.setProperty("initialSize", "5");
        propiedades.setProperty("defaultAutoCommit", "true");
        propiedades.setProperty("username", "root");
        propiedades.setProperty("password", "");
        propiedades.setProperty("validationQuery", "select 1");
        propiedades.setProperty("validationQueryTimeout", "100");
        propiedades.setProperty("initConnectionSqls", "SELECT 1;SELECT 2");
        propiedades.setProperty("poolPreparedStatements", "true");
        propiedades.setProperty("maxOpenPreparedStatements", "10");

        try {
            //propiedades.load(new FileInputStream("src/config/datasource_config.properties"));
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void realizaConsulta1() {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            // BasicDataSource nos reserva una conexion y nos la devuelve
            conexion = getConexion();
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery("select count(*) from user");
            rs.next();
            JOptionPane.showMessageDialog(null, "El numero de usuarios es: " + rs.getInt(1));
            logStatistics();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                rs.close();
                sentencia.close();
                liberaConexion(conexion);
            } catch (Exception fe) {
                JOptionPane.showMessageDialog(null, fe.toString());
            }
        }
    }

    public static void realizaConsulta2() {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet rs = null;

        try {
            conexion = getConexion();
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery("select count(*) from db");
            rs.next();
            JOptionPane.showMessageDialog(null, "El numero de bd es: " + rs.getInt(1));
            logStatistics();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                rs.close();
                sentencia.close();
                liberaConexion(conexion);
            } catch (Exception fe) {
                JOptionPane.showMessageDialog(null, fe.toString());
            }
        }
    }

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = dataSource.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conexion;
    }

    public static void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) // En realidad no cierra, solo libera la conexion.
            {
                conexion.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void logStatistics() {
        log.info("active: " + dataSource.getNumActive() + " (max: "
                + dataSource.getMaxActive() + ")   " + "idle: " + dataSource.getNumIdle() + " (max: " + dataSource.getMaxIdle() + ")\n");
    }
}
