package com.grupo5ganador.Mini.pagina.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO {
    private static Connection connection;

    public UsuarioDAO() throws SQLException {
        this.connection = ConnectionManager.obtenerConexion();
    }

    public static Usuario modificar(Usuario a) throws SQLException {
        String sql = "update usuario set nombres = ?, apellidos = ?, fecha_de_nacimiento = ?, correo = ?, contraseña = ? where rut = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getNombres());
        ps.setString(2, a.getApellidos());
        ps.setDate(3, a.getFechaNacimiento());
        ps.setString(4, a.getCorreo());
        ps.setString(5, a.getContrasenha());
        ps.setString(6, a.getRut());
        ps.executeUpdate();
        return null;
    }


    public List<Usuario> obtenerDatosPorRut(String rut) throws SQLException {
        String sql = "Select rut, nombres, apellidos, fecha_de_nacimiento, contraseña, correo from usuario where rut = ?";
        return obtenerResultados(sql, rut);
    }

    private List<Usuario> obtenerResultados(String sql, String parametro) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, parametro);
        ResultSet rs = ps.executeQuery();
        List<Usuario> usuarios = new LinkedList<>();
        while (rs.next()){
            Usuario p = new Usuario(
                    rs.getString("rut"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_de_nacimiento"),
                    rs.getString("contraseña"),
                    rs.getString("correo")
            );
            usuarios.add(p);
        }
        return usuarios;
    }

    public void crearUsuario(Usuario p) throws SQLException {
        String sql = "insert into usuario (rut, nombres, apellidos, fecha_de_nacimiento, contraseña, correo)"+
                "values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getRut());
        ps.setString(2, p.getNombres());
        ps.setString(3, p.getApellidos());
        ps.setDate(4, p.getFechaNacimiento());
        ps.setString(5, p.getContrasenha());
        ps.setString(6, p.getCorreo());
        ps.executeUpdate();

    }


    public static Usuario loginUsuario(Usuario u) throws SQLException {
        String sql = "select * from Usuario where correo = '" + u.getCorreo() + "' and contraseña = '" + u.getContrasenha() + "'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String numRut = rs.getString(1);
        String nombresU = rs.getString(2);
        String apellidosU = rs.getString(3);
        Date fechaNacimientoU = rs.getDate(4);
        String correoU = rs.getString(5);
        String contrasenhaU = rs.getString(6);

        return new Usuario (numRut, nombresU, apellidosU, fechaNacimientoU, correoU, contrasenhaU);

    }

    public void borrarUser(String rut) throws SQLException {
        String sql = "delete from usuario where rut = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, rut);

        ps.executeUpdate();

    }


    public List<Usuario> obtenerUsuarios() throws SQLException {
        String sql = "Select rut, nombres, apellidos, fecha_de_nacimiento, contraseña, correo from usuario";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Usuario> user = new ArrayList<>();
        Usuario us = null;
        while(rs.next()){
            us = new Usuario(
                    rs.getString("rut"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getDate("fecha_de_nacimiento"),
                    rs.getString("contraseña"),
                    rs.getString("correo"));
            user.add(us);
        }
        return user;
    }

    public List<Usuario> obtenerDatosPorCorreoContra(String correo, String contrasenha) throws SQLException {
        String sql = "select nombres from usuario where correo = ? and contraseña = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setString(2, contrasenha);
        ps.executeQuery();
        return null;
    }
}
