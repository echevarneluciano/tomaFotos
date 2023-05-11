package com.example.tomafotos.request;

import android.util.Log;

import com.example.tomafotos.model.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ApiClient {


    public static void guardar(Usuario usuario, File archivo) {

        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(usuario);
            bos.flush();
            oos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Usuario leer (File archivo) {

        Usuario miPersona = new Usuario();

        try {
            FileInputStream fis=new FileInputStream(archivo);
            BufferedInputStream bis=new BufferedInputStream(fis);
            ObjectInputStream ois=new ObjectInputStream(bis);
            miPersona=(Usuario) ois.readObject();
            ois.close();
            Log.d("salida ",miPersona.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return miPersona;
    }

}
