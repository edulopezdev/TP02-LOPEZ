package com.ejemplo.tp02_lopez;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ejemplo.tp02_lopez.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm; //view model de la vista
    private ActivityMainBinding binding;//para vincular la vista con el codigo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inicializo el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // aca usamos el binding para setear el contenido de la vista
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() { //escucho el evento click
            @Override
            public void onClick(View v) { //cuando se hace click
                String tituloBuscado = binding.etTitulo.getText().toString();//obtengo el texto del edit text
                vm.buscarEnviarLibro(tituloBuscado);//llamo al metodo del view model porque no debo hacerlo desde la vista
            }
        });

    }
}