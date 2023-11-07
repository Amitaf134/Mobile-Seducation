package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.seducation.BancoDeDados.UsuarioController;

public class TelaLogin extends AppCompatActivity {
  private EditText email;
  private EditText senha;
  UsuarioController user;

    public TelaLogin() {
        user = new UsuarioController (this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        Button btLogar = findViewById(R.id.btlogar);
        TextView btCadastro = findViewById(R.id.txt_cadastro);
        email = findViewById(R.id.email_log);
        senha = findViewById(R.id.senha_log);

        String emailL = email.getText().toString();

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.buscarUsuario(emailL) == 1) {


                    Intent i = new Intent(TelaLogin.this, TelaInicial.class);
                    startActivity(i);
                }else{
                    Log.d("Gravacao", "Sem Sucesso");
                }
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaLogin.this, Cadastro.class);
                startActivity(i);
            }
        });

    }
}