package com.itsoeh.episaias.regintegrantes.Modelo;

public class MAlumno {

    private String Matricula;
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String Materia;
    private String Semestre;
    private String Grupo;

    public MAlumno() {
        }

    public MAlumno(String matricula, String nombre, String paterno, String materno, String materia, String semestre, String grupo) {
        Matricula = matricula;
        Nombre = nombre;
        Paterno = paterno;
        Materno = materno;
        Materia = materia;
        Semestre = semestre;
        Grupo = grupo;
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

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String paterno) {
        Paterno = paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String materno) {
        Materno = materno;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String semestre) {
        Semestre = semestre;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    @Override
    public String toString() {
        return "MAlumno{" +
                "Matricula='" + Matricula + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Paterno='" + Paterno + '\'' +
                ", Materno='" + Materno + '\'' +
                ", Materia='" + Materia + '\'' +
                ", Semestre='" + Semestre + '\'' +
                ", Grupo='" + Grupo + '\'' +
                '}';
    }
}
