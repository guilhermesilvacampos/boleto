package adapter;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.deivi.boletos.R;

import java.util.List;

import model.Boleto;

/**
 * Created by miguel on 09/06/2018.
 */

public class BoletoAdapter extends BaseAdapter{

    private Context context;
    private List<Boleto> lista;


    public BoletoAdapter(Context ctx, List<Boleto> boletos){
        this.context = ctx;
        this.lista = boletos;

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
        Boleto boletos = lista.get(position);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.boletos_a_pagar, parent, false);

        }
        TextView txtNome = (TextView) view.findViewById(R.id.boletos_a_pagar_lista);
        txtNome.setText(boletos.getNome());
        TextView txtValor = (TextView) view.findViewById(R.id.boleto_valor);
        txtValor.setText(String.valueOf (boletos.getValor ()));
        TextView txtDataVencimento = (TextView) view.findViewById(R.id.boleto_dataVencimento);
        txtDataVencimento.setText(boletos.getDataVencimento ());
        TextView txtDescricao = (TextView) view.findViewById(R.id.boleto_Descricao);
        txtDescricao.setText(boletos.getDescricao ());







        return view;
    }
}
