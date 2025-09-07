package com.ejemplo.tp02_lopez;

import android.content.Intent;

import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import Models.Libro;

public class MainActivityViewModel extends AndroidViewModel {
    private List<Libro> listaLibros;
    public MainActivityViewModel(android.app.Application application) {super(application);}

    public void cargarListaLibros() {
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("1984", "George Orwell", "Distopía", "Un futuro con vigilancia total.", R.drawable.uno));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", "Historia de la familia Buendía en Macondo.", R.drawable.dos));
        listaLibros.add(new Libro("El Hobbit", "J.R.R. Tolkien", "Fantasía", "Bilbo vive una aventura inesperada junto a enanos y un mago.", R.drawable.tres));
        listaLibros.add(new Libro("Orgullo y prejuicio", "Jane Austen", "Romance", "Elizabeth Bennet enfrenta el amor y las normas sociales.", R.drawable.cuatro));
        listaLibros.add(new Libro("Matar a un ruiseñor", "Harper Lee", "Drama", "Una niña en el sur de EE. UU. aprende sobre justicia y racismo.", R.drawable.cinco));
        listaLibros.add(new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", "Realismo mágico", "Un asesinato anunciado que nadie logra impedir.", R.drawable.seis));
        listaLibros.add(new Libro("Fahrenheit 451", "Ray Bradbury", "Ciencia ficción", "Una sociedad donde los libros están prohibidos.", R.drawable.siete));
        listaLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Aventura", "Un caballero loco y su fiel escudero recorren España.", R.drawable.ocho));
        listaLibros.add(new Libro("Drácula", "Bram Stoker", "Terror", "La historia clásica del conde vampiro de Transilvania.", R.drawable.nueve));
        listaLibros.add(new Libro("Los juegos del hambre", "Suzanne Collins", "Distopía", "Katniss lucha por sobrevivir en una competencia mortal.", R.drawable.diez));
    }
    public void buscarEnviarLibro(String tituloBuscado ) {
        cargarListaLibros();
        for (Libro libroAuxiliar: listaLibros) {
            if (libroAuxiliar.getNombre().equalsIgnoreCase(tituloBuscado)) {
                //si lo encuentro abro la actividad de detalles
                Intent intent = new Intent(getApplication().getApplicationContext(), LibroActivity.class);
                //ahora cargo el libro con el metodo putExtra
                intent.putExtra("libro Encontrado", libroAuxiliar);
                //al no estar en una actividad debo agregar este flag para que funcione
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                //voy a necesitar el contexto de la aplicacion
                getApplication().startActivity(intent);
            }
        }
    }
}
