package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.deivi.boletos.R;
import java.util.List;

import model.BoletoPago;
import model.BoletoVencido;

/**
 * Created by miguel on 09/06/2018.
 */
public class BoletoVencidoAdapter extends BaseAdapter{

    private Context context;
    private List<BoletoVencido> lista;


    public BoletoVencidoAdapter(Context ctx, List<BoletoVencido> boletosVencido){
        this.context = ctx;
        this.lista = boletosVencido;

    }
    @Override
    public int getCount() {
        return  lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        BoletoVencido boletosVencido = lista.get(position);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.boletos_vencidos, parent,false);

        }

        TextView txtNomeVencido = (TextView) view.findViewById(R.id.boletos_a_pagar_lista_Vencido);
        System.out.println(boletosVencido.getNome_boleto_vencido()+"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        txtNomeVencido.setText(boletosVencido.getNome_boleto_vencido());
        TextView txtValorVencido = (TextView) view.findViewById(R.id.boleto_valor_Vencido);
        txtValorVencido.setText(String.valueOf (boletosVencido.getValor_boleto_vencido ()));
        TextView txtDataVencimentoVencido = (TextView) view.findViewById(R.id.boleto_dataVencimento_Vencido);
        txtDataVencimentoVencido.setText(boletosVencido.getDataVencimento_boleto_vencido());
        TextView txtDescricaoVencido = (TextView) view.findViewById(R.id.boleto_Descricao_Vencido);
        txtDescricaoVencido.setText(boletosVencido.getDescricao_boleto_vencido ());
        return view;
    }
}


