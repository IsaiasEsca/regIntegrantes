package com.itsoeh.episaias.regintegrantes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.itsoeh.episaias.regintegrantes.Controlador.CRegistro;
import com.itsoeh.episaias.regintegrantes.Modelo.MRegistro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link autoRegistro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class autoRegistro extends Fragment {
    private FirebaseAuth fbR;
    Button btnGuardar;
    NavController nav;
    TextView txtV_autoReg;
    EditText txtMatricula, txtCorreo, Nombre, Matricula, ApePateMater;
    DatabaseReference db;
    String EMAIL_PATTERN = " [A-Za-z0-9]+@itsoeh.edu.mx";

    FirebaseDatabase database;


    private Matcher matcher;
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fbR=FirebaseAuth.getInstance();

            nav= Navigation.findNavController(view);
            Matricula=view.findViewById(R.id.auRe_Matr);
            Nombre=view.findViewById(R.id.auRe_Nom);
            ApePateMater=view.findViewById(R.id.auRe_Apell);
            txtMatricula=view.findViewById(R.id.reg_txtMtr);
            txtCorreo=view.findViewById(R.id.reg_txtCorr);
            db=FirebaseDatabase.getInstance().getReference("usuario/reg");
        btnGuardar=view.findViewById(R.id.auR_btnGuar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnguardar(v);
            }
        });
    }



    private void btnguardar(View v) {
        MRegistro mr = new MRegistro();
        String matricula=txtMatricula.getText().toString();
        String correo = txtCorreo.getText().toString();

        if(matricula.isEmpty() || correo.isEmpty()){
            Toast.makeText(v.getContext(), "Es obligatorio rellenar los campos", Toast.LENGTH_LONG).show();
        }else{
            if(matricula.length()<=8){
                txtMatricula.setError("Una matricula");
                Toast.makeText(v.getContext(), "la matricula debe se de 8 Digitos", Toast.LENGTH_SHORT).show();
            }else{

                if (validateEmail(correo)==true) {
                    txtCorreo.setError("Un email");
                    Toast.makeText(v.getContext(), "INGRESE UN EMAIL VALIDO", Toast.LENGTH_LONG).show();
                }else{
                    fbR.createUserWithEmailAndPassword(correo, matricula).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                db=FirebaseDatabase.getInstance().getReference("usuario/reg").child(Matricula.getText().toString());
                                mr.setMatricula(Matricula.getText().toString());
                                mr.setNombre(Nombre.getText().toString());
                                mr.setApelPaterMater(ApePateMater.getText().toString());
                                db.setValue(mr);
                                Toast.makeText(v.getContext(), "Se ha registrado satisfactoriamente", Toast.LENGTH_SHORT).show();
                                nav.navigate(R.id.login);
                            }else
                                Toast.makeText(v.getContext(), "Error de Red", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }

        }

    }

    public boolean validateEmail(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public autoRegistro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment autoRegistro.
     */
    // TODO: Rename and change types and number of parameters
    public static autoRegistro newInstance(String param1, String param2) {
        autoRegistro fragment = new autoRegistro();
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
        return inflater.inflate(R.layout.fragment_auto_registro, container, false);
    }
}