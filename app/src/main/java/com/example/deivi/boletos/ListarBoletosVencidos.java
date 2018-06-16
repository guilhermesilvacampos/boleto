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
import adapter.BoletoVencidoAdapter;
import dao.BoletoPagoDAO;
import dao.BoletoVencidoDAO;
import dao.DataBaseHelper;
import model.BoletoPago;
import model.BoletoVencido;
import util.Mensagem;



public class ListarBoletosVencidos extends Activity implements
        AdapterView.OnItemClickListener, DialogInterface.OnClickListener {


    private ListView lista;
    private List<BoletoVencido> boletoVencidoList;
    private BoletoVencidoAdapter boletoVencidoAdapter;
    private BoletoVencidoDAO boletoVencidoDAO;

    private int idposicao1;

    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1");

        setContentView(R.layout.activity_boletos_vencidos);

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2");
        alertDialog      = Mensagem.criarAlertDialog(this);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa3");
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa4");
        boletoVencidoDAO    = new BoletoVencidoDAO(this);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa5");
        boletoVencidoList    = boletoVencidoDAO.listBoletosVencidos();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa6");
        boletoVencidoAdapter= new BoletoVencidoAdapter(this, boletoVencidoList);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa7");
        lista = (ListView) findViewById(R.id.lv_boletos_vencidos);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa8");
        lista.setAdapter(boletoVencidoAdapter);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa9");
        lista.setOnItemClickListener(this);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa10");
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        boolean k = boletoVencidoList.isEmpty();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAEEEEEEEEEEEEEEEEEEEE"+k + " " + boletoVencidoList.get(idposicao1).getBoleto_id_vencido().toString() +boletoVencidoList.get(idposicao1).getBoleto_id_vencido().toString() );

        int id = boletoVencidoList.get(idposicao1).getBoleto_id_vencido();
System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+id);
        switch (which){
            case 0:
                Bundle bundle = new Bundle ();
                bundle.putInt ("id", id);
                Intent intent = new Intent(this, AlterarBoleto.class);
                intent.putExtras (bundle);
                startActivity(intent);
                break;
            case 1:
                alertConfirmacao.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                boletoVencidoList.remove(idposicao1);
                boletoVencidoDAO.removerBoletoVencido(id);
                System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPDKKKKKKKKKKKKKKKKKKKKKKKKKKK"+id);
                lista.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposicao1 = position;
        Log.i("2","AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIOOOOOOOOOOO"+position);
        alertDialog.show();
    }
}
