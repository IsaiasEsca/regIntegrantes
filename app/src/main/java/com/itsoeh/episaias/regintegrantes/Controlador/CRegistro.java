package com.itsoeh.episaias.regintegrantes.Controlador;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Modelo.MRegistro;

public class CRegistro {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref;
    public CRegistro(){}
    public void insentar(MRegistro r){

       ref= database.getReference("Users/Autoregistro");
       ref.setValue(r);



    }

}
