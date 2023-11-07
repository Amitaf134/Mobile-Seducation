package com.example.seducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.seducation.databinding.ActivityTelaCrudBinding;
import com.example.seducation.databinding.ActivityTelaInicialBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;



public class TelaCrud extends AppCompatActivity {

    private ActivityTelaCrudBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaCrudBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}