package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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


    private BoletoVencido criarBoletoVencido(Cursor cursor){
        BoletoVencido modelVencido = new BoletoVencido(



                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.NOME_BOLETO)),
                        cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.VALOR)),
                        cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO)),
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DESCRICAO))







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
