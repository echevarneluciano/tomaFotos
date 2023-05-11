package com.example.tomafotos.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.tomafotos.model.Usuario;
import com.example.tomafotos.request.ApiClient;
import com.example.tomafotos.ui.RegistroActivity;

import java.io.File;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void getRegistro(){
        Intent intent = new Intent(context, RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void logear(String mail, String pass){
        //Usuario usuario = ApiClient.leer(context);

        File archivo = new File(context.getFilesDir(),"usuario.dat");
        Usuario usuario = ApiClient.leer(archivo);

        Intent intent = new Intent(context, RegistroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if(mail.equals(usuario.getMail()) && pass.equals(usuario.getPass())){
            intent.putExtra("perfil",true);
            context.startActivity(intent);
        }
    }

}
