package com.devtepec.notificaciones.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devtepec.notificaciones.R;

public class SismosActivity extends AppCompatActivity {

    ListView lista;
    String valores [] = new String[]{"Reporte 1", "Reporte2", "Reporte3"};
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sismos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fabAddArticulo);

        lista = (ListView) findViewById(R.id.listaArticulos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valores);
        lista.setAdapter(adapter);

    }

    private void showAlertForCratingArticulo(String titulo, String contenido){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    }
}
