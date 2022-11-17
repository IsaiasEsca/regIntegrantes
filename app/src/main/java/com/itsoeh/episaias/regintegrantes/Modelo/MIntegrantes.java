package com.itsoeh.episaias.regintegrantes.Modelo;

public class MIntegrantes {

    private String Matricula;
    private String Nombre;
    private String Paterno;
    private String Materno;
    private String Materia;
    private String Semestre;
    private String Grupo;

    private String Matricula1;
    private String Nombre1;
    private String Paterno1;
    private String Materno1;
    private String Materia1;
    private String Semestre1;
    private String Grupo1;

    public MIntegrantes() {
    }

    public MIntegrantes(String matricula, String nombre, String paterno, String materno, String materia, String semestre, String grupo, String matricula1, String nombre1, String paterno1, String materno1, String materia1, String semestre1, String grupo1) {
        Matricula = matricula;
        Nombre = nombre;
        Paterno = paterno;
        Materno = materno;
        Materia = materia;
        Semestre = semestre;
        Grupo = grupo;
        Matricula1 = matricula1;
        Nombre1 = nombre1;
        Paterno1 = paterno1;
        Materno1 = materno1;
        Materia1 = materia1;
        Semestre1 = semestre1;
        Grupo1 = grupo1;
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

    public String getMatricula1() {
        return Matricula1;
    }

    public void setMatricula1(String matricula1) {
        Matricula1 = matricula1;
    }

    public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String nombre1) {
        Nombre1 = nombre1;
    }

    public String getPaterno1() {
        return Paterno1;
    }

    public void setPaterno1(String paterno1) {
        Paterno1 = paterno1;
    }

    public String getMaterno1() {
        return Materno1;
    }

    public void setMaterno1(String materno1) {
        Materno1 = materno1;
    }

    public String getMateria1() {
        return Materia1;
    }

    public void setMateria1(String materia1) {
        Materia1 = materia1;
    }

    public String getSemestre1() {
        return Semestre1;
    }

    public void setSemestre1(String semestre1) {
        Semestre1 = semestre1;
    }

    public String getGrupo1() {
        return Grupo1;
    }

    public void setGrupo1(String grupo1) {
        Grupo1 = grupo1;
    }

    @Override
    public String toString() {
        return "MIntegrantes{" +
                "Matricula='" + Matricula + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Paterno='" + Paterno + '\'' +
                ", Materno='" + Materno + '\'' +
                ", Materia='" + Materia + '\'' +
                ", Semestre='" + Semestre + '\'' +
                ", Grupo='" + Grupo + '\'' +
                ", Matricula1='" + Matricula1 + '\'' +
                ", Nombre1='" + Nombre1 + '\'' +
                ", Paterno1='" + Paterno1 + '\'' +
                ", Materno1='" + Materno1 + '\'' +
                ", Materia1='" + Materia1 + '\'' +
                ", Semestre1='" + Semestre1 + '\'' +
                ", Grupo1='" + Grupo1 + '\'' +
                '}';
    }
}
