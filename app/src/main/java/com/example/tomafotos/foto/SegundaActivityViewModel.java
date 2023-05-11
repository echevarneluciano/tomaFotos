package com.example.tomafotos.foto;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tomafotos.ui.RegistroActivity;

import java.io.File;

public class SegundaActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Bitmap> foto;


    //private MutableLiveData<>
    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<Bitmap> getFoto(){
        if(foto==null){
            foto=new MutableLiveData<>();
        }
        return foto;

    }
    public void cargar() {
        File archivo =new File(context.getFilesDir(),"foto1.png");


        Bitmap imageBitmap= BitmapFactory.decodeFile(archivo.getAbsolutePath());
        if(imageBitmap!=null) {

            foto.setValue(imageBitmap);
        }
    }

    public void guardarFoto(){
        if(foto.getValue()!=null){
            Intent intent = new Intent(context, RegistroActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("perfil",true);
            context.startActivity(intent);
        }
    }

}
