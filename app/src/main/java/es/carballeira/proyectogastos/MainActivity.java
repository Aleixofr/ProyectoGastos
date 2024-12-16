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

//        //Switch para filtrar solo los elementos con cantidad
//        Switch sw_cantidad = findViewById(R.id.sw_cantidad);
//        sw_cantidad.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                // Filtrar tarjetas con cantidad > 0
//                ArrayList<Tarjeta> filtro = new ArrayList<>();
//                for (Tarjeta tarjeta : tarjetas) {
//                    if (tarjeta.getCantidad() > 0) {
//                        filtro.add(tarjeta);
//                    }
//                }
//                tarjetaAdapter.setListaTarjetas(filtro);
//            } else {
//                // Mostrar todas las tarjetas
//                tarjetaAdapter.setListaTarjetas(tarjetas);
//            }
//        });

        //TabLaoyout
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    // Agregar el Fragment dinámicamente
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, new GastosFragment())
                            .commit();
                    return;
                }

                if (tab.getPosition() == 1) {
                    // Agregar el Fragment dinámicamente
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, new CategoriasFragment())
                            .commit();
                    return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Agregar el Fragment dinámicamente
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new GastosFragment())
                .commit();
    }
}