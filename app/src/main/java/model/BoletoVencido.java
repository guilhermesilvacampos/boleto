package model;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoVencido extends Boleto {

    private int diasVencidos;


    public int getDiasVencidos() {
        return diasVencidos;
    }

    public void setDiasVencidos(int diasVencidos) {
        this.diasVencidos = diasVencidos;
    }
}
