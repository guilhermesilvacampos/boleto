package com.example.deivi.boletos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dao.BoletoDAO;
import dao.DataBaseHelper;
import model.Boleto;
// Feito por Miguel 08/06/18
public class ListarBoletosAPagar extends AppCompatActivity {
    private Button data;
    private EditText nome;
    private EditText valor;
    private EditText descricao;
    private String data_calendario;
    private ListView listView;
    ImageView imagem;
    Button galeria;
    private BoletoDAO helper = new BoletoDAO (this);
    private int id1,id2;
    private Button btnNovoCadastro;

    ArrayList<Boleto> arrayListBoleto;
    ArrayAdapter<Boleto> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_boletos_apagar);
        nome = findViewById(R.id.nome);
        valor = findViewById(R.id.valor);
        descricao = findViewById(R.id.descricao);
       // data_calendario =  findViewById(R.id.data_calendario);
        listView = findViewById (R.id.Lista_Boletos_Apagar);

        arrayListBoleto = (ArrayList<Boleto>) helper.listBoletos( );
        //helper.close ( );
        if (listView != null) {
            adapter = new ArrayAdapter<Boleto> (this,
                    android.R.layout.simple_list_item_1, arrayListBoleto);
            listView.setAdapter (adapter);
        }


    }


}
