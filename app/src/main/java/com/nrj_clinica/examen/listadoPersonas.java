package com.nrj_clinica.examen;

public class listadoPersonas {
    private String nombre, edad,peso,altura,tipo_sexo,nss,tipo_peso;

    public listadoPersonas(String nombre, String edad, String peso, String altura, String tipo_sexo, String nss, String tipo_peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.tipo_sexo = tipo_sexo;
        this.nss = nss;
        this.tipo_peso = tipo_peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getTipo_sexo() {
        return tipo_sexo;
    }

    public void setTipo_sexo(String tipo_sexo) {
        this.tipo_sexo = tipo_sexo;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTipo_peso() {
        return tipo_peso;
    }

    public void setTipo_peso(String tipo_peso) {
        this.tipo_peso = tipo_peso;
    }
}
