package com.itsoeh.episaias.regintegrantes.Controlador;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Modelo.MIntegrantes;

public class CIntegrantes {

FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef;
public CIntegrantes(){}

    public void insertar(MIntegrantes i){
    myRef= database.getReference("Users/integrantes"+i.getMatricula());
    myRef.setValue(i);
    }

}
