package model;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.example.deivi.boletos.R;

/**
 * Created by Guilherme on 13/06/2018.
 */

public class Notificacao extends Activity {
private int mId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        // .setSmallIcon(R.drawable.ic_input_black_24dp)
                        .setContentTitle("Boleto Atrasado")
                        .setContentText("Verifique Seus boletos! você tem um boleto atrasado!");
// Creates an explicit intent for an Activity
        Intent resultit = new Intent(this, Notificacao.class);
// NotificationManager system service.
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(mId, mBuilder.build());

    }
}