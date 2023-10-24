package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    EditText email, senha;
    Button btLogar;
    TextView cadastro, esqueceuSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_log);
        senha = findViewById(R.id.senha_log);
        cadastro = findViewById(R.id.txt_cadastro);
        esqueceuSenha = findViewById(R.id.bt_esqueceuSenha);
        btLogar = findViewById(R.id.btlogar);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });



    }
}