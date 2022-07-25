package com.nrj_clinica.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
   TextInputEditText nombre,edad,peso,altura;
   RadioButton hombre,mujer;
   MaterialButton btn_imc;
   String per_nomb;
   int per_edad;
   float per_peso,per_altura;
    BottomNavigationView mBotonNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.id_persona_nombre);
        edad=findViewById(R.id.persona_edad);
        peso=findViewById(R.id.id_persona_peso);
        altura=findViewById(R.id.id_persona_altura);
        btn_imc=findViewById(R.id.id_calcular_imc);
        hombre=findViewById(R.id.radioHombre);
        mujer=findViewById(R.id.radioMujer);
        //menu
        mBotonNavigation= findViewById(R.id.bottom_navigation);
        mBotonNavigation.setSelectedItemId(R.id.menu_examenBase);

        mBotonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_examenBase:
                        return true;
                    case R.id.menu_examen2:
                        startActivity(new Intent(getApplicationContext(),Examen2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu_examen3:
                        startActivity(new Intent(getApplicationContext(),Examen3.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
        btn_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ComprobarCampos();
            }
        });
    }

     private void ComprobarCampos(){
        if((nombre.length()>=1)&&(edad.length()>=1)&&(peso.length()>=1)&&(altura.length()>=1)){
            if(nombre.length()<4){
                Toast.makeText(this, "El nombre debe de tener al menos 4 caracteres", Toast.LENGTH_SHORT).show();
            }else{
                CalcularImc();
            }
        }else{
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
     }
    private void CalcularImc() {

        char tipo_Sexo='h';
        per_nomb=nombre.getText().toString();
        per_edad= Integer.parseInt(edad.getText().toString());
        per_peso= Float.parseFloat(peso.getText().toString());
        per_altura=Float.parseFloat(altura.getText().toString());
        if(hombre.isChecked()==true){
           tipo_Sexo='h';
        }
        if (mujer.isChecked()==true){
           tipo_Sexo='m';
        }
        Persona persona = new Persona(per_nomb,per_edad,per_peso,per_altura,tipo_Sexo);//enviar a base de datos
        String  calcularImc= Integer.toString(persona.calcularIMC());
        String mayor= Boolean.toString(persona.esMayorDeEdad());
        String NSS= persona.generaNSS();//Enviar a base de datos
        String datos=persona.toString();
        String t_sexo=Character.toString(tipo_Sexo);

        try {
            Intent i =new Intent(MainActivity.this,MostrarDatos_ExBase.class);
            i.putExtra("datos",datos);
            i.putExtra("calcularImc",calcularImc);
            i.putExtra("mayor",mayor);
            i.putExtra("tipo_sexo",t_sexo);
            i.putExtra("nss",NSS);
            startActivity(i);
        }catch (Exception e){
            Log.e("Error","Ha ocurrido un error");
        };


    }
}