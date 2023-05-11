package com.example.tomafotos.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tomafotos.R;
import com.example.tomafotos.databinding.ActivityLoginBinding;
import com.example.tomafotos.databinding.ActivityMainBinding;
import com.example.tomafotos.login.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.getRegistro();
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.logear(binding.etMail.getText().toString(),binding.etPass.getText().toString());
            }
        });

    }
}