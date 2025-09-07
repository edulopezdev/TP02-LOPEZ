package com.ejemplo.tp02_lopez;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Models.Libro;

public class LibroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mutableLibro;
    public LibroActivityViewModel(@NonNull Application application) {super( application);}
    public LiveData<Libro> getMutableLibro(){
        //aca es donde tengo que inicializar el mutable
        if( mutableLibro == null) {
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }
    public void setMutableLibro(Libro l){
        mutableLibro.setValue(l);
    }

    public void recuperarLibroEnviado(Intent intent) {
        Libro libroEnviado = (Libro)intent.getParcelableExtra("libro Encontrado", Libro.class);

        mutableLibro.setValue(libroEnviado);
    }
}
