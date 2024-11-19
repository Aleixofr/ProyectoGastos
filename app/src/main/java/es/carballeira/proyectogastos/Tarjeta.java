package es.carballeira.proyectogastos;

import android.widget.ImageView;

public class Tarjeta {
    private String titulo;
    private String Descripcion;
    private int imagen; //Ruta de la imagen
    private CategoriaTarjeta categoria;

    public enum CategoriaTarjeta {
        OCIO,
        TRANSPORTE,
        EDUCACION,
        VIVIENDA,
        ALIMENTACION,
        VIAJES
    }

    public Tarjeta(String titulo, String descripcion, int imagen, CategoriaTarjeta categoria) {
        this.titulo = titulo;
        Descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public CategoriaTarjeta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTarjeta categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "titulo='" + titulo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", imagen=" + imagen +
                ", categoria=" + categoria +
                '}';
    }
}
