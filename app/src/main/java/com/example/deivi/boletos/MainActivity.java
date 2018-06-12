package com.example.deivi.boletos;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;

import java.util.Calendar;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    // Set the alarm to start at approximately 2:00 pm


   /* Calendar calendar = Calendar.getInstance();

calendar.setTimeInMillis(System.currentTimeMillis());

 calendar.set(Calendar.HOUR_OF_DAY, 14);

    // With setInexactRepeating(), you have to use one of the AlarmManager interval
    // constants--in this case, AlarmManager.INTERVAL_DAY.
 alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
    AlarmManager.INTERVAL_DAY, tarefaIntent);


    Intent tarefaIntent = new Intent(context, ExecutarTarefaProgramadaReceiver.class);
    PendingIntent tarefaPendingIntent = PendingIntent.getBroadcast(context,1234, tarefaIntent,0);

    AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

//Definir o alarme para acontecer todos os dias às 10 horas
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
    AlarmManager.INTERVAL_DAY, tarefaPendingIntent);*/



}
