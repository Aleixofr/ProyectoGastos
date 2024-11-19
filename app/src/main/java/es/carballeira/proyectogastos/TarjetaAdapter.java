package es.carballeira.proyectogastos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class TarjetaViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tv_titulo;
        TextView tv_categoria;
        TextView tv_descripcion;

        public TarjetaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imagenLista);
            this.tv_titulo = itemView.findViewById(R.id.TituloLista);
            this.tv_categoria = itemView.findViewById(R.id.CategoriaLista);
            this.tv_descripcion = itemView.findViewById(R.id.DescripcionLista);
        }
    }
}
