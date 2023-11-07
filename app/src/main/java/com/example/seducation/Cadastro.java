package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.seducation.BancoDeDados.Usuario;
import com.example.seducation.BancoDeDados.UsuarioController;

public class Cadastro extends AppCompatActivity {


    private EditText nomeUser, emailUser, senhaUser;
    private Button btCadastrar;
    private TextView btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        nomeUser = findViewById(R.id.nome_user_cad);
        emailUser = findViewById(R.id.email_cad);
        senhaUser = findViewById(R.id.senha_cad);
        btLogin = findViewById(R.id.txt_login);
        btCadastrar = findViewById(R.id.bt_cadastrar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cadastro.this, TelaLogin.class);
                startActivity(i);
            }
        });

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
                Intent i = new Intent(Cadastro.this, TelaInicial.class);
                startActivity(i);

            }

        });
        System.out.println("AAAAAAA");
    }



    private void cadastrarUsuario(){
        int id = -1;//Integer.parseInt(editTextCodigo.getText().toString());
        String nome  = nomeUser.getText().toString();
        String email  = emailUser.getText().toString();
        String senha  = senhaUser.getText().toString();
        Usuario usuario = new Usuario(id, nome, email, senha);
        UsuarioController usuarioController = UsuarioController.getInstancia(Cadastro.this);
        if (usuarioController.cadastrar(usuario)){
            Log.d("Gravacao", "Ok");
        }else{
            Log.d("Gravacao", "Sem Sucesso");
        }
    }
    }
