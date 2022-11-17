package com.itsoeh.episaias.regintegrantes.Modelo;

public class MProyecto {

    private String id;
    private String Nombre;
    private String NomProyecto;
    private String LinkMeet;
    private String Grupo;
    private String Categoria;


    public MProyecto() {

    }

    public MProyecto(String id, String nombre, String nomProyecto, String linkMeet, String grupo, String categoria) {
        this.id = id;
        Nombre = nombre;
        NomProyecto = nomProyecto;
        LinkMeet = linkMeet;
        Grupo = grupo;
        Categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNomProyecto() {
        return NomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        NomProyecto = nomProyecto;
    }

    public String getLinkMeet() {
        return LinkMeet;
    }

    public void setLinkMeet(String linkMeet) {
        LinkMeet = linkMeet;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        Grupo = grupo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    @Override
    public String toString() {
        return "MProyecto{" +
                "id='" + id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", NomProyecto='" + NomProyecto + '\'' +
                ", LinkMeet='" + LinkMeet + '\'' +
                ", Grupo='" + Grupo + '\'' +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
