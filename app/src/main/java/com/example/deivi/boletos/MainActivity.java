package com.example.deivi.boletos;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


import android.os.Bundle;


import android.view.View;

import java.util.Calendar;

import model.VerificaBoletoVencido;


public class MainActivity extends Activity {
    Calendar calendar;
    NotificationManager mNotificationManager;
    PendingIntent tarefaPendingIntent;
    Intent tarefaIntent;
    private int mId= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY, 6, 13, 11, 6, 10 );

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.



        tarefaIntent = new Intent(this, VerificaBoletoVencido.class);
        tarefaPendingIntent = PendingIntent.getBroadcast(this,0, tarefaIntent,0);



        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

//Definir o alarme para acontecer todos os dias às 10 horas
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, tarefaPendingIntent);




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







}
