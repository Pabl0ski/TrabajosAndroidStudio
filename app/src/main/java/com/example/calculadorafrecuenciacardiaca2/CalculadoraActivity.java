package com.example.calculadorafrecuenciacardiaca2;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculadoraActivity extends AppCompatActivity {

    private EditText etEdad, etPeso, etAltura;
    private Spinner spSexo;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        etEdad = findViewById(R.id.etEdad);
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        spSexo = findViewById(R.id.spSexo);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFCM();
            }
        });

        Spinner spSexo = findViewById(R.id.spSexo);

        // Crea el adaptador usando el layout personalizado
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sexo_array, R.layout.spinner_item);

        // Aplica el diseño también a la vista desplegable del Spinner
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spSexo.setAdapter(adapter);

        // Configuración del botón "Volver a Inicio"
        Button btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la actividad actual para regresar a MainActivity
                finish();
            }
        });
    }

    private void calcularFCM() {
        // Verifica que todos los campos estén llenos
        if (etEdad.getText().toString().isEmpty() ||
                etPeso.getText().toString().isEmpty() ||
                etAltura.getText().toString().isEmpty()) {

            // Muestra un mensaje de advertencia
            Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
            return; //Termina la ejecución de este método si falta algún campo
        }

        // Obtén los valores de entrada
        int edad = Integer.parseInt(etEdad.getText().toString());
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        String sexo = spSexo.getSelectedItem().toString();

        // Calcula la FCM según sexo
        double fcm;
        if (sexo.equals("Masculino")) {
            fcm = 220 - edad;
        } else {
            fcm = 226 - edad;
        }

        // Ajuste simple considerando el peso y la altura
        fcm += (peso + altura / 100) * 0.05;

        // Muestra el resultado en el TextView
        tvResultado.setText("Resultado: " + Math.round(fcm) + " bpm");
    }
}
