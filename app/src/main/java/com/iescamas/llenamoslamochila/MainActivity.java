package com.iescamas.llenamoslamochila;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    HashSet<String> objetosSeleccionados = new HashSet<>();
    TextView txt_peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_peso = findViewById(R.id.txt_Inicial);

        findViewById(R.id.cb_objeto1).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.cb_objeto2).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.cb_objeto3).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.cb_objeto4).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.cb_objeto5).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.cb_objeto6).setOnClickListener(this::ListaSeleccionada);
        findViewById(R.id.btn_Borrar).setOnClickListener(view -> Vaciado());
    }
    private void ListaSeleccionada(View v){

        double pesoActual = 0;
        //Casteamos la vista a CheckBox
        CheckBox cb = (CheckBox) v;
        //Guardamos el nombre en lista de objetos que Set
        //No permite repetir nombres iguales
        String objeto = cb.getText().toString();
        boolean check = cb.isChecked() ? objetosSeleccionados.add(objeto) : objetosSeleccionados.remove(objeto);
        pesoActual = calculo(objetosSeleccionados);
        if (pesoActual > 17) {
            txt_peso.setTextColor(getResources().getColor(R.color.pesoPasado));
        } else {
            txt_peso.setTextColor(getResources().getColor(R.color.black));
        }
        txt_peso.setText("Peso " +(pesoActual)+ "kg");

    }

    private double calculo(HashSet<String> Objetos){

        final double pesoObjeto1 = 1.5;
        final double pesoObjeto2 = 2;
        final double pesoObjeto3 = 4;
        final double pesoObjeto4 = 3;
        final double pesoObjeto5 = 7;
        final double pesoObjeto6 = 6;

        double pesoActual = 0;

        if(!Objetos.isEmpty()){
            for (String objeto:Objetos) {

                if (objeto.equals("Gorras")){
                    pesoActual+=pesoObjeto1;
                }
                if (objeto.equals("Bañadores")){
                    pesoActual+=pesoObjeto2;
                }
                if (objeto.equals("Camisetas")){
                    pesoActual+=pesoObjeto3;
                }
                if (objeto.equals("Zapatos")){
                    pesoActual+=pesoObjeto4;
                }
                if (objeto.equals("Pantalones")){
                    pesoActual+=pesoObjeto5;
                }
                if (objeto.equals("Libros")){
                    pesoActual+=pesoObjeto6;
                }

            }
        }

        return pesoActual;

    }

    private void Vaciado(){

        objetosSeleccionados.clear();
        ((CheckBox)findViewById(R.id.cb_objeto1)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_objeto2)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_objeto3)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_objeto4)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_objeto5)).setChecked(false);
        ((CheckBox)findViewById(R.id.cb_objeto6)).setChecked(false);
        txt_peso.setTextColor(ContextCompat.getColor(this,R.color.black));
        txt_peso.setText("Peso " +0.0+ "kg");
    }

}