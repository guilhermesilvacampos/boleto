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

/**
 * Created by miguel on 09/06/2018.
 */
public class BoletoPagoAdapter extends BaseAdapter{

        private Context context;
        private List<BoletoPago> lista;


        public BoletoPagoAdapter(Context ctx, List<BoletoPago> boletos){
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
            BoletoPago boletos = lista.get(position);

            if (view==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_boletos_pagos, null);

            }

            TextView txtNome = (TextView) view.findViewById(R.id.boletos_pagos_lista);
            txtNome.setText(boletos.getNome());
            return view;
        }
    }


