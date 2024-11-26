package es.carballeira.proyectogastos;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class CargarDatos {

    private ArrayList<Tarjeta> lista;

    public ArrayList<Tarjeta> cargarLista() {
        Log.i("CARGA", "Se ha llamado al metodo cargarLista");

        lista = new ArrayList<>(Arrays.asList(new Tarjeta[]{
                // OCIO
                new Tarjeta("Cine", "Salida al cine con amigos", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 15.0, 0),
                new Tarjeta("Teatro", "Entradas para una obra teatral", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 30.0, 0),
                new Tarjeta("Concierto", "Entradas para un concierto", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 50.0, 0),
                new Tarjeta("Streaming", "Suscripción mensual a streaming", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 12.0, 0),
                new Tarjeta("Juego de mesa", "Compra de un juego de mesa", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 20.0, 0),

                // TRANSPORTE
                new Tarjeta("Autobús", "Abono mensual del autobús", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 40.0, 0),
                new Tarjeta("Taxi", "Servicio de taxi al aeropuerto", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 25.0, 0),
                new Tarjeta("Gasolina", "Llenado del tanque de gasolina", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 60.0, 0),
                new Tarjeta("Mantenimiento", "Revisión anual del coche", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 150.0, 0),
                new Tarjeta("Bicicleta", "Arreglo de la bicicleta", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 30.0, 0),

                // EDUCACIÓN
                new Tarjeta("Curso Online", "Curso de programación en línea", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 100.0, 0),
                new Tarjeta("Libros", "Compra de libros de texto", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 50.0, 0),
                new Tarjeta("Clases particulares", "Clases de idiomas", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 200.0, 0),
                new Tarjeta("Certificación", "Certificación oficial", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 300.0, 0),
                new Tarjeta("Material escolar", "Compra de material escolar", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 25.0, 0),

                // VIVIENDA
                new Tarjeta("Alquiler", "Pago mensual del alquiler", R.drawable.vivienda, Tarjeta.CategoriaTarjeta.VIVIENDA, 800.0, 0),
                new Tarjeta("Luz", "Factura mensual de luz", R.drawable.vivienda, Tarjeta.CategoriaTarjeta.VIVIENDA, 60.0, 0),
                new Tarjeta("Agua", "Factura mensual de agua", R.drawable.vivienda, Tarjeta.CategoriaTarjeta.VIVIENDA, 30.0, 0),
                new Tarjeta("Internet", "Pago mensual de internet", R.drawable.vivienda, Tarjeta.CategoriaTarjeta.VIVIENDA, 50.0, 0),
                new Tarjeta("Reparaciones", "Reparación de electrodomésticos", R.drawable.vivienda, Tarjeta.CategoriaTarjeta.VIVIENDA, 100.0, 0),

                // ALIMENTACIÓN
                new Tarjeta("Supermercado", "Compra semanal de alimentos", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 50.0, 0),
                new Tarjeta("Restaurante", "Cena en un restaurante", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 70.0, 0),
                new Tarjeta("Cafetería", "Café y snack", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 10.0, 0),
                new Tarjeta("Frutería", "Compra de frutas y verduras", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 30.0, 0),
                new Tarjeta("Carnicería", "Compra de carne y embutidos", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 40.0, 0),

                // VIAJES
                new Tarjeta("Vacaciones", "Viaje a la playa en verano", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 1200.0, 0),
                new Tarjeta("Escapada", "Fin de semana en la montaña", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 400.0, 0),
                new Tarjeta("Avión", "Billete de avión", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 300.0, 0),
                new Tarjeta("Hotel", "Estancia en un hotel", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 800.0, 0),
                new Tarjeta("Excursión", "Tour en una ciudad", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 100.0, 0),

                // OCIO (nuevos elementos)
                new Tarjeta("Parque de atracciones", "Entrada al parque", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 45.0, 0),
                new Tarjeta("Videojuegos", "Nuevo videojuego", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 60.0, 0),
                new Tarjeta("Deporte", "Clases de tenis", R.drawable.ocio, Tarjeta.CategoriaTarjeta.OCIO, 80.0, 0),

                // TRANSPORTE (nuevos elementos)
                new Tarjeta("Tren", "Billete de tren", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 20.0, 0),
                new Tarjeta("Uber", "Viaje en Uber", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 15.0, 0),
                new Tarjeta("Patinete", "Alquiler de patinete eléctrico", R.drawable.transporte, Tarjeta.CategoriaTarjeta.TRANSPORTE, 10.0, 0),

                // EDUCACIÓN (nuevos elementos)
                new Tarjeta("Conferencia", "Asistencia a una conferencia", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 150.0, 0),
                new Tarjeta("Seminario", "Participación en un seminario", R.drawable.educacion, Tarjeta.CategoriaTarjeta.EDUCACION, 100.0, 0),

                // ALIMENTACIÓN (nuevos elementos)
                new Tarjeta("Heladería", "Compra de helados", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 15.0, 0),
                new Tarjeta("Panadería", "Compra de pan y bollería", R.drawable.alimentacion, Tarjeta.CategoriaTarjeta.ALIMENTACION, 10.0, 0),

                // VIAJES (nuevos elementos)
                new Tarjeta("Crucero", "Viaje en crucero", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 2500.0, 0),
                new Tarjeta("Autocaravana", "Alquiler de autocaravana", R.drawable.viajes, Tarjeta.CategoriaTarjeta.VIAJES, 1500.0, 0)
        }));





        return lista;
    }
}
