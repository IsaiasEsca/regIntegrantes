package com.itsoeh.episaias.regintegrantes.Controlador;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Modelo.MProyecto;

public class CProyecto {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    public CProyecto(){}
    public void insertar(MProyecto P){
        myRef=database.getReference("Users//Proyecto"+P.getNomProyecto());
        myRef.setValue(P);
    }
}
