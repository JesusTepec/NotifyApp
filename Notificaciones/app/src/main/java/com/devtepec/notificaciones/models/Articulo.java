package com.devtepec.notificaciones.models;

import com.devtepec.notificaciones.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Jesus on 02/08/2017.
 */

public class Articulo extends RealmObject {

    @PrimaryKey
    private int idArticulo;
    @Required
    private String titulo;
    @Required
    private String contenido;
    @Required
    private Categoria categoria;

    public Articulo(){}

    public Articulo(String titulo, String contenido){
        this.idArticulo = MyAplication.idArticulo.incrementAndGet();
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = new Categoria();
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
