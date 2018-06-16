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
    Context c;

    public BoletoVencidoDAO(Context context){
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


    public long salvarBoletoVencido(BoletoVencido boletosVencido){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.BoletosVencidos.NOME_BOLETO, boletosVencido.getNome_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.VALOR, boletosVencido.getValor_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.DESCRICAO, boletosVencido.getDescricao_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO, boletosVencido.getDataVencimento_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.BOLETOID,boletosVencido.getBoleto_id_vencido());

System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"+boletosVencido.getBoleto_id_vencido());


        return getDatabase().insert(DataBaseHelper.BoletosVencidos.TABELA, null, valores);
    }

    public long updateBoletoVencido(BoletoVencido boletosVencido){
        ContentValues valores = new ContentValues();
        valores.put(DataBaseHelper.BoletosVencidos.NOME_BOLETO, boletosVencido.getNome_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.VALOR, boletosVencido.getValor_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.DESCRICAO, boletosVencido.getDescricao_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO, boletosVencido.getDataVencimento_boleto_vencido());
        valores.put(DataBaseHelper.BoletosVencidos.BOLETOID,boletosVencido.getBoleto_id_vencido());



            System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+boletosVencido.getBoleto_id_vencido().toString());
            return getDatabase().update(DataBaseHelper.BoletosVencidos.TABELA,valores,
                    "  boletoVencidoId=?", new String[]{boletosVencido.getBoleto_id_vencido().toString() });

    }






    private BoletoVencido criarBoletoVencido(Cursor cursor){
        BoletoVencido modelVencido = new BoletoVencido(



                cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.NOME_BOLETO)),
                        cursor.getDouble(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.VALOR)),
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DATA_VENCIMENTO)),
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.DESCRICAO)),
                        cursor.getInt(cursor.getColumnIndex(DataBaseHelper.BoletosVencidos.BOLETOID))







        );

        return modelVencido;

    }



    public List<BoletoVencido> listBoletosVencidos(){

        Cursor cursor = getDatabase().query(DataBaseHelper.BoletosVencidos.TABELA,
                DataBaseHelper.BoletosVencidos.COLUNAS, null, null, null, null,null);


        List<BoletoVencido> boletosVencidos = new ArrayList<BoletoVencido>();
        while(cursor.moveToNext()){
            BoletoVencido modelVencido = criarBoletoVencido(cursor);
System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV" + modelVencido.getBoleto_id_vencido());
            boletosVencidos.add(modelVencido);

        }
        cursor.close();
        System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV!!!!!!!!!!!");
        return boletosVencidos;
    }

    public boolean removerBoletoVencido(int id ){
System.out.println("oiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+Integer.toString(id));
        return getDatabase().delete(DataBaseHelper.BoletosVencidos.TABELA,
                "boletoVencidoId = ?" , new String[]{ Integer.toString(id) }) > 0;
    }


}
