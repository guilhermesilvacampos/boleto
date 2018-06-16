package com.example.deivi.boletos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Calendar;
import java.util.List;
import adapter.BoletoAdapter;
import dao.BoletoDAO;
import dao.BoletoPagoDAO;
import model.Boleto;
import util.Mensagem;

/**
 * Created by miguel on 09/06/2018.
 */

public class ListarBoletosAPagar extends Activity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener {


    private ListView lista;
    private List<Boleto> boleto_a_pagarList;
    private BoletoAdapter boletoAdapter;
    private BoletoDAO boletoDAO;


private String data;
    private int idposicao;


    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletos_apagar);


        alertDialog      = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);

        boletoDAO    = new BoletoDAO(this);
        boleto_a_pagarList   = boletoDAO.listBoletos();
        boletoAdapter= new BoletoAdapter(this, boleto_a_pagarList);

        lista = (ListView) findViewById(R.id.lv_boletos_a_pagar);
        lista.setAdapter(boletoAdapter);

        lista.setOnItemClickListener(this);

        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH) + 1;
        int dia = c.get(Calendar.DAY_OF_MONTH);

        data = dia + "/" + mes + "/" + ano;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = boleto_a_pagarList.get(idposicao).getBoletoId();

        switch (which){
            case 0:
                Bundle bundle = new Bundle ();
                bundle.putInt ("id", id);
                Intent intent = new Intent(this, AlterarBoleto.class);
                intent.putExtras (bundle);
                startActivity(intent);
                break;
            case 1:
                Log.i ("1","OOOOOOOOOOOOOOOOOOOOOOOUUUUUUUUUUUUUUU");
                alertConfirmacao.show();
                break;

            case DialogInterface.BUTTON_POSITIVE:
                boleto_a_pagarList.remove(idposicao);
                boletoDAO.removerBoleto(id);
                lista.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Log.i ("1","OOOOOOOOOOOOOOOOOOOOOOOUUUUUUUUUUUUUUU1111111111");
                alertConfirmacao.dismiss();
                break;

            case 2:
                Log.i ("1","KKKKKKKKKKKKKKKKKKKKKKKKKKK");

                boletoDAO.insereBoletoPago(id,data);
                boletoDAO.removerBoleto(id);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposicao = position;
        Log.i("2","AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"+position);
        alertDialog.show();

    }
}
