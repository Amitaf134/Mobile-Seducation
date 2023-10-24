package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {
 EditText email_cad, senha_cad, nome_user_cad;
 Button btCadastrar;
 TextView logar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        email_cad = findViewById(R.id.email_cad);
        senha_cad = findViewById(R.id.senha_cad);
        nome_user_cad = findViewById(R.id.nome_user_cad);
        logar = findViewById(R.id.txt_login);
        btCadastrar = findViewById(R.id.bt_cadastrar);


        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}