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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class login extends Fragment {
    private FirebaseAuth fbAs;
    EditText txtEmail, txtcontrsena;
    TextView TexRe, txtRecuCon;
    Button btnIngre;
    NavController control;
    DatabaseReference data;


    boolean Cor=false, pass=false;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment login.
     */
    // TODO: Rename and change types and number of parameters
    public static login newInstance(String param1, String param2) {
        login fragment = new login();
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
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fbAs=FirebaseAuth.getInstance();
        data= FirebaseDatabase.getInstance().getReference();
        txtRecuCon=view.findViewById(R.id.txt_loginRecCon);
        control= Navigation.findNavController(view);
        txtEmail=view.findViewById(R.id.login_txtUser);
        txtcontrsena=view.findViewById(R.id.login_txtContrase);
        txtRecuCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRecuCons(view);
            }
        });
        TexRe=view.findViewById(R.id.Edt_lblRegis);
        TexRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texRegistr(v);
            }
        });
        btnIngre=view.findViewById(R.id.login_btnRegistrar);
        btnIngre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIngresa(v);
            }
        });
    }

    private void txtRecuCons(View view) {
        control.navigate(R.id.recuPerarContrasenia);
    }

    private void btnIngresa(View v) {

        String Email = txtEmail.getText().toString();
        String contrsena = txtcontrsena.getText().toString();

// validaciones
        if (Email.isEmpty() || contrsena.isEmpty()) {
            Toast.makeText(v.getContext(), "Ingresa los datos solicitados", Toast.LENGTH_LONG).show();
        } else
                    fbAs.signInWithEmailAndPassword(Email,contrsena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Map<String, Object>map = new HashMap<>();
                                map.put("Email", Email);
                                map.put("contrsena", contrsena);
                                String id = fbAs.getCurrentUser().getUid();
                                data.child("usuario").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task1) {
                                        if (task1.isSuccessful()){



                                            control.navigate(R.id.menus);
                                            Toast.makeText(v.getContext(), "Ingresaste satisfactoriamente", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                            }else
                                Toast.makeText(v.getContext(), "Error en la Red", Toast.LENGTH_SHORT).show();
                        }
                    });




    }


    private boolean validarmatricula(String matricula) {
    if (matricula.length()!=9){
        return false;
    }else{
        for (int j=0; j<matricula.length();j++){
            char c=matricula.charAt(j);
        if (j == 0 && j != '0'){
            return false;
        }
        if (j==1 && j != '9'){
            return  false;
        }
        if (!(c>='0' && c<= '9')){
            return false;
        }
        }
    }
       return true;
    }



    public boolean validarpassword(String contrsena) {
        boolean numeros=false;
        boolean letras=false;
        for (int i=0; i<contrsena.length(); i++){
            char c = contrsena.charAt(i);
            // si no esta entre A y Z, ni esntre A YZ , ni es un espacio.
            if (((c>= 'a' && c<='z')|| (c>='A' && c<='Z')|| c>= 'ñ' && c<='Ñ'
            )){
                letras=true;
            }
            if ((c>='0' && c<='9')){
                return true;
            }
        }
        if (numeros == true && letras ==true){
            return true;
        }
        return false;
    }

    private void texRegistr(View v) {
        control.navigate(R.id.autoRegistro);
        Toast.makeText(v.getContext(), "Hola", Toast.LENGTH_LONG).show();
    }
}