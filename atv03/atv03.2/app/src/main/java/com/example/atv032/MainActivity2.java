package com.example.atv032;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textViewNome = findViewById(R.id.nomeDisplay);
        TextView textViewSenha = findViewById(R.id.senhaDisplay);

        Intent intent = getIntent();
        String messageA = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_A);
        String messageB = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_B);

        textViewNome.setText("Nome: " + messageA);
        textViewSenha.setText("Senha: " + messageB);
        }
    }
