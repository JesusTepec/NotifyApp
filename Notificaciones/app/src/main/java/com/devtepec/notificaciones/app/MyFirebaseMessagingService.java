package com.devtepec.notificaciones.app;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Jesus on 24/07/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String LOGTAG = "android-fcm";
    @Override public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification() != null) {

            String titulo = remoteMessage.getNotification().getTitle();
            String texto = remoteMessage.getNotification().getBody();

            Log.d(LOGTAG, "Notificacion recibida");
            Log.d(LOGTAG, "Titulo: " + titulo);
            Log.d(LOGTAG, "Texto: " + texto);

            showNotification(titulo, texto);

            Bundle bundle = new Bundle();
            bundle.putString("msgBody", remoteMessage.getNotification().getBody());

            Intent new_intent = new Intent();
            new_intent.setAction("ACTION_STRING_ACTIVITY");
            new_intent.putExtra("msg", bundle);

            sendBroadcast(new_intent);
        }
    }


    private void showNotification(String title, String text) {
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle(title)
                        .setContentText(text);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());
    }
}
