package es.carballeira.proyectogastos;

import android.widget.ImageView;

public class Tarjeta {
    private String titulo;
    private String Descripcion;
    private int imagen; //Ruta de la imagen
    private CategoriaTarjeta categoria;
    private double precio;
    private int cantidad;

    public enum CategoriaTarjeta {
        OCIO,
        TRANSPORTE,
        EDUCACION,
        VIVIENDA,
        ALIMENTACION,
        VIAJES
    }

    public Tarjeta(String titulo, String descripcion, int imagen, CategoriaTarjeta categoria, double precio, int cantidad) {
        this.titulo = titulo;
        Descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Tarjeta(int cantidad, CategoriaTarjeta categoria, double precio, String descripcion, String titulo) {
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
        Descripcion = descripcion;
        this.titulo = titulo;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "titulo='" + titulo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", imagen=" + imagen +
                ", categoria=" + categoria +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
