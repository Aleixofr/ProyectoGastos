package es.carballeira.proyectogastos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GastosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GastosFragment extends Fragment {

    ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    CargarDatos cargarDatos = new CargarDatos();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GastosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GastosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GastosFragment newInstance(String param1, String param2) {
        GastosFragment fragment = new GastosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflar el layout
        View view = inflater.inflate(R.layout.fragment_gastos, container, false);



        //Crea el adaptador
        TarjetaAdapter tarjetaAdapter = new TarjetaAdapter(getData());

        //Configurar el recyclerView
        RecyclerView rvGastos = view.findViewById(R.id.rv_gastos);
        rvGastos.setLayoutManager(new LinearLayoutManager(getContext()));

        rvGastos.setAdapter(tarjetaAdapter);


        //FloatButton
        FloatingActionButton float_btn = view.findViewById(R.id.float_btn);
        float_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ShowPopUpMenu(view);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    private  ArrayList<Tarjeta> getData() {
        tarjetas = cargarDatos.cargarLista();
        return tarjetas;
    }

    private void ShowPopUpMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(getContext(), view);
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

    private void CrearSnackBar(String mensaje) {
        Snackbar snackbar = Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG);
        snackbar.setAction("Deshacer", new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i("INFO", "Accion deshecha");
            }
        });
        snackbar.show();
    }
}