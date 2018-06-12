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
import java.util.List;
import adapter.BoletoAdapter;
import dao.BoletoDAO;
import model.Boleto;
import util.Mensagem;

/**
 * Created by miguel on 09/06/2018.
 */

public class ListarBoletosAPagar extends Activity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener {


    private ListView lista;
    private List<Boleto> boletoList;
    private BoletoAdapter boletoAdapter;
    private BoletoDAO boletoDAO;

    private int idposicao;


    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletos_apagar);

        alertDialog      = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);

        boletoDAO    = new BoletoDAO(this);
        boletoList    = boletoDAO.listBoletos();
        boletoAdapter= new BoletoAdapter(this, boletoList);

        lista = (ListView) findViewById(R.id.lv_boletos);
        lista.setAdapter(boletoAdapter);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
Log.i("4","OUUUUUUUUUUUUUUUUUUUUUUUUUUU"+idposicao);

        int id = boletoList.get(idposicao).getBoletoId();

        Log.i("3","EIIIIIIIIIIIIIIIIIIIIIIIII"+id);

        switch (which){
            case 0:
                Intent intent = new Intent(this, CadastrarBoleto.class);
                intent.putExtra("boletoId", id);
                startActivity(intent);
                break;
            case 1:
                alertConfirmacao.show();
                break;
           
            case DialogInterface.BUTTON_POSITIVE:
                boletoList.remove(idposicao);
                boletoDAO.removerBoleto(id);
                lista.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
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
