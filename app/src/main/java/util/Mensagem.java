package util;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.Toast;

/**
 * Created by deivi on 19/05/2018.
 */

public class Mensagem {
    public static void msg(Activity activity, String mensagem){
        Toast.makeText(activity,mensagem, Toast.LENGTH_LONG).show();

    }



    public static void addMsgOk(Activity activity, String titulo, String msg, int icone){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setNeutralButton("OK", null);
        alert.setIcon(icone);
        alert.show();

    }

    public  static void MsgConfirm(Activity activity, String titulo, String msg, int icone, DialogInterface.OnClickListener listener){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setPositiveButton("Sim", listener);
        alert.setNegativeButton("Não", null);
        alert.show();
    }

    public static AlertDialog criarAlertDialog (Activity activity){
        final CharSequence[] items={
                "Editar",
                "Excluir",
                "Adicionar aos pagos"
        };
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Opções");
        alert.setItems(items, (DialogInterface.OnClickListener) activity);
        return alert.create();
    }

    public static AlertDialog criarDialogConfirmacao(Activity activity){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setMessage("Deseja realmente excluir?");
        alert.setPositiveButton("Sim", (DialogInterface.OnClickListener) activity);
        alert.setNegativeButton("Não",(DialogInterface.OnClickListener) activity );

        return alert.create();


    }



}
