package com.example.android.listviewpersonalizado;

import android.content.res.Resources;

import java.util.ArrayList;

/**
 * Created by Android on 05/05/2017.
 */

public class Datos {
    private static Resources res;
    private static ArrayList<Carro> carros = new ArrayList<>();

    public static  void guardar (Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> getCarros(){
        return carros;
    }



    public static int contarKia(){
        int n=0;
        for (int i=0; i<carros.size(); i++){
            if (carros.get(i).getMarca().equals("KIA")){
                n++;
            }
        }
        return n;
    }

    public static int contarChevro(){
        int n=0;
        for (int i=0; i<carros.size(); i++){
            if (carros.get(i).getMarca().equals("CHEVROLET")){
                n++;
            }
        }
        return n;
    }

    public static int contarNissan(){
        int n=0;
        for (int i=0; i<carros.size(); i++){
            if (carros.get(i).getMarca().equals("NISSAN")){
                n++;
            }
        }
        return n;
    }




}


