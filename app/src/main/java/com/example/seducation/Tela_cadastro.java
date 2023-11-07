package com.example.seducation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tela_cadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tela_cadastro extends Fragment {


    public Tela_cadastro() {
        // Required empty public constructor
    }

    public static Tela_cadastro newInstance(String param1, String param2) {
        Tela_cadastro fragment = new Tela_cadastro();
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
        View view = inflater.inflate(R.layout.fragment_tela_cadastro, container, false);
        return view;
    }
}