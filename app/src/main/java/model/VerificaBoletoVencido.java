package model;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;
import java.util.List;
import android.app.Activity;
/**
 * Created by Guilherme on 10/06/2018.
 */
import com.example.deivi.boletos.MainActivity;
import com.example.deivi.boletos.R;
import com.example.deivi.boletos.MainActivity;

import dao.BoletoDAO;

public class VerificaBoletoVencido extends BroadcastReceiver {
    MainActivity m = new MainActivity();

    @Override
    public void onReceive(Context context, Intent intent) {
        BoletoDAO b = new BoletoDAO(context);
        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH) + 1;
        int dia = c.get(Calendar.DAY_OF_MONTH);

        String data = dia + "/" + mes + "/" + ano;

        List list = b.listBoletosVirouVencido(data);

        if (!list.isEmpty()) {
            m.notificação();


        }

    }
}
