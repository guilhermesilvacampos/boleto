package com.example.deivi.boletos;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import adapter.BoletoPagoAdapter;
import dao.BoletoPagoDAO;
import model.BoletoPago;
import util.Mensagem;


/**
 * Created by miguel on 09/06/2018.
 */

public class ListarBoletosPagos extends Activity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener {


    private ListView lista;
    private List<BoletoPago> boletoPagoList;
    private BoletoPagoAdapter boletoPagoAdapter;
    private BoletoPagoDAO boletoPagoDAO;

    private int idposicao;

    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletos_pagos);

        alertDialog      = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);

        boletoPagoDAO    = new BoletoPagoDAO(this);
        boletoPagoList    = boletoPagoDAO.listBoletosPagos();
        boletoPagoAdapter= new BoletoPagoAdapter(this, boletoPagoList);

        lista = (ListView) findViewById(R.id.lv_boletos_pagos);
        lista.setAdapter(boletoPagoAdapter);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = boletoPagoList.get(idposicao).getBoletoId();

        switch (which){
            case 0:
                Intent intent = new Intent(this, CadastrarBoleto.class);
                intent.putExtra("FUNC_ID", id);
                startActivity(intent);
                break;
            case 1:
                alertConfirmacao.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                boletoPagoList.remove(idposicao);
                boletoPagoDAO.removerBoletoPago(id);
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
        alertDialog.show();
    }
}
