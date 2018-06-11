package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

import model.Boleto;
import model.BoletoVencido;


/**
 * Created by deivi on 08/06/2018.
 */

public class BoletoDAO {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private Context c;

    public BoletoDAO(Context context){
        c= context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        // se database for null pega uma nova instancia
        if(database == null){
            database = dataBaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Boleto criarBoleto(Cursor cursor){
        Boleto model = new Boleto(



                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Boletos.NOME_BOLETO)),
                cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.Boletos.VALOR)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Boletos.DATA_VENCIMENTO)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Boletos.DESCRICAO)),
                cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Boletos.BOLETOID))


        );
        System.out.println("ESSAAAAAAAAAAAAAAAAAAAAAAAAA Bagaça"+cursor);
        System.out.println("ESSAAAAAAAAAAAAAAAAAAAAAAAAA Bagaça"+model);
        return model;

    }
    public List<Boleto> listBoletos(){

        Cursor cursor = getDatabase().query(DataBaseHelper.Boletos.TABELA,
                DataBaseHelper.Boletos.COLUNAS, null, null, null, null,null);


        List<Boleto> boletos = new ArrayList<Boleto>();
        while(cursor.moveToNext()){
            Boleto model = criarBoleto(cursor);
            boletos.add(model);

            System.out.println("ESSAAAAAAAAAAAAAAAAAAAAAAAAA Bagaça"+model);
        }
        cursor.close();
        System.out.println("ESSAAAAAAAAAAAAAAAAAAAAAAAAA11111111 Bagaça"+boletos);
        return boletos;

    }

    public long salvarBoleto(Boleto boleto){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.Boletos.NOME_BOLETO, boleto.getNome());
        valores.put(DataBaseHelper.Boletos.VALOR, boleto.getValor());
        valores.put(DataBaseHelper.Boletos.DATA_VENCIMENTO, boleto.getDataVencimento());
        valores.put(DataBaseHelper.Boletos.DESCRICAO, boleto.getDescricao());

        if (boleto.getBoletoId() != null){
            return getDatabase().update(DataBaseHelper.Usuarios.TABELA,valores,
                    "boletoId = ?", new String[]{boleto.getBoletoId().toString() });
        }
        Log.i("1","INSERIUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        return getDatabase().insert(DataBaseHelper.Boletos.TABELA, null, valores);

    }

    public boolean removerBoleto(int id ){
        return getDatabase().delete(DataBaseHelper.Boletos.TABELA,
                "boletoId = ?" , new String[]{ Integer.toString(id) }) > 0;
    }



    public Boleto buscarBoleto(int id){
        Cursor cursor = getDatabase().query(DataBaseHelper.Boletos.TABELA,
                DataBaseHelper.Boletos.COLUNAS, "boletoId = ?", new String[]{Integer.toString(id)},null, null,null);

        if (cursor.moveToNext()){
            Boleto model = criarBoleto(cursor);
            cursor.close();
            return model;

        }
        return null;
    }



    public List<Boleto> listBoletosVirouVencido(String data){

        BoletoVencidoDAO b = new BoletoVencidoDAO(c);

        Cursor cursor = getDatabase().query(DataBaseHelper.Boletos.TABELA,
                DataBaseHelper.Boletos.COLUNAS, "dataVencimento =?", null, null, null,null);


        List<Boleto> boletos = new ArrayList<Boleto>();
        while(cursor.moveToNext()){
            Boleto model = criarBoleto(cursor);
            b.salvarBoletoVencido(model);
            boletos.add(model);


        }
        cursor.close();


        return boletos;

    }








    public  void fecharConexao(){
        dataBaseHelper.close();

        database = null;

    }


}
