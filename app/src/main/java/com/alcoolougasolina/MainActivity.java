package com.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editTextAlcool, editTextGasolina;
    private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextAlcool = findViewById(R.id.txtValorAlcool);
        editTextGasolina = findViewById(R.id.txtValorGasolina);
        textResultado = findViewById(R.id.resultado);
    }


    public void calcular(View view){
        String precoAlcool = editTextAlcool.getText().toString();
        String precoGasolina = editTextGasolina.getText().toString();

        //Validar se campos foram preenchidos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados){
            //Converter String pra Double
            Double vAlcool = Double.parseDouble(precoAlcool);
            Double vGasolina = Double.parseDouble(precoGasolina);

            if((vAlcool/vGasolina) >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }
        }else{
            textResultado.setText("Preencha todos os campos!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){

        boolean camposValidados = true;
        if (pAlcool == null || pAlcool.isEmpty()){
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.isEmpty()){
            camposValidados = false;
        }
        return camposValidados;

    }
}