package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        addBotaoCalcularClickListener();
        carregaSpinner();


    }

    public void addBotaoCalcularClickListener() {
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Meu app", "Meu botão foi clicado");
                Toast.makeText(getApplicationContext(), "Botão Calcular Clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void carregaSpinner() {
        Spinner spOperacao = (Spinner) findViewById(R.id.spOperacao);
        List<String> list = new ArrayList<String>();
        list.add("Somar");
        list.add("Subtrair");
        list.add("Multiplicar");
        list.add("Dividir");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOperacao.setAdapter(dataAdapter);
    }

}