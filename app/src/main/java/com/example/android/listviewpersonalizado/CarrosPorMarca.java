package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CarrosPorMarca extends AppCompatActivity {
    private Spinner marca;
    private TextView mostrar;
    private String [] opc;
    private ArrayAdapter adapter;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros_por_marca);
        res=this.getResources();
        marca=(Spinner)findViewById(R.id.cmbConsultarMarca);
        mostrar=(TextView)findViewById(R.id.txtMostrarCantMarca);

        opc=res.getStringArray(R.array.opcMarca);
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opc);
        marca.setAdapter(adapter);
    }

    public void mostrar(View v){
        String m;
        m= marca.getSelectedItem().toString();

        if (m.equals("KIA")) {
            mostrar.setText(res.getString(R.string.mens1)+" "+ Datos.contarKia());
        }else if (m.equals("CHEVROLET")){
            mostrar.setText(res.getString(R.string.mens2)+" "+ Datos.contarChevro());
        }else if (m.equals("NISSAN")){
            mostrar.setText(res.getString(R.string.mens3) +" "+ Datos.contarNissan());
        }
    }
}
