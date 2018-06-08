package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deivi on 05/06/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "boletos";
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
        db.execSQL("create table boletosPagos(nomeBoleto text not null, valor double not null,"+"" +
                " descricao text, dataPagamento Date, boletoPagoId integer references boletos(boletoId))");


        //tabela boletosVencidos
        db.execSQL("create table boletosVencidos(nomeBoleto text not null, valor double not null, dataVencimento Date,"+"" +
                " descricao text,  boletoVencidoId integer references boletos(boletoId))");


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

                NOME_BOLETO,VALOR,DATA_VENCIMENTO,DESCRICAO
        };

    }

    public static class BoletosPagos{
        public static final String TABELA ="boletos";
        public static final String NOME_BOLETO="nomeBoleto";
        public static final String VALOR = "valor";
        public static final String DESCRICAO="descricao";
        public static final String DATA_PAGAMENTO="dataPagamento";
        public static final String BOLETOID="boletoId";

        public static final String[] COLUNAS = new String[]{

                NOME_BOLETO,VALOR,DESCRICAO,DATA_PAGAMENTO
        };

    }

    public static class BoletosVencidos{
        public static final String TABELA ="boletos";
        public static final String NOME_BOLETO="nomeBoleto";
        public static final String VALOR = "valor";
        public static final String DATA_VENCIMENTO = "dataVencimento";
        public static final String DESCRICAO="descricao";
        public static final String DIAS_VENCIDOS="diasVencidos";
        public static final String BOLETOID="boletoId";

        public static final String[] COLUNAS = new String[]{

                NOME_BOLETO,VALOR,DATA_VENCIMENTO,DESCRICAO,DIAS_VENCIDOS
        };

    }

}
