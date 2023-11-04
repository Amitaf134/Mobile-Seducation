package com.example.seducation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.seducation.databinding.FragmentArtigosBinding;
import com.example.seducation.databinding.FragmentTelaLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tela_login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tela_login extends Fragment {

    public Tela_login() {
        // Required empty public constructor
    }
    public static Tela_login newInstance(String param1, String param2) {
        Tela_login fragment = new Tela_login();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tela_login, container, false);

        Button btLogar = view.findViewById(R.id.btlogar);
        TextView btCadastro = view.findViewById(R.id.txt_cadastro);
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TelaInicial.class);
                startActivity(i);

            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.nav_cadastro);
            }
        });

        return view;
    }
}