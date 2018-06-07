package model;

import java.sql.Date;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoPago extends Boleto {


    private Date dataPagamento;



    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
