package com.example.calculo_imc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculo_imc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private TextView resultado;
    private TextView classificacao;
    private String txtReturn;

    private Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //start

        resultado = findViewById(R.id.txt_resultado);
        classificacao = findViewById(R.id.txt_classificacao);


        Button botaoCalcular = findViewById(R.id.btn_calcular);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }

            private void calcular() {
                TextView altura = findViewById(R.id.input_altura);
                TextView peso = findViewById(R.id.input_peso);

                double alturaInput = Double.parseDouble(altura.getText().toString());
                double pesoInput = Double.parseDouble(peso.getText().toString());

                double imc = pesoInput/(alturaInput *  alturaInput);

                if (imc < 18.5){
                    txtReturn =  "Filézinho";
                } else if (imc < 25) {
                    txtReturn = "Só não tá melhor que o corinthians";
                } else if (imc < 30) {
                    txtReturn = "Tá grandinho";
                }else {
                    txtReturn = "Investe no projetinho verão";
                }

                resultado.setText(String.valueOf(imc));
                resultado.setVisibility(View.VISIBLE);

                classificacao.setText(String.valueOf(txtReturn));
                classificacao.setVisibility(View.VISIBLE);
            }
        });
    }
}