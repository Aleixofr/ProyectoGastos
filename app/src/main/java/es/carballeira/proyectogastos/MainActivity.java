package es.carballeira.proyectogastos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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

        Log.i("INFO", getString(R.string.creando_datos_lista));
        CargarDatos cargarDatos = new CargarDatos();
        ArrayList<Tarjeta> tarjetas = cargarDatos.cargarLista();
        Log.i("INFO", "LISTA CREADA CON " + tarjetas.size() + " ELEMENTOS");

        //Crea el adaptador
        TarjetaAdapter tarjetaAdapter = new TarjetaAdapter(tarjetas);

        RecyclerView rvGastos = findViewById(R.id.rv_gastos);

        rvGastos.setLayoutManager(new LinearLayoutManager(this));

        rvGastos.setAdapter(tarjetaAdapter);

        //Btn Calcular gastos totales
        Button btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("INFO", getString(R.string.se_ha_hecho_click_en_el_btn_de_calcular));
                double totalGastos = 0.00;

                for (Tarjeta tarjeta : tarjetas) {
                    totalGastos += tarjeta.getCantidad() * tarjeta.getPrecio();
                }

                Toast.makeText(MainActivity.this, "Gasto Total: " + String.format("%.2f", totalGastos) + "€", Toast.LENGTH_SHORT).show();
            }
        });

        //Switch para filtrar solo los elementos con cantidad
        Switch sw_cantidad = findViewById(R.id.sw_cantidad);
        sw_cantidad.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Filtrar tarjetas con cantidad > 0
                ArrayList<Tarjeta> filtro = new ArrayList<>();
                for (Tarjeta tarjeta : tarjetas) {
                    if (tarjeta.getCantidad() > 0) {
                        filtro.add(tarjeta);
                    }
                }
                tarjetaAdapter.setListaTarjetas(filtro);
            } else {
                // Mostrar todas las tarjetas
                tarjetaAdapter.setListaTarjetas(tarjetas);
            }
        });
    }
}