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
import com.itsoeh.episaias.regintegrantes.Controlador.CIntegrantes;
import com.itsoeh.episaias.regintegrantes.Modelo.MIntegrantes;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegIntegrantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegIntegrantes extends Fragment {

    ImageView imgHome;
    EditText txt_AlumMatricula1, txt_AlumnNombre1, txt_AlumnPaterno1,
            txt_AlumnMaterno1, txt_AlumnMateria1, txt_AlumMatricula11, txt_AlumnNombre11, txt_AlumnPaterno11,
            txt_AlumnMaterno11, txt_AlumnMateria11;
    Spinner sp1;
    Spinner sp2;
        DatabaseReference db;

    NavController navControllerInte;
    Button btnRegIntegrantes;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgHome=view.findViewById(R.id.regHom1);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHome1(v);
            }
        });
        sp1 = view.findViewById(R.id.reg_txtGrupo);
        sp2 = view.findViewById(R.id.reg_txtGrupo1);
        txt_AlumMatricula1=view.findViewById(R.id.reg_txtMtr);
        txt_AlumMatricula11=view.findViewById(R.id.reg_txtMtr1);
        txt_AlumnNombre1=view.findViewById(R.id.reg_txtNombre);
        txt_AlumnNombre11=view.findViewById(R.id.reg_txtNombre1);
        txt_AlumnPaterno1=view.findViewById(R.id.reg_txtApelliPaterno);
        txt_AlumnPaterno11=view.findViewById(R.id.reg_txtApelliPaterno1);
        txt_AlumnMaterno1=view.findViewById(R.id.reg_txtApelliMaterno);
        txt_AlumnMaterno11=view.findViewById(R.id.reg_txtApelliMaterno1);
        txt_AlumnMateria1=view.findViewById(R.id.reg_txtMateria1);
        txt_AlumnMateria11=view.findViewById(R.id.reg_txtMateria11);
        navControllerInte= Navigation.findNavController(view);
        btnRegIntegrantes=view.findViewById(R.id.btn_regIntegra1);
        btnRegIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnregIntegrantes(v);
            }
        });

    }

    private void imgHome1(View v) {
        navControllerInte.navigate(R.id.menu);
    }

    private void btnregIntegrantes(View v) {
        MIntegrantes inte = new MIntegrantes();
        if (validarCampos())
        {

            inte.setMatricula(txt_AlumMatricula1.getText().toString());
            inte.setNombre(txt_AlumnNombre1.getText().toString());
            inte.setPaterno(txt_AlumnPaterno1.getText().toString());
            inte.setMaterno(txt_AlumnMaterno1.getText().toString());
            inte.setMateria(txt_AlumnMateria1.getText().toString());
            inte.setGrupo(sp1.getSelectedItem().toString());

            inte.setMatricula1(txt_AlumMatricula11.getText().toString());
            inte.setNombre1(txt_AlumnNombre11.getText().toString());
            inte.setPaterno1(txt_AlumnPaterno11.getText().toString());
            inte.setMaterno1(txt_AlumnMaterno11.getText().toString());
            inte.setMateria1(txt_AlumnMateria11.getText().toString());
            inte.setGrupo1(sp2.getSelectedItem().toString());
            sp2.setSelection(0);
            sp1.setSelection(0);
            db=FirebaseDatabase.getInstance().getReference("usuario/reg").child(inte.getMatricula()).child("integrantes");
           db.setValue(inte);
            navControllerInte.navigate(R.id.menu);
            Toast.makeText(v.getContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();


        }





    }

    public boolean validarCampos(){

        boolean retorno = true;

        String AlumMatr1 = txt_AlumMatricula1.getText().toString();
        String AlumnNomb1 = txt_AlumnNombre1.getText().toString();
        String AlumnPate1 = txt_AlumnPaterno1.getText().toString();
        String AlumnMaterno1 = txt_AlumnMaterno1.getText().toString();
        String AlumnMateria1 = txt_AlumnMateria1.getText().toString();
        String AlumnMatri11 = txt_AlumMatricula11.getText().toString();
        String AlumnNombre11 = txt_AlumnNombre11.getText().toString();
        String AlumnPaterno11 = txt_AlumnPaterno11.getText().toString();
        String AlumnMaterno11 = txt_AlumnMaterno11.getText().toString();
        String AlumnMateria11 = txt_AlumnMateria11.getText().toString();

        if (AlumMatr1.isEmpty()){
            txt_AlumMatricula1.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnNomb1.isEmpty()){
            txt_AlumnNombre1.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnPate1.isEmpty()){
            txt_AlumnPaterno1.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnMaterno1.isEmpty()){
            txt_AlumnMaterno1.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnMateria1.isEmpty()){
            txt_AlumnMateria1.setError("Este campo No puede estar vacios");
            retorno=false;}
        if (AlumnMatri11.isEmpty()){
            txt_AlumMatricula11.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnNombre11.isEmpty()){
            txt_AlumnNombre11.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnPaterno11.isEmpty()){
            txt_AlumnPaterno11.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnMaterno11.isEmpty()){
            txt_AlumnMaterno11.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (AlumnMateria11.isEmpty()){
            txt_AlumnMateria11.setError("Este campo No puede estar vacio");
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

    public RegIntegrantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegIntegrantes.
     */
    // TODO: Rename and change types and number of parameters
    public static RegIntegrantes newInstance(String param1, String param2) {
        RegIntegrantes fragment = new RegIntegrantes();
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
        return inflater.inflate(R.layout.fragment_reg_integrantes, container, false);
    }
}