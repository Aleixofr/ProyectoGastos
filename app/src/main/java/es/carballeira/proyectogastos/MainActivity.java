package es.carballeira.proyectogastos;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Tarjeta> tarjetas;

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

        //Se carga la lista de datos
        Log.i("INFO", getString(R.string.creando_datos_lista));
        CargarDatos cargarDatos = new CargarDatos();
        tarjetas = cargarDatos.cargarLista();
        Log.i("INFO", "LISTA CREADA CON " + tarjetas.size() + " ELEMENTOS");

        //Crea el adaptador
        TarjetaAdapter tarjetaAdapter = new TarjetaAdapter(tarjetas);

        RecyclerView rvGastos = findViewById(R.id.rv_gastos);

        rvGastos.setLayoutManager(new LinearLayoutManager(this));

        rvGastos.setAdapter(tarjetaAdapter);

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

        //TabLaoyout
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 1) {
                    CrearSnackBar("Proximamente");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //FloatButton
        FloatingActionButton float_btn = findViewById(R.id.float_btn);
        float_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ShowPopUpMenu(view);
            }
        });

    }

    private void CrearSnackBar(String mensaje) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.main), mensaje, Snackbar.LENGTH_LONG);
        snackbar.setAction("Deshacer", new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i("INFO", "Accion deshecha");
            }
        });
        snackbar.show();
    }

    public void ShowPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.acciones, popupMenu.getMenu());

        //Manejando Clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                TextView tv;
                if (menuItem.getItemId() == R.id.opt_add) {
                    CrearSnackBar("Proximamente");
                }
                if (menuItem.getItemId() == R.id.opt_calcular) {
                    Log.i("INFO", getString(R.string.se_ha_hecho_click_en_el_btn_de_calcular));
                    double totalGastos = 0.00;

                    for (Tarjeta tarjeta : tarjetas) {
                        totalGastos += tarjeta.getCantidad() * tarjeta.getPrecio();
                    }
                    String mensaje = "Gasto Total: " + String.format("%.2f", totalGastos) + "€";
                    CrearSnackBar(mensaje);
                }

                return true;
            }
        });
        popupMenu.show();
    }
}