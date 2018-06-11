package model;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoVencido extends Boleto {




    public BoletoVencido(String nome_boleto_vencido, double valor_boleto_vencido, double dataVencimento_boleto_vencido, String descricao_boleto_vencido, int boleto_id) {
        this.valor_boleto_vencido = valor_boleto_vencido;
        this.dataVencimento_boleto_vencido = dataVencimento_boleto_vencido;
        this.descricao_boleto_vencido = descricao_boleto_vencido;

        this.boleto_id = boleto_id;
        this.nome_boleto_vencido = nome_boleto_vencido;
    }
    private double valor_boleto_vencido;
    private double dataVencimento_boleto_vencido;
    private String descricao_boleto_vencido;
    private int diasVencidos;
    private int boleto_id;
    private String nome_boleto_vencido;

    public String getNome_boleto_vencido() {
        return nome_boleto_vencido;
    }

    public void setNome_boleto_vencido(String nome_boleto_vencido) {
        this.nome_boleto_vencido = nome_boleto_vencido;
    }

    public double getValor_boleto_vencido() {
        return valor_boleto_vencido;
    }

    public void setValor_boleto_vencido(double valor_boleto_vencido) {
        this.valor_boleto_vencido = valor_boleto_vencido;
    }

    public double getDataVencimento_boleto_vencido() {
        return dataVencimento_boleto_vencido;
    }

    public void setDataVencimento_boleto_vencido(double dataVencimento_boleto_vencido) {
        this.dataVencimento_boleto_vencido = dataVencimento_boleto_vencido;
    }

    public String getDescricao_boleto_vencido() {
        return descricao_boleto_vencido;
    }

    public void setDescricao_boleto_vencido(String descricao_boleto_vencido) {
        this.descricao_boleto_vencido = descricao_boleto_vencido;
    }

    public int getDiasVencidos() {
        return diasVencidos;
    }

    public void setDiasVencidos(int diasVencidos) {
        this.diasVencidos = diasVencidos;
    }



    public int getBoleto_id() {
        return boleto_id;
    }

    public void setBoleto_id(int boleto_id) {
        this.boleto_id = boleto_id;
    }
}

