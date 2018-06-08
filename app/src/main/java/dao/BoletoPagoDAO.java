package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.BoletoPago;

/**
 * Created by deivi on 08/06/2018.
 */

public class BoletoPagoDAO {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public BoletoPagoDAO(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        // se database for null pega uma nova instancia
        if(database == null){
            database = dataBaseHelper.getWritableDatabase();
        }
        return database;
    }

    private BoletoPago criarBoletoPago(Cursor cursor){
        BoletoPago model = new BoletoPago(



                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosPagos.NOME_BOLETO)),
                cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosPagos.VALOR)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosPagos.DESCRICAO)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosPagos.DATA_PAGAMENTO))


        );

        return model;

    }
    public List<BoletoPago> listBoletosPagos(){

        Cursor cursor = getDatabase().query(DataBaseHelper.BoletosPagos.TABELA,
                DataBaseHelper.BoletosPagos.COLUNAS, null, null, null, null,null);


        List<BoletoPago> boletosPagos = new ArrayList<BoletoPago>();
        while(cursor.moveToNext()){
            BoletoPago model = criarBoletoPago(cursor);
            boletosPagos.add(model);

        }
        cursor.close();

        return boletosPagos;
    }
    public long salvarBoletoPago(BoletoPago boletosPagos){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.BoletosPagos.NOME_BOLETO, boletosPagos.getNome());
        valores.put(DataBaseHelper.BoletosPagos.VALOR, boletosPagos.getValor());
        valores.put(DataBaseHelper.BoletosPagos.DESCRICAO, boletosPagos.getDescricao());
        valores.put(DataBaseHelper.BoletosPagos.DATA_PAGAMENTO, boletosPagos.getDataPagamento());


        if (boletosPagos.getBoletoId() != null){
            return getDatabase().update(DataBaseHelper.BoletosPagos.TABELA,valores,
                    "boletoId = ?", new String[]{boletosPagos.getBoletoId().toString() });
        }

        return getDatabase().insert(DataBaseHelper.BoletosPagos.TABELA, null, valores);
    }

    public boolean removerBoletoPago(int id ){
        return getDatabase().delete(DataBaseHelper.BoletosPagos.TABELA,
                "boletoId = ?" , new String[]{ Integer.toString(id) }) > 0;
    }

    public BoletoPago buscarBoletoPago(int id){
        Cursor cursor = getDatabase().query(DataBaseHelper.BoletosPagos.TABELA,
                DataBaseHelper.BoletosPagos.COLUNAS, "boletoId = ?", new String[]{Integer.toString(id)},null, null,null);

        if (cursor.moveToNext()){
            BoletoPago model = criarBoletoPago(cursor);
            cursor.close();
            return model;

        }
        return null;
    }

    public  void fecharConexao(){
        dataBaseHelper.close();

        database = null;

    }


}
