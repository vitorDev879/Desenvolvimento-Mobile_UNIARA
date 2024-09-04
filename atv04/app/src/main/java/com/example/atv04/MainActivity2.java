package com.example.atv04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        carregaLista();
    }

    public void carregaLista() {
        ListView lisResultados = (ListView) findViewById(R.id.listResultados);
        List<String> listResult = new ArrayList<String>();

        Intent intent = getIntent();
        double valorMensal = intent.getDoubleExtra("valorMensal", 0);
        double valorCiclo = intent.getDoubleExtra("valorCiclo", 0);
        int qtdeMesesInvestimento = intent.getIntExtra("qtdeMesesInvestimento", 0);
        int qtdeMesesCiclo = intent.getIntExtra("qtdeMesesCiclo", 0);
        double porcentagemRetorno = intent.getDoubleExtra("porcentagemRetorno", 0);
        double saldoInicial = intent.getDoubleExtra("saldoInicial", 0);

        double saldo = saldoInicial;
        for (int mes = 1; mes <= qtdeMesesInvestimento; mes++) {
            double juros = saldo * (porcentagemRetorno / 100);
            saldo += valorMensal + juros;

            String resultado = "Mês: " + mes + " - Juros sobre Saldo: R$ " + String.format("%.2f", juros) + " - Saldo: R$ " + String.format("%.2f", saldo);
            listResult.add(resultado);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listResult);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lisResultados.setAdapter(dataAdapter);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> finish());
    }
}