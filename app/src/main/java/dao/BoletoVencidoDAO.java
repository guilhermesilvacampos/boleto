package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Boleto;
import model.BoletoPago;
import model.BoletoVencido;

/**
 * Created by Guilherme on 10/06/2018.
 */

public class BoletoVencidoDAO {



    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public BoletoVencidoDAO(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        // se database for null pega uma nova instancia
        if(database == null){
            database = dataBaseHelper.getWritableDatabase();
        }
        return database;
    }


    public long salvarBoletoVencido(Boleto boletos){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.BoletosVencidos.NOME_BOLETO, boletos.getNome());
        valores.put(DataBaseHelper.BoletosVencidos.VALOR, boletos.getValor());
        valores.put(DataBaseHelper.BoletosVencidos.DESCRICAO, boletos.getDescricao());
        valores.put(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO, boletos.getDataVencimento());


        if (boletos.getBoletoId() != null){
            return getDatabase().update(DataBaseHelper.BoletosVencidos.TABELA,valores,
                    "boletoId = ?", new String[]{boletos.getBoletoId().toString() });
        }

        return getDatabase().insert(DataBaseHelper.BoletosPagos.TABELA, null, valores);
    }






    private BoletoVencido criarBoletoVencido(Cursor cursor){
        BoletoVencido modelVencido = new BoletoVencido(



                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.NOME_BOLETO)),
                        cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.VALOR)),
                        cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO)),
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DESCRICAO)),
                        cursor.getInt(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.BOLETOID))







        );

        return modelVencido;

    }



    public List<BoletoVencido> listBoletosVencidos(){

        Cursor cursor = getDatabase().query(DataBaseHelper.BoletosPagos.TABELA,
                DataBaseHelper.BoletosVencidos.COLUNAS, null, null, null, null,null);


        List<BoletoVencido> boletosVencidos = new ArrayList<BoletoVencido>();
        while(cursor.moveToNext()){
            BoletoVencido modelVencido = criarBoletoVencido(cursor);

            boletosVencidos.add(modelVencido);

        }
        cursor.close();

        return boletosVencidos;
    }




}
