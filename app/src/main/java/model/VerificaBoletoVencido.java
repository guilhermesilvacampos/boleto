package model;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.util.Log;
import android.view.View;
/**
 * Created by Guilherme on 10/06/2018.
 */
import com.example.deivi.boletos.MainActivity;
import com.example.deivi.boletos.Notificacao;
import com.example.deivi.boletos.R;
import com.example.deivi.boletos.MainActivity;

import dao.BoletoDAO;

public class VerificaBoletoVencido extends BroadcastReceiver {
    MainActivity m = new MainActivity();

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

        if (list.isEmpty()) {
           Intent i = new Intent (this, Notificacao.class);



        }

    }
}
