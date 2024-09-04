package com.example.atv04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private EditText valorMensal, valorCiclo, qtdeMesesInvestimento, qtdeMesesCiclo, porcentagemRetorno, saldoInicial;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorMensal = findViewById(R.id.valorMensal);
        valorCiclo = findViewById(R.id.valorCiclo);
        qtdeMesesInvestimento = findViewById(R.id.qtdeMesesInvestimento);
        qtdeMesesCiclo = findViewById(R.id.qtdeMesesCiclo);
        porcentagemRetorno = findViewById(R.id.porcentagemRetorno);
        saldoInicial = findViewById(R.id.saldoInicial);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(view -> {
            // Lê os valores digitados nos campos EditText
            double valorMensal = Double.parseDouble(this.valorMensal.getText().toString());
            double valorCiclo = Double.parseDouble(this.valorCiclo.getText().toString());
            int qtdeMesesInvestimento = Integer.parseInt(this.qtdeMesesInvestimento.getText().toString());
            int qtdeMesesCiclo = Integer.parseInt(this.qtdeMesesCiclo.getText().toString());
            double porcentagemRetorno = Double.parseDouble(this.porcentagemRetorno.getText().toString());
            double saldoInicial = Double.parseDouble(this.saldoInicial.getText().toString());

            // Envia os dados para a ResultActivity
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("valorMensal", valorMensal);
            intent.putExtra("valorCiclo", valorCiclo);
            intent.putExtra("qtdeMesesInvestimento", qtdeMesesInvestimento);
            intent.putExtra("qtdeMesesCiclo", qtdeMesesCiclo);
            intent.putExtra("porcentagemRetorno", porcentagemRetorno);
            intent.putExtra("saldoInicial", saldoInicial);
            startActivity(intent);
        });
    }
}
