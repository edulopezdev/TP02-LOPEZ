package com.ejemplo.tp02_lopez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ejemplo.tp02_lopez.databinding.ActivityLibroBinding;

import Models.Libro;

public class LibroActivity extends AppCompatActivity {
    private ActivityLibroBinding binding;
    private LibroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LibroActivityViewModel.class);
        setContentView(binding.getRoot());

        vm.getMutableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.edtTitulo.setText(libro.getNombre());
                binding.edtAutor.setText(libro.getAutor());
                binding.edtGenero.setText(libro.getGenero());
                binding.edtDescripcion.setText(libro.getDescripcion());
                binding.foto.setImageResource(libro.getFoto());
            }
        });

        //le paso el intent al view model
        vm.recuperarLibroEnviado(getIntent());

    }
}
