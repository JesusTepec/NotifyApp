package com.devtepec.notificaciones.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devtepec.notificaciones.R;

public class Main extends AppCompatActivity implements View.OnClickListener {

    Button btnSismos;


    private BroadcastReceiver activityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView textview = (TextView) findViewById(R.id.campo);
            Bundle bundle = intent.getBundleExtra("msg");
            textview.setText(bundle.getString("msgBody"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSismos = (Button) findViewById(R.id.btn_sismos);
        btnSismos.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sismos:
                Intent intent = new Intent(Main.this, SismosActivity.class);
                startActivity(intent);
                break;
        }
    }
}
