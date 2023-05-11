package com.example.tomafotos.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tomafotos.login.MainActivity;
import com.example.tomafotos.model.Usuario;
import com.example.tomafotos.request.ApiClient;

import java.io.File;

public class RegistroActivityViewModel extends AndroidViewModel {

    private Context context;
    private Usuario usuario;
    private File archivo;
    private MutableLiveData<Usuario> usuarioLiveData;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        archivo = new File(context.getFilesDir(),"usuario.dat");
    }

    public LiveData<Usuario> cargar() {
        if(this.usuarioLiveData == null){
            this.usuarioLiveData = new MutableLiveData<>();
        }
        return this.usuarioLiveData;
    }

    public void setUsuario(String dni, String apellido, String nombre, String mail, String pass){
        usuario = new Usuario(Long.parseLong(dni), apellido, nombre, mail, pass);

        //ApiClient.guardar(context,usuario);

        ApiClient.guardar(usuario,archivo);

        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void setPerfil(Boolean bool){
        if(bool) {
            //usuario = ApiClient.leer(context);
            usuario = ApiClient.leer(archivo);
            this.usuarioLiveData.setValue(usuario);
        }
    }

    public void getFoto(){
        Intent intent = new Intent(context, com.example.tomafotos.foto.MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
