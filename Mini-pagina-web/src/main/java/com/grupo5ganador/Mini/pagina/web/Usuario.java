package com.grupo5ganador.Mini.pagina.web;

import java.sql.Date;

public class Usuario {

private String rut;
private String nombres;
private String Apellidos;
private Date fechaNacimiento;
private String contrasenha;
private String correo;

    public Usuario(String rut, String nombres, String apellidos, Date fechaNacimiento, String contrasenha, String correo) {
        this.rut = rut;
        this.nombres = nombres;
        Apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenha = contrasenha;
        this.correo = correo;
    }

    public String getRut() {
        return rut;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "rut='" + rut + '\'' +
                ", nombres='" + nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", contrasenha='" + contrasenha + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}








