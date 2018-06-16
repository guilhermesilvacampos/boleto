package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deivi on 05/06/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "BD_Boletos11";
    private static final int VERSAO =1;

    public DataBaseHelper(Context context){
        super(context, BANCO_DADOS,null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tabela de boletos
        db.execSQL("create table boletos(nomeBoleto text not null, valor double not null, dataVencimento Date,"+"" +
                " descricao text, boletoId integer primary key autoincrement)");
        //tabela boletosPagos
        db.execSQL("create table boletosPagos(nomeBoletoPago text not null, valorBoletoPago double not null,"+"" +
                " descricaoBoletoPago text, dataPagamentoBoletoPago Date, boletoIdBoletoPago integer references boletos(boletoId))");


        //tabela boletosVencidos
        db.execSQL("create table boletosVencidos(nomeBoletoVencido text not null, valorBoletoVencido double not null, dataVencimentoBoletoVencido Date,"+"" +
                " descricaoBoletoVencido text,  boletoVencidoId integer references boletos(boletoId))");


        //tabela de usuarios
        db.execSQL("create table usuarios(_id integer primary key autoincrement," +
                " nome text not null, login text not null, senha text not null)");

        //cadastrando um usuario admin
        db.execSQL("insert into usuarios(nome,login,senha) values ('Admin','admin', '123')");

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static class Usuarios{
        public static final String  TABELA = "usuarios";
        public static final String  _ID = "_id";
        public static final String  NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA= "senha";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LOGIN, SENHA
        };
    }


    public static class Boletos{
        public static final String TABELA ="boletos";
        public static final String NOME_BOLETO="nomeBoleto";
        public static final String VALOR = "valor";
        public static final String DATA_VENCIMENTO = "dataVencimento";
        public static final String DESCRICAO="descricao";
        public static final String BOLETOID="boletoId";

        public static final String[] COLUNAS = new String[]{

                NOME_BOLETO,VALOR,DATA_VENCIMENTO,DESCRICAO, BOLETOID
        };

    }

    public static class BoletosPagos{
        public static final String TABELA ="boletosPagos";
        public static final String NOME_BOLETO="nomeBoletoPago";
        public static final String VALOR = "valorBoletoPago";
        public static final String DESCRICAO="descricaoBoletoPago";
        public static final String DATA_PAGAMENTO="dataPagamentoBoletoPago";
        public static final String BOLETOID="boletoIdBoletoPago";

        public static final String[] COLUNAS = new String[]{

                NOME_BOLETO,VALOR,DESCRICAO,DATA_PAGAMENTO, BOLETOID
        };

    }

    public static class BoletosVencidos{
        public static final String TABELA ="boletosVencidos";
        public static final String NOME_BOLETO="nomeBoletoVencido";
        public static final String VALOR = "valorBoletoVencido";
        public static final String DATA_VENCIMENTO = "dataVencimentoBoletoVencido";
        public static final String DESCRICAO="descricaoBoletoVencido";

        public static final String BOLETOID="boletoVencidoId";

        public static final String[] COLUNAS = new String[]{

                NOME_BOLETO,VALOR,DATA_VENCIMENTO,DESCRICAO, BOLETOID
        };

    }

}
