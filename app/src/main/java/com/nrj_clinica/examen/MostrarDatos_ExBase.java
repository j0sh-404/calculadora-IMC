package com.nrj_clinica.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MostrarDatos_ExBase extends AppCompatActivity {
 EditText nombre,edad,peso,altura;
 EditText imc_tipoPeso,mayor_edad;
 Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos__ex_base);
        nombre= findViewById(R.id.nombre);
        edad=findViewById(R.id.lista_edad);
        peso=findViewById(R.id.peso);
        altura=findViewById(R.id.altura);
        imc_tipoPeso=findViewById(R.id.tipo_peso);
        mayor_edad=findViewById(R.id.mayor_edad);
        contexto=this;
        mostrarDatos();
    }

    private void mostrarDatos(){
         Bundle extras=getIntent().getExtras();
         String datos=extras.getString("datos");
         String[] separacion = datos.split(",");//separacion de cadena por el siguiente caracter ,
         String imc=extras.getString("calcularImc");
         String mayor=extras.getString("mayor");
         String tipo_sexo=extras.getString("tipo_sexo");
         String NSS =extras.getString("nss");
         nombre.setText(separacion[0]);
         edad.setText(separacion[1]);
         peso.setText(separacion[2]);
         altura.setText(separacion[3]);
         String t_peso,t_Sexo="";
         //Mostrar alertas

        if(imc.equals("-1")){//mostrar mensaje de peso bajo
          imc_tipoPeso.setText("Falta de peso");
          t_peso="Falta de peso";
          new PesoBajo(contexto);
        }else if(imc.equals("0")){
            imc_tipoPeso.setText("Peso normal");
            t_peso="Peso normal";
            new PesoNormal(contexto);
        }else{
            imc_tipoPeso.setText("Sobrepeso");
            t_peso="Sobrepeso";
            new DialogoSobrepeso(contexto);
        }


        if(mayor.equals("true")){
            mayor_edad.setText("Eres mayor de edad");
        }else{
            mayor_edad.setText("Eres menor edad");
        }


        if (tipo_sexo.equals("h")){
            t_Sexo="Masculino";
        }else{t_Sexo="Femenino";}
    //Guardar datos en Sqlite

        try {
            final BasedeDatos conexion = new BasedeDatos(getApplicationContext());
            conexion.agregarPersona(separacion[0],separacion[1],separacion[2],separacion[3],t_Sexo,NSS,t_peso);

        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}