package com.devtepec.notificaciones.models;

import com.devtepec.notificaciones.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Jesus on 02/08/2017.
 */

public class Categoria extends RealmObject {

    @PrimaryKey
    private int idCategoria;
    @Required
    private String nombre;
    @Required
    private String estado;

    public Categoria(){}

    public Categoria(String nombre){
        this.idCategoria = MyAplication.idCategoria.incrementAndGet();
        this.nombre = nombre;
        this.estado = "ACTIVO";
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
