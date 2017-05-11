package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistroCarros extends AppCompatActivity {
    private EditText placa, precio;
    private Spinner marca, modelo, color;
    private String [] opcMarca, opcModelo, opcColor;
    private ArrayAdapter adapterMarca;
    private ArrayAdapter adapterModelo;
    private ArrayAdapter adapterColor;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carros);
        res=this.getResources();

        placa=(EditText)findViewById(R.id.txtPlaca);
        marca=(Spinner) findViewById(R.id.cmbMarca);
        modelo=(Spinner) findViewById(R.id.cmbModelo);
        color=(Spinner) findViewById(R.id.cmbColor);
        precio=(EditText)findViewById(R.id.txtPrecio);

        opcMarca=res.getStringArray(R.array.opcMarca);
        opcModelo=res.getStringArray(R.array.opcModelo);
        opcColor=res.getStringArray(R.array.opcColor);
        adapterMarca= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcMarca);
        adapterModelo= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcModelo);
        adapterColor= new ArrayAdapter(this, android.R.layout.simple_list_item_1, opcColor);

        marca.setAdapter(adapterMarca);
        modelo.setAdapter(adapterModelo);
        color.setAdapter(adapterColor);
    }

    public void guardar (View v){
        String placaC, marcaC, modeloC, colorC, precioC, foto;

        placaC=placa.getText().toString().trim();
        marcaC=marca.getSelectedItem().toString();
        modeloC=modelo.getSelectedItem().toString();
        colorC=color.getSelectedItem().toString();
        precioC= precio.getText().toString().trim();


        foto=String.valueOf(fotoAleatoria());
        if (validar()) {
            Carro c = new Carro(placaC, marcaC, modeloC, colorC,precioC, foto);
            c.guardar();

            Toast toast1 = Toast.makeText(getApplicationContext(), res.getString(R.string.mensaje), Toast.LENGTH_SHORT);
            toast1.show();
        }


    }

    public int fotoAleatoria(){
        int fotos[]={R.drawable.imagen1,R.drawable.imagen2,R.drawable.imagen3};
        int numero=(int) (Math.random()*3);
        return fotos[numero];
    }

    public boolean validar(){
        if (placa.getText().toString().isEmpty()){
            placa.setError(res.getString(R.string.error1));
            return false;
        }


        if (precio.getText().toString().isEmpty()){
            precio.setError(res.getString(R.string.error1));
            return false;
        }
        return true;
    }

    public void borrar(View v){
        placa.setText("");
        marca.setSelection(0);
        modelo.setSelection(0);
        color.setSelection(0);
        precio.setText("");
    }
}
