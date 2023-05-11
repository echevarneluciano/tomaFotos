package com.example.tomafotos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.example.tomafotos.R;
import com.example.tomafotos.databinding.ActivityRegistroBinding;
import com.example.tomafotos.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_registro);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);

        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.setUsuario(binding.etDni.getText().toString(), binding.etApellido.getText().toString(),
                        binding.etNombre.getText().toString(), binding.etMail.getText().toString(),
                        binding.etPass.getText().toString());
            }
        });

        mv.cargar().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etApellido.setText(usuario.getApellido()+"");
                binding.etNombre.setText(usuario.getNombre()+"");
                binding.etDni.setText(usuario.getDni()+"");
                binding.etMail.setText(usuario.getMail()+"");
                binding.etPass.setText(usuario.getPass()+"");
            }
        });

        mv.cargarFoto().observe(this, new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                binding.ivFoto.setImageBitmap(bitmap);
            }
        });

        binding.btFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.getFoto();
            }
        });

        Intent intent = getIntent();
        mv.setPerfil(intent.getBooleanExtra("perfil",false));

    }
}