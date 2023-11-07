package com.example.seducation;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.seducation.BancoDeDados.ListaPostagemAdapter;
import com.example.seducation.BancoDeDados.PostagensController;
import com.example.seducation.BancoDeDados.Usuario;
import com.example.seducation.BancoDeDados.UsuarioController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.seducation.R.drawable;

import com.example.seducation.databinding.ActivityTelaInicialBinding;

import java.util.List;

public class TelaInicial extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityTelaInicialBinding binding;
    private ImageView imageView;
    private TextView nomeUser;
    private Button btSair;
    private List<Usuario> usuarios;

    ListaPostagemAdapter listaPostagemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaInicialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarTelaInicial.toolbar);
        binding.appBarTelaInicial.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_artigos, R.id.nav_sobre_nos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_inicial);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
       //fazer essa merda
        PostagensController postagensController = PostagensController.getInstancia(this);

        ListView listView = findViewById(R.id.list_post);
        listaPostagemAdapter = new ListaPostagemAdapter(this);
        listView.setAdapter(listaPostagemAdapter);
        btSair = findViewById(R.id.action_sair);

        FloatingActionButton btPost = findViewById(R.id.postagem);
        btPost.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(TelaInicial.this, Post.class);
            startActivity(i);
        }
    });

            btSair.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(TelaInicial.this, TelaLogin.class);
                    startActivity(i);
                }
            });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_inicial, menu);
        return true;
    }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_inicial);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
   protected void onResume() {
        super.onResume();
        listaPostagemAdapter.atualizarLista();
    }

}