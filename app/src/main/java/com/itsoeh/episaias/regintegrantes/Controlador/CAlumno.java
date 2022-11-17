package com.itsoeh.episaias.regintegrantes.Controlador;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Modelo.MAlumno;

public class CAlumno {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myref;

    public CAlumno(){}
    public void insertar(MAlumno u){

        myref=database.getReference("Users/Usuario");
        myref.setValue(u);

    }


}
