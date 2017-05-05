package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Reportes extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Carro> carros;
    private Intent i;
    private Resources res;
    private String [] opc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        res=this.getResources();
        lista=(ListView)findViewById(R.id.lvReportes);
        opc=res.getStringArray(R.array.opcReportes);
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        lista.setAdapter(adapter);
        //Definir el evento al listview

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        i=new Intent(Reportes.this,RegistroCarros.class);
                        startActivity(i);
                        break;
                    case 1:
                        i =new Intent(Reportes.this, ListarCarros.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(Reportes.this, Reportes.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }
    }




