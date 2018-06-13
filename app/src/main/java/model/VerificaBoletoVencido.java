package model;

import android.app.Activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
/**
 * Created by Guilherme on 10/06/2018.
 */
import com.example.deivi.boletos.MainActivity;

import com.example.deivi.boletos.R;

import dao.BoletoDAO;

public class VerificaBoletoVencido extends BroadcastReceiver  {
    MainActivity m = new MainActivity();
Bundle bundle;
    private  int mId = 0;
View view;


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i ("1","TAAAAA VINDOOO" );
        BoletoDAO b = new BoletoDAO(context);
        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH) + 1;
        int dia = c.get(Calendar.DAY_OF_MONTH);

        String data = dia + "/" + mes + "/" + ano;
        Log.i ("1",data );

        List list = b.listBoletosVirouVencido(data);

        Log.i ("1",list.toString () );

        if (!(list == null)) {

           Notificacao n = new Notificacao();
           n.onCreate(bundle);


        }

    }



   /* NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(context)
                    //.setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!");
    // Creates an explicit intent for an Activity in your app
    Intent resultIntent = new Intent(context, Notificacao.class);

    // The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
// Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(Notificacao.class);
// Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
    PendingIntent resultPendingIntent =
            stackBuilder.getPendingIntent(
                    0,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );
            mBuilder.setContentIntent(resultPendingIntent);
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
            mNotificationManager.notify(mId, mBuilder.build());
    */


}
