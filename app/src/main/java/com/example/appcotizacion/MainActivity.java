package com.example.appcotizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPago;
    private EditText txtPlazo;
    private Button btnCalcular;
    private Button btnLimpiar;
    private TextView lblCotizacion;

    Cotizacion cot = new Cotizacion();
    int numCot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = (Button) findViewById(R.id.calcular);
        txtDescripcion = (EditText) findViewById(R.id.descripcion);
        txtPrecio = (EditText) findViewById(R.id.precio);
        txtPago = (EditText) findViewById(R.id.pagoInicial);
        txtPlazo = (EditText) findViewById(R.id.plazo);
        lblCotizacion = (TextView) findViewById(R.id.cotizacion);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtDescripcion.getText().toString().matches("") || txtPrecio.getText().toString().matches("") ||
                txtPago.getText().toString().matches("") || txtPlazo.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Faltan algunos campos por llenar.", Toast.LENGTH_SHORT).show();
                } else {
                    String descripcion = txtDescripcion.getText().toString();
                    float precio = Float.parseFloat(txtPrecio.getText().toString());
                    int pagoInicial = Integer.parseInt(txtPago.getText().toString());
                    int plazo = Integer.parseInt(txtPlazo.getText().toString());
                    numCot = numCot + 1;
                    cot = new Cotizacion(numCot, descripcion, precio, pagoInicial, plazo);
                    String cotizacion = cot.imprimirCotizacion().toString();
                    lblCotizacion.setText(cotizacion);
                }
            }
        });

        btnLimpiar = (Button) findViewById(R.id.limpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPago.setText("");
                txtPlazo.setText("");
                lblCotizacion.setText("");
            }
        });
    }
}