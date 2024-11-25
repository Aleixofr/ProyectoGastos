package es.carballeira.proyectogastos;

import android.os.Bundle;
import android.util.Log;

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

        Log.i("INFO", "CREANDO DATOS LISTA");
        ArrayList<Tarjeta> tarjetas = new ArrayList<>(Arrays.asList(new Tarjeta[]{
                new Tarjeta("Cine", "Salida al cine con amigos", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 15.0, 0),
                new Tarjeta("Autobús", "Abono mensual del autobús", R.drawable.hogar, Tarjeta.CategoriaTarjeta.TRANSPORTE, 40.0, 0),
                new Tarjeta("Curso Online", "Curso de programación en línea", R.drawable.hogar, Tarjeta.CategoriaTarjeta.EDUCACION, 100.0, 0),
                new Tarjeta("Alquiler", "Pago mensual del alquiler", R.drawable.hogar, Tarjeta.CategoriaTarjeta.VIVIENDA, 800.0, 0),
                new Tarjeta("Supermercado", "Compra semanal de alimentos", R.drawable.ocio, Tarjeta.CategoriaTarjeta.ALIMENTACION, 50.0, 0),
                new Tarjeta("Vacaciones", "Viaje a la playa en verano", R.drawable.ocio, Tarjeta.CategoriaTarjeta.VIAJES, 1200.0, 0),
                new Tarjeta("Teatro", "Entradas para una obra teatral", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 30.0, 0),
                new Tarjeta("Taxi", "Servicio de taxi al aeropuerto", R.drawable.ocio, Tarjeta.CategoriaTarjeta.TRANSPORTE, 25.0, 0)
        }));
        Log.i("INFO", "LISTA CREADA CON " + tarjetas.size() + " ELEMENTOS");

        //Crea el adaptador
        TarjetaAdapter tarjetaAdapter = new TarjetaAdapter(tarjetas);

        RecyclerView rvGastos = findViewById(R.id.rv_gastos);

        rvGastos.setLayoutManager(new LinearLayoutManager(this));

        rvGastos.setAdapter(tarjetaAdapter);
    }
}