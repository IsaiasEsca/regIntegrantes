package com.itsoeh.episaias.regintegrantes.Modelo;

public class MRegistro {

    private String Matricula;
    private String Nombre;
    private String ApelPaterMater;


    public MRegistro() {
    }

    public MRegistro(String matricula, String nombre, String apelPaterMater) {
        Matricula = matricula;
        Nombre = nombre;
        ApelPaterMater = apelPaterMater;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApelPaterMater() {
        return ApelPaterMater;
    }

    public void setApelPaterMater(String apelPaterMater) {
        ApelPaterMater = apelPaterMater;
    }

    @Override
    public String toString() {
        return "MRegistro{" +
                "Matricula='" + Matricula + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", ApelPaterMater='" + ApelPaterMater + '\'' +
                '}';
    }
}
