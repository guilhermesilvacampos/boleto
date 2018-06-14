package model;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoVencido extends Boleto {

public BoletoVencido(){

}


    public BoletoVencido(String nome_boleto_vencido, double valor_boleto_vencido, String dataVencimento_boleto_vencido, String descricao_boleto_vencido, Integer boleto_id_vencido) {
        this.nome_boleto_vencido = nome_boleto_vencido;
        this.valor_boleto_vencido = valor_boleto_vencido;
        this.dataVencimento_boleto_vencido=dataVencimento_boleto_vencido;
        this.descricao_boleto_vencido = descricao_boleto_vencido;
        this.boleto_id_vencido = boleto_id_vencido;
    }

    private double valor_boleto_vencido;

    public double getValor_boleto_vencido() {
        return valor_boleto_vencido;
    }

    public void setValor_boleto_vencido(double valor_boleto_vencido) {
        this.valor_boleto_vencido = valor_boleto_vencido;
    }

    public String getDataVencimento_boleto_vencido() {
        return dataVencimento_boleto_vencido;
    }

    public void setDataVencimento_boleto_vencido(String dataVencimento_boleto_vencido) {
        this.dataVencimento_boleto_vencido = dataVencimento_boleto_vencido;
    }

    public String getDescricao_boleto_vencido() {
        return descricao_boleto_vencido;
    }

    public void setDescricao_boleto_vencido(String descricao_boleto_vencido) {
        this.descricao_boleto_vencido = descricao_boleto_vencido;
    }

    public Integer getBoleto_id_vencido() {
        return boleto_id_vencido;
    }

    public void setBoleto_id_vencido(Integer boleto_id_vencido) {
        this.boleto_id_vencido = boleto_id_vencido;
    }

    public String getNome_boleto_vencido() {
        return nome_boleto_vencido;
    }

    public void setNome_boleto_vencido(String nome_boleto_vencido) {
        this.nome_boleto_vencido = nome_boleto_vencido;
    }

    private String dataVencimento_boleto_vencido;
    private String descricao_boleto_vencido;
    //private int diasVencidos;
    private Integer boleto_id_vencido;
    private String nome_boleto_vencido;


}

