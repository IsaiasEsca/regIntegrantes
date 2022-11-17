package com.itsoeh.episaias.regintegrantes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menu extends Fragment {
    CardView cardregAlumno, cardIntegrantes, cardProyecto, cardCalificacion;
    NavController navController;
    ImageView imgClose;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController= Navigation.findNavController(view);
        imgClose=view.findViewById(R.id.close);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                imgCloses(v);
            }
        });
        cardCalificacion=view.findViewById(R.id.cardCalififi);
        cardCalificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardCalificacionsr(v);
            }
        });
        cardProyecto=view.findViewById(R.id.proyectoresgis);
        cardProyecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardProyectos(v);
            }

            private void cardProyectos(View v) {
                navController.navigate(R.id.regProyecto);
            }
        });
        cardregAlumno=view.findViewById(R.id.car_regAlumnoc);
        cardIntegrantes=view.findViewById(R.id.regIntegrantes);
        cardIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardReInte();
            }
        });
        cardregAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardregAlumn();
            }
        });

    }

    private void imgCloses(View v) {
        FirebaseAuth.getInstance().signOut();
        navController.navigate(R.id.login);
    }

    private void cardCalificacionsr(View v) {
        navController.navigate(R.id.calificaciones);
    }

    private void cardReInte() {
        navController.navigate(R.id.regIntegrantes);
    }

    private void cardregAlumn() {
        navController.navigate(R.id.regAlumno);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menu.
     */
    // TODO: Rename and change types and number of parameters
    public static menu newInstance(String param1, String param2) {
        menu fragment = new menu();
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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}