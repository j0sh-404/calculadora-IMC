package com.nrj_clinica.examen;

import android.content.Intent;
import android.widget.Toast;

import java.io.Serializable;

public class Persona {

    private String nombre, NSS;
    private int edad;
    char sexo;
    final private int peso_bajo= -1;
    final private int peso_ideal=0;
    final private int sobre_peso=1;
    final private int numero=8;
    private float peso, altura;
    int tipo_peso;
    private boolean tipo_sexo;




    public Persona(String nombre, int edad, float peso, float altura, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo=sexo;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public char getSexo() {
        return sexo;
    }
    public float getPeso() {
        return peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public void  setSexo(char sexo){this.sexo=sexo;}
    //calcular el IMC
    public  boolean comprobarSexo(){
        if(sexo=='h'){
            tipo_sexo=true;
        }else{
            tipo_sexo=false;
        }
     return tipo_sexo;
    }
    public int calcularIMC(){
         float persona_peso=peso/(altura*altura);
         if(sexo=='h'){
              if(persona_peso<20){
                  tipo_peso=peso_bajo;
              }else  if((persona_peso>=20)&&(persona_peso<=25)){
                  tipo_peso=peso_ideal;
              }else{
                  tipo_peso=sobre_peso;
              }
         }else{
             if(persona_peso<19){
                 tipo_peso=peso_bajo;
             }else if((persona_peso>=19)&&(persona_peso<=24)){
                 tipo_peso=peso_ideal;
             }else{
                 tipo_peso=sobre_peso;
             }

            }
         return tipo_peso ;
    }
    public boolean esMayorDeEdad(){
        boolean esMayor;
        if (edad>=18){
            esMayor=true;
        }else{
            esMayor=false;
        }
        return  esMayor;
    }
    public String generaNSS(){
        String numerosYLetras="ABCDFGHIJKLMNOPQRSTUVWXYZ" +
                               "0123456789";
        StringBuilder nuevo = new StringBuilder(numero);
        for (int i =0;i<numero;i++){
            int index=(int)(numerosYLetras.length()*Math.random());
            nuevo.append(numerosYLetras.charAt(index));
        }
        return nuevo.toString();
    }

    public String toString(){
        String p_edad =Integer.toString(edad);
        String p_peso=Float.toString(peso);
        String p_altura=Float.toString(altura);
        return nombre+","+p_edad+","+p_peso+","+p_altura;
    }


public Persona(){}



}


