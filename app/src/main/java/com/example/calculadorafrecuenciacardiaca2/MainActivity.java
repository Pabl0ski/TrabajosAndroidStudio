package com.example.calculadorafrecuenciacardiaca2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar el Listener al botón
        findViewById(R.id.btnIrCalculadora).setOnClickListener(new ButtonClickListener());
    }
    // Clase privada que maneja el clic en el botón
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
            startActivity(intent);
        }

    }
}
