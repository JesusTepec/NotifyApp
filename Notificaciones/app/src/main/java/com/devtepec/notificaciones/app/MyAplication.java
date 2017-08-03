package com.devtepec.notificaciones.app;

import android.app.Application;

import com.devtepec.notificaciones.models.Articulo;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Jesus on 02/08/2017.
 */

public class MyAplication extends Application {

    public static AtomicInteger idArticulo = new AtomicInteger();
    public static AtomicInteger idCategoria = new AtomicInteger();

    @Override
    public void onCreate(){
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        idArticulo = getIdByTable(realm, Articulo.class, "idArticulo");
        idCategoria = getIdByTable(realm, Articulo.class, "idCategoria");
        realm.close();
    }

    private void setUpRealmConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass, String campoId){
        RealmResults<T> result = realm.where(anyClass).findAll();
        return (result.size() > 0) ? new AtomicInteger(result.max(campoId).intValue()) : new AtomicInteger();
    }

}
