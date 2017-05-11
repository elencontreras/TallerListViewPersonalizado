package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumeroCarros extends AppCompatActivity {
        private TextView mostrar;
        private Resources res;
        private ArrayList<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_carros);

        res=this.getResources();

        mostrar=(TextView)findViewById(R.id.txtMostrarCantCarros);

        int cant=Datos.getCarros().size();
        mostrar.setText(res.getString(R.string.mens4)+" "+cant);
    }


}
