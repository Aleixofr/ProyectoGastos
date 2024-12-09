package es.carballeira.proyectogastos;

import android.content.Context;
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

/**
 * Adaptador para la clase RecyclerView que maneja una lista de objetos de tipo Tarjeta.
 * Vincula los datos de las tarjetas a las vistas correspondientes en el layout.
 */
public class TarjetaAdapter  extends RecyclerView.Adapter<TarjetaAdapter.TarjetaViewHolder> {

    private ArrayList<Tarjeta> lista;

    public TarjetaAdapter(ArrayList<Tarjeta> lista) {

        this.lista = lista;
    }

    /**
     * Crea una nueva vista para un item del RecyclerView.
     *
     * @param parent El ViewGroup que contiene las vistas.
     * @param viewType El tipo de vista (se puede usar para manejar diferentes tipos de elementos, si es necesario).
     * @return Un nuevo ViewHolder que contiene la vista del item.
     */
    @NonNull
    @Override
    public TarjetaAdapter.TarjetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TarjetaAdapter.TarjetaViewHolder tarjetaViewHolder =
                new TarjetaViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false)
                );
        return tarjetaViewHolder;
    }

    /**
     * Vincula los datos de un objeto Tarjeta a la vista del item correspondiente.
     *
     * @param holder El ViewHolder que contiene las vistas donde se mostrarán los datos.
     * @param position La posición del item en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull TarjetaAdapter.TarjetaViewHolder holder, int position) {
        Tarjeta tarjeta = lista.get(position);
        holder.imageView.setImageResource(tarjeta.getImagen());
        holder.tv_titulo.setText(tarjeta.getTitulo());
        holder.tv_categoria.setText(tarjeta.getCategoria().toString());
        holder.tv_descripcion.setText(tarjeta.getDescripcion());
        holder.tv_precio.setText(String.format("%.2f", tarjeta.getPrecio()) + "€");
        holder.tv_cantidad.setText(String.valueOf(tarjeta.getCantidad()));

        //Evento de incrementar
        if(holder.btn_incrementar != null) {
            holder.btn_incrementar.setOnClickListener(view -> {
                tarjeta.setCantidad(tarjeta.getCantidad() + 1);

                notifyItemChanged(position);
            });
        }
        //Evento de decrementar
        if(holder.btn_decrementar != null) {
            holder.btn_decrementar.setOnClickListener(view -> {

                if(tarjeta.getCantidad() != 0) {

                    tarjeta.setCantidad(tarjeta.getCantidad() - 1);

                    notifyItemChanged(position);
                }

            });
        }
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return El número de elementos en la lista.
     */
    @Override
    public int getItemCount() {
        return lista.size();
    }

    /**
     * Actualiza la lista de tarjetas y notifica al adaptador que los datos han cambiado.
     *
     * @param listaTarjetas La nueva lista de tarjetas.
     */
    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.lista = listaTarjetas;
        notifyDataSetChanged();
    }

    /**
     * Clase ViewHolder que contiene las vistas para un item individual del RecyclerView.
     */
    public class TarjetaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_titulo;
        TextView tv_categoria;
        TextView tv_descripcion;
        TextView tv_precio;
        TextView tv_cantidad;
        Button btn_incrementar;
        Button btn_decrementar;

        /**
         * Constructor del ViewHolder.
         *
         * @param itemView La vista que representa un item en el RecyclerView.
         */
        public TarjetaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imagenLista);
            this.tv_titulo = itemView.findViewById(R.id.TituloLista);
            this.tv_categoria = itemView.findViewById(R.id.CategoriaLista);
            this.tv_descripcion = itemView.findViewById(R.id.DescripcionLista);
            this.tv_precio = itemView.findViewById(R.id.tv_precio);
            this.tv_cantidad = itemView.findViewById(R.id.tv_cantidad);
            this.btn_incrementar = itemView.findViewById(R.id.btn_aumentar);
            this.btn_decrementar = itemView.findViewById(R.id.btn_quitar);

        }
    }
}
