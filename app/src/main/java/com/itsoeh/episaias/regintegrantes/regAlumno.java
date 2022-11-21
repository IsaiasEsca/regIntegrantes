package com.itsoeh.episaias.regintegrantes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Controlador.CAlumno;
import com.itsoeh.episaias.regintegrantes.Modelo.MAlumno;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link regAlumno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class regAlumno extends Fragment {

    EditText txt_AlumMatricula, txt_AlumnNombre, txt_AlumnPaterno,
    txt_AlumnMaterno, txt_AlumnMateria;
    ImageView homes;
    Spinner sp_Grupo;
    Button btnRegistro;
    NavController NAV;
    Spinner sp_gru;
    DatabaseReference db;




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sp_gru=view.findViewById(R.id.reg_txtGrupo);
        txt_AlumMatricula=view.findViewById(R.id.reg_txtMtr);
        txt_AlumnNombre=view.findViewById(R.id.reg_txtNombre);
        txt_AlumnPaterno=view.findViewById(R.id.reg_txtApelliPaterno);
        txt_AlumnMaterno=view.findViewById(R.id.reg_txtApelliMaterno);
        txt_AlumnMateria=view.findViewById(R.id.reg_txtMatriaCursado);
        NAV= Navigation.findNavController(view);
        homes=view.findViewById(R.id.regHom);
        homes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imaHome();
            }
        });
        btnRegistro=view.findViewById(R.id.btn_regAlumn);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlumRegi(v);
            }
        });

    }

    private void imaHome() {
        NAV.navigate(R.id.menus);

    }

    private void btnAlumRegi(View v) {
        MAlumno alum = new MAlumno();
       String matr= txt_AlumMatricula.getText().toString();
        String nombre=txt_AlumnNombre.getText().toString();
        String paterno=txt_AlumnPaterno.getText().toString();
        String materno=txt_AlumnMaterno.getText().toString();
        String materia=txt_AlumnMateria.getText().toString();


        if ( nombre.isEmpty() || paterno.isEmpty() || materno.isEmpty() || materia.isEmpty()){

            Toast.makeText(v.getContext(), "Campos vacios", Toast.LENGTH_SHORT).show();
        }else {

            if (numeros(matr) == false) {
                Toast.makeText(v.getContext(), "Ingrese solo numeros", Toast.LENGTH_LONG).show();
            } else {

                if (sololetras(nombre) == false) {
                    Toast.makeText(v.getContext(), "solo letras", Toast.LENGTH_SHORT).show();
                } else {
                    if (sololetras(paterno) == false) {
                        Toast.makeText(v.getContext(), "solo letras", Toast.LENGTH_SHORT).show();
                    } else {
                        if (sololetras(materno) == false) {
                            Toast.makeText(v.getContext(), "solo letras", Toast.LENGTH_SHORT).show();
                        }
                            Bundle ma = new Bundle();
                        ma.putString("matricula", alum.getMatricula());
                            alum.setMatricula(txt_AlumMatricula.getText().toString());
                            alum.setNombre(txt_AlumnNombre.getText().toString());
                             alum.setMaterno(txt_AlumnMaterno.getText().toString());
                             alum.setPaterno(txt_AlumnPaterno.getText().toString());
                             alum.setMateria(txt_AlumnMateria.getText().toString());
                             alum.setGrupo(sp_gru.getSelectedItem().toString());
                        sp_gru.setSelection(0);

                        db=FirebaseDatabase.getInstance().getReference("usuario/reg").child(alum.getMatricula()).child("registro");
                        db.setValue(alum);
                       NAV.navigate(R.id.regProyecto,ma);
                        Toast.makeText(v.getContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }




    public boolean numeros(String numeros){
       boolean numero = false;
       for (int i =0; i<numeros.length();i++) {
           char m = numeros.charAt(i);

           if ((m >= '0' && m <= '9')) {
               numero = true;
           }


       }
           if (numero==true){
               return true;
           }

       return false;
    }

    public boolean sololetras(String cadena){

        for (int i=0; i<cadena.length(); i++){
            char c = cadena.charAt(i);
            //si no esta entre A y z
            if(!((c>='a' && c<='z')|| (c>='A' && c<='Z'))){
                return false;
            }
        }
        return true;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public regAlumno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment regAlumno.
     */
    // TODO: Rename and change types and number of parameters
    public static regAlumno newInstance(String param1, String param2) {
        regAlumno fragment = new regAlumno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_alumno, container, false);
    }
}