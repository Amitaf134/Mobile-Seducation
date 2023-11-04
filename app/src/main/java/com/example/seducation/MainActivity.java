package com.example.seducation;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Button btEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEntrar = findViewById(R.id.bt_entrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TelaLogin.class);
                startActivity(intent);
            }
        });

    }
}