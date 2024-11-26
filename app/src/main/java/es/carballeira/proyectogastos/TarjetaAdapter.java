package es.carballeira.proyectogastos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class TarjetaAdapter  extends RecyclerView.Adapter<TarjetaAdapter.TarjetaViewHolder> {

    ArrayList<Tarjeta> lista;

    public TarjetaAdapter(ArrayList<Tarjeta> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public TarjetaAdapter.TarjetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TarjetaAdapter.TarjetaViewHolder tarjetaViewHolder =
                new TarjetaViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false)
                );
        return tarjetaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TarjetaAdapter.TarjetaViewHolder holder, int position) {
        Tarjeta tarjeta = lista.get(position);
        holder.imageView.setImageResource(tarjeta.getImagen());
        holder.tv_titulo.setText(tarjeta.getTitulo());
        holder.tv_categoria.setText(tarjeta.getCategoria().toString());
        holder.tv_descripcion.setText(tarjeta.getDescripcion());
        holder.tv_precio.setText(String.format("%.2f", tarjeta.getPrecio()) + "€");
        holder.tv_cantidad.setText(String.valueOf(tarjeta.getCantidad()));

        holder.btn_incrementar.setOnClickListener(view -> {
            tarjeta.setCantidad(tarjeta.getCantidad() + 1);

            notifyItemChanged(position);
        });

        holder.btn_decrementar.setOnClickListener(view -> {

            if(tarjeta.getCantidad() != 0) {

                tarjeta.setCantidad(tarjeta.getCantidad() - 1);

                notifyItemChanged(position);
            }

        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.lista = listaTarjetas;
        notifyDataSetChanged();
    }

    public class TarjetaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_titulo;
        TextView tv_categoria;
        TextView tv_descripcion;
        TextView tv_precio;
        TextView tv_cantidad;
        ImageButton btn_incrementar;
        ImageButton btn_decrementar;

        public TarjetaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imagenLista);
            this.tv_titulo = itemView.findViewById(R.id.TituloLista);
            this.tv_categoria = itemView.findViewById(R.id.CategoriaLista);
            this.tv_descripcion = itemView.findViewById(R.id.DescripcionLista);
            this.tv_precio = itemView.findViewById(R.id.tv_precio);
            this.tv_cantidad = itemView.findViewById(R.id.tv_cantidad);
            this.btn_incrementar = itemView.findViewById(R.id.btn_aumentar);
            this.btn_decrementar = itemView.findViewById(R.id.btn_decrementar);
        }
    }
}
