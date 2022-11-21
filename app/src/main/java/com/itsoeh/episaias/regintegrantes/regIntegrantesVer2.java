package com.itsoeh.episaias.regintegrantes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Modelo.MIntegrantesV2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link regIntegrantesVer2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class regIntegrantesVer2 extends Fragment {

    EditText txtInt1,
             txtInt2,
             txtInt3,
             txtInt4;
    EditText txtIntCorre1,
             txtIntCorre2,
             txtIntCorre3,
             txtIntCorre4,
             txtMatri;
    Spinner gr;
    Button btnRegistrar;

    DatabaseReference db;
    String EMAIL_PATTERN = " [A-Za-z0-9]+@itsoeh.edu.mx";

    FirebaseDatabase database;


    private Matcher matcher;
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtMatri=view.findViewById(R.id.matricula);
        txtInt1=view.findViewById(R.id.reg_Integrante1);
        txtInt2=view.findViewById(R.id.reg_Integrante2);
        txtInt3=view.findViewById(R.id.reg_Integrante3);
        txtInt4=view.findViewById(R.id.reg_Integrante4);
        txtIntCorre1=view.findViewById(R.id.reg_CorrIntegrante1);
        txtIntCorre2=view.findViewById(R.id.reg_CorrIntegrante2);
        txtIntCorre3=view.findViewById(R.id.reg_CorrIntegrante3);
        txtIntCorre4=view.findViewById(R.id.reg_CorrIntegrante4);
        gr=view.findViewById(R.id.reg_txtGrupo1);
        btnRegistrar=view.findViewById(R.id.btn_regIntegra1);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(view);
            }
        });


    }

    private void registrar(View view) {
        String int1 = txtInt1.getText().toString();
        String int2 = txtInt2.getText().toString();
        String int3 = txtInt3.getText().toString();
        String int4 = txtInt4.getText().toString();

        if (int1.isEmpty()||int2.isEmpty()||int3.isEmpty()||int4.isEmpty()){
            Snackbar barra = Snackbar.make(view, "No puede dejar los campos en blanco", Snackbar.LENGTH_SHORT);
            View sna = barra.getView();
            sna.setBackgroundColor(getResources().getColor(R.color.rojo));
          //  Toast.makeText(view.getContext(), "No se puede deja en blanco", Toast.LENGTH_SHORT).show();
       barra.show();
        }else{
            if (validarEmail()){
                MIntegrantesV2 mv2 = new MIntegrantesV2();
                db=FirebaseDatabase.getInstance().getReference("usuario/reg").child(txtMatri.getText().toString()).child("integrantes");
                mv2.setMatricula(txtMatri.getText().toString());
                mv2.setIntegrante1(txtInt1.getText().toString());
                mv2.setIntegrante2(txtInt2.getText().toString());
                mv2.setIntegrante3(txtInt3.getText().toString());
                mv2.setIntegrante4(txtInt4.getText().toString());
                mv2.setCorreInt1(txtIntCorre1.getText().toString());
                mv2.setCorreInt2(txtIntCorre2.getText().toString());
                mv2.setCorreInt3(txtIntCorre3.getText().toString());
                mv2.setCorreInt4(txtIntCorre4.getText().toString());
                gr.setSelection(0);
                db.setValue(mv2);
            }
        }

    }

    public boolean validateEmail(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public boolean validarEmail(){

        boolean retorno = true;

        String corr1 = txtIntCorre1.getText().toString();
        String corr2 = txtIntCorre2.getText().toString();
        String corr3 = txtIntCorre3.getText().toString();
        String corr4 = txtIntCorre4.getText().toString();


        if (validateEmail(corr1)==true){
            txtIntCorre1.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (validateEmail(corr2)==true){
            txtIntCorre2.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (validateEmail(corr3)==true){
            txtIntCorre3.setError("Este campo No puede estar vacio");
            retorno=false;}
        if (validateEmail(corr4)==true){
            txtIntCorre1.setError("Este campo No puede estar vacio");
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

    public regIntegrantesVer2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment regIntegrantesVer2.
     */
    // TODO: Rename and change types and number of parameters
    public static regIntegrantesVer2 newInstance(String param1, String param2) {
        regIntegrantesVer2 fragment = new regIntegrantesVer2();
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
        return inflater.inflate(R.layout.fragment_reg_integrantes_ver2, container, false);
    }
}