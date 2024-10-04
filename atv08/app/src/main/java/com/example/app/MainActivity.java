package com.example.app;

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

    EditText editTextNome, editTextSobre;
    Button buttonInserir;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextSobre = findViewById(R.id.editTextSobre);
        buttonInserir = findViewById(R.id.buttonInserir);
        dbHelper = new DBHelper(this);

        buttonInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String sobrenome = editTextSobre.getText().toString();
                dbHelper.addUser(nome, sobrenome);
                Toast.makeText(MainActivity.this, "Usuario inserido com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonVerUsuarios = findViewById(R.id.buttonVerUsuarios);
        buttonVerUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListUsersActivity.class);
                startActivity(intent);
            }
        });
    }
}