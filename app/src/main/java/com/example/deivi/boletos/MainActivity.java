package com.example.deivi.boletos;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

import model.VerificaBoletoVencido;


public class MainActivity extends Activity {

    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         calendar = Calendar.getInstance();


        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY, 14);

        boolean alarmeAtivo = (PendingIntent.getBroadcast(this, 0, new Intent("ALARME_DISPARADO"), PendingIntent.FLAG_NO_CREATE) == null);

        if(alarmeAtivo){
            Log.i("Script", "Novo alarme");

            Intent intent = new Intent("ALARME_DISPARADO");
            PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, p);

        }
        else{
            Log.i("Script", "Alarme já ativo");
        }

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.








    }


    public void onTelaCadastrar(View view){
        Intent intent = new Intent(this,CadastrarBoleto.class);
        startActivity(intent);
    }


    public void onTelaExcluir(View view){
        Intent inte = new Intent(this,ExcluirBoleto.class);
        startActivity(inte);
    }

    public void onTelaBoletos(View view){
        Intent intent1 = new Intent (this, ListaDeBoletos.class );
        startActivity(intent1);
    }

    public void onTelaAlterar(View view){
        Intent inten = new Intent(this,AlterarBoleto.class);
        startActivity(inten);
    }

    public void notificação(){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this).setSmallIcon(R.drawable.boleto).setContentTitle("Boleto Vencido").setContentText("Verifique seus boletos você tem um boleto vencido");
// Creates an explicit intent for an Activity
        Intent resultit = new Intent(this, MainActivity.class);
// NotificationManager system service.
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());


    }
    }









