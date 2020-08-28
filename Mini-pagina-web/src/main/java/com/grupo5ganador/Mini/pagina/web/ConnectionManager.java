package com.grupo5ganador.Mini.pagina.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;
    private static String connectionString = "jdbc:sqlserver://localhost:1433; databasename=usuarios;integratedSecurity=true";

    public static Connection obtenerConexion() throws SQLException {
        if(connection==null)
            connection = DriverManager.getConnection(connectionString);
        return connection;
    }
}
