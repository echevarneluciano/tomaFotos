package com.example.tomafotos.foto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tomafotos.R;
import com.example.tomafotos.databinding.ActivitySegundaBinding;

public class SegundaActivity extends AppCompatActivity {
    private ImageView fotoLeer;
    private ActivitySegundaBinding binding;
    private SegundaActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_segunda);
        binding=ActivitySegundaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);
        fotoLeer=findViewById(R.id.fotoLeer);

        vm.getFoto().observe(this, new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                fotoLeer.setImageBitmap(bitmap);
            }
        });

        binding.btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.guardarFoto();
            }
        });

        vm.cargar();
        //Puedo mostrar la foto con el codigo que se encuentra comentado más abajo.

        /*File archivo =new File(getFilesDir(),"foto1.png");
        Glide.with(this)
                .load(archivo)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(fotoLeer);*/



    }
}