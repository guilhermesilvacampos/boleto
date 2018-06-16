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
import model.BoletoPago;
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
            return getDatabase().update(DataBaseHelper.Boletos.TABELA,valores,
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





    public List<BoletoVencido> listBoletosVirouVencido(String data){

        BoletoVencidoDAO b = new BoletoVencidoDAO(c);

Log.i("EIIIIIIIIIII","DATAAAAAAAAAAAAAAAAA"+new String[]{(data)});
        Cursor cursor = getDatabase().query(DataBaseHelper.Boletos.TABELA,
                DataBaseHelper.Boletos.COLUNAS, "dataVencimento <=?",new String[]{(data)}, null, null,null);

        List<BoletoVencido> boletosVencidos = new ArrayList<BoletoVencido>();


        while(cursor.moveToNext()){
            Boleto model = criarBoleto(cursor);

           BoletoVencido vencido = new BoletoVencido();

            vencido.setBoleto_id_vencido(model.getBoletoId());
            vencido.setDataVencimento_boleto_vencido(model.getDataVencimento());
            vencido.setDescricao_boleto_vencido(model.getDescricao());
            vencido.setNome_boleto_vencido(model.getNome());
            vencido.setValor_boleto_vencido(model.getValor());

            System.out.println(model.getBoletoId());
            System.out.println(model.getDataVencimento());
            System.out.println(model.getDescricao());
            System.out.println(model.getNome());
            System.out.println(model.getValor());

            System.out.println("VENCIDOOOOOOOOOOOOOOOOODDDDDD"+vencido.getBoleto_id_vencido());

           // if (vencido.getDataVencimento_boleto_vencido()!=data) {
                b.salvarBoletoVencido(vencido);

            boletosVencidos.add(vencido);
                removerBoleto(model.getBoletoId());
           // }
           // boletos.add(model);


        }
        cursor.close();
boolean i = boletosVencidos.isEmpty();
        Log.i("EIIIIIIIIIII","DATAAAAAAAAAAAAAAAAA"+boletosVencidos.toString()+"-------------"+i);
        return boletosVencidos;

    }

    public void insereBoletoPago(int id,String data){
        Cursor cursor = getDatabase().query(DataBaseHelper.Boletos.TABELA,
                DataBaseHelper.Boletos.COLUNAS, "boletoId = ?", new String[]{Integer.toString(id)},null, null,null);

        if (cursor.moveToNext()){
            Boleto model = criarBoleto(cursor);
            cursor.close();
            BoletoPago pago = new BoletoPago();
            pago.setNomeBoletoPago(model.getNome());
            pago.setValorBoletoPago(model.getValor());
            pago.setDescricaoBoletoPago(model.getDescricao());
            pago.setDataPagamentoBoletoPago(data);
            pago.setBoletoIdBoletoPago(model.getBoletoId());

            BoletoPagoDAO boletoPagoDAO = new BoletoPagoDAO(c);
            boletoPagoDAO.salvarBoletoPago(pago);


        }


    }







    public  void fecharConexao(){
        dataBaseHelper.close();

        database = null;

    }


}
