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
    NotificationManager mNotificationManager;
    PendingIntent tarefaPendingIntent;
    AlarmManager alarmManager;
    Intent tarefaIntent;
    private int mId= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());

        calendar.set(Calendar.HOUR_OF_DAY, 6, 13, 14,24 , 10 );

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.

        Log.i("1","BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
         alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        tarefaIntent = new Intent(this, VerificaBoletoVencido.class);
        tarefaPendingIntent = PendingIntent.getBroadcast(this,0, tarefaIntent,0);

        Log.i("1","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");




        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, tarefaPendingIntent);

        Log.i("1","PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
/*
        if (alarmManager!= null) {
            alarmManager.cancel(tarefaPendingIntent);
            Log.i("1","Cancelouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        }
*/
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
