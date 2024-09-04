package com.example.atv032;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_A = "com.example.atv02.CAMPO_NOME";
    public static final String EXTRA_MESSAGE_B = "com.example.atv02.CAMPO_SENHA";
    private static final String SENHA_CORRETA = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBotaoListener();
        };

    public void addBotaoListener() {
        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAtitividade2();
            }
        });
    }

    public void abrirAtitividade2() {


        EditText campoNome = (EditText) findViewById(R.id.campoNome);
        EditText campoSenha = (EditText) findViewById(R.id.campoSenha);

        String messageA = campoNome.getText().toString();
        String messageB = campoSenha.getText().toString();

        if (messageB.equals(SENHA_CORRETA)) {
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(EXTRA_MESSAGE_A, messageA);
            intent.putExtra(EXTRA_MESSAGE_B, messageB);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Senha incorreta", Toast.LENGTH_SHORT).show();
        }
    }
    }
