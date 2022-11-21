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
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menus extends Fragment {

    ImageButton btnRegIntegrantes,
                btnRegProyectos,
                btnViCalificaciones;
    ImageView imgClose;
    NavController nav;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nav= Navigation.findNavController(view);
        btnRegIntegrantes=view.findViewById(R.id.inicio_imgBtnRegisInteg);
        btnRegProyectos=view.findViewById(R.id.regPro);
        btnViCalificaciones=view.findViewById(R.id.visualizarCal);
        imgClose=view.findViewById(R.id.close);
        btnRegIntegrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRegIntegrante(view);
            }
        });
        btnRegProyectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRegProyectos(view);
            }
        });
        btnViCalificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnViCalificacioness(view);
            }
        });
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close(view);
            }
        });
    }

    private void close(View view) {
        nav.navigate(R.id.login);
    }

    private void btnViCalificacioness(View view) {
        nav.navigate(R.id.calificaciones);
    }

    private void btnRegProyectos(View view) {
        nav.navigate(R.id.regProyecto);
    }

    private void btnRegIntegrante(View view) {
        nav.navigate(R.id.regIntegrantesVer2);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public menus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menus.
     */
    // TODO: Rename and change types and number of parameters
    public static menus newInstance(String param1, String param2) {
        menus fragment = new menus();
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
        return inflater.inflate(R.layout.fragment_menus, container, false);
    }
}