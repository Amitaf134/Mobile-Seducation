package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.seducation.BancoDeDados.Postagens;
import com.example.seducation.BancoDeDados.PostagensController;

import java.text.ParseException;

public class Post extends AppCompatActivity {
    private Button btPostar;
    private EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initComponentes();

    }

    private void initComponentes() {
        texto = findViewById(R.id.edit_post);
        btPostar = findViewById(R.id.bt_post);


        btPostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarPostagem();
                finish();
            }
        });
    }


    private void criarPostagem() {
        long id = -1;//Integer.parseInt(editTextCodigo.getText().toString());
        String post  = texto.getText().toString();

        Postagens postagem = new Postagens(id, post);
        PostagensController postagensController = PostagensController.getInstancia(Post.this);
        if (postagensController.cadastrar(postagem)){
            Log.d("Gravacao", "Ok");
        }else{
            Log.d("Gravacao", "Sem Sucesso");
        }
    }

    }
