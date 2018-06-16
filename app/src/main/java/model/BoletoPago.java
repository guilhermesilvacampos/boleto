package model;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoPago  {

    private String nomeBoletoPago;
    private double valorBoletoPago;
    private String dataPagamentoBoletoPago;
    private String descricaoBoletoPago;
    private int boletoIdBoletoPago;

public BoletoPago(){

    }


    public BoletoPago(String nome, double valor, String dataPagamento, String descricao, int boletoId){
        this.nomeBoletoPago=nome;
        this.valorBoletoPago=valor;
        this.dataPagamentoBoletoPago=dataPagamento;
        this.descricaoBoletoPago=descricao;
        this.boletoIdBoletoPago=boletoId;

    }


    public String getDataPagamentoBoletoPago() {
        return dataPagamentoBoletoPago;
    }

    public void setDataPagamentoBoletoPago(String dataPagamento) {
        this.dataPagamentoBoletoPago = dataPagamento;
    }

    public String getNomeBoletoPago() {
        return nomeBoletoPago;
    }

    public void setNomeBoletoPago(String nome) {
        this.nomeBoletoPago = nome;
    }

    public double getValorBoletoPago() {
        return valorBoletoPago;
    }

    public void setValorBoletoPago(double valor) {
        this.valorBoletoPago = valor;
    }


    public String getDescricaoBoletoPago() {
        return descricaoBoletoPago;
    }

    public void setDescricaoBoletoPago(String descricao) {
        this.descricaoBoletoPago = descricao;
    }

    public Integer getBoletoIdBoletoPago() {
        return boletoIdBoletoPago;
    }

    public void setBoletoIdBoletoPago(Integer boletoId) {
        this.boletoIdBoletoPago = boletoId;
    }


}
