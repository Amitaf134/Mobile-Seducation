package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Button btLogar = findViewById(R.id.btlogar);
        TextView btCadastro = findViewById(R.id.txt_cadastro);
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaLogin.this, TelaInicial.class);
                startActivity(i);

            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(i);
            }
        });

    }
}