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
import com.itsoeh.episaias.regintegrantes.Controlador.CProyecto;
import com.itsoeh.episaias.regintegrantes.Modelo.MProyecto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link regProyecto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class regProyecto extends Fragment {
    Button btnRegProyecto;
    ImageView imgHomeProyectoe;
    NavController navControllerPro;
    EditText txt_Proyecto, txt_LinkMeet, txt_idMatr, txt_Nombre;
    Spinner sp_Proyecto;
    DatabaseReference db;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle datos = this.getArguments();
        navControllerPro= Navigation.findNavController(view);
        txt_Nombre=view.findViewById(R.id.reg_liderEq);
        txt_idMatr=view.findViewById(R.id.reg_IdProyecto);
        txt_Proyecto=view.findViewById(R.id.reg_txtProyecto);
        txt_LinkMeet=view.findViewById(R.id.reg_txtLinkMeet);
        sp_Proyecto=view.findViewById(R.id.reg_spCategoria);
        sp_Proyecto=view.findViewById(R.id.reg_spGrupos);
    imgHomeProyectoe=view.findViewById(R.id.regHomPro);

if(datos!=null){
    txt_idMatr.setText(datos.getString("matricula"));

}

    imgHomeProyectoe.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imgHomeProyectos(v);
        }
    });
        btnRegProyecto=view.findViewById(R.id.btn_regProyecto);
        btnRegProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegProyectos(v);
            }
        });

    }

    private void imgHomeProyectos(View v) {
        navControllerPro.navigate(R.id.menu);
    }

    private void btnRegProyectos(View v) {
        MProyecto proyecto = new MProyecto();

        if (validarCampos()){
            proyecto.setNombre(txt_Nombre.getText().toString());
            proyecto.setId(txt_idMatr.getText().toString());
            proyecto.setNomProyecto(txt_Proyecto.getText().toString());
            proyecto.setLinkMeet(txt_LinkMeet.getText().toString());
            proyecto.setGrupo(sp_Proyecto.getSelectedItem().toString());
            sp_Proyecto.setSelection(0);

            proyecto.setCategoria(sp_Proyecto.getSelectedItem().toString());
            sp_Proyecto.setSelection(0);
             db= FirebaseDatabase.getInstance().getReference("usuario/reg").child(proyecto.getId()).child("proyecto");
           db=FirebaseDatabase.getInstance().getReference("usuario/Proyecto").child(proyecto.getNomProyecto());
            db.setValue(proyecto);
             Toast.makeText(v.getContext(), "Registro exitoso!", Toast.LENGTH_SHORT).show();
            navControllerPro.navigate(R.id.menu);
        }
    }



        public boolean validarCampos(){

            boolean retorno = true;

            String Proyecto = txt_Proyecto.getText().toString();
            String LinkMeet = txt_LinkMeet.getText().toString();


            if (Proyecto.isEmpty()){
                txt_Proyecto.setError("Este campo No puede estar vacio");
                retorno=false;}
            if (LinkMeet.isEmpty()){
                txt_LinkMeet.setError("Este campo No puede estar vacio");
                retorno=false;}


            return retorno;
        }




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public regProyecto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment regProyecto.
     */
    // TODO: Rename and change types and number of parameters
    public static regProyecto newInstance(String param1, String param2) {
        regProyecto fragment = new regProyecto();
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
        return inflater.inflate(R.layout.fragment_reg_proyecto, container, false);
    }
}