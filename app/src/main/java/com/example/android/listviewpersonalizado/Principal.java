package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView lista;
    private Resources res;
    private Intent i;
    private Bundle b;
    private String [] opc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res=this.getResources();
        lista= (ListView)findViewById(R.id.lvOpcionesPrincipal);
        opc=res.getStringArray(R.array.opcPrincipal);
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        lista.setAdapter(adapter);
        //Definir el evento al listview

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        i=new Intent(Principal.this,RegistroCarros.class);
                        startActivity(i);
                        break;
                    case 1:
                        i =new Intent(Principal.this, ListarCarros.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(Principal.this, Reportes.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
    }

