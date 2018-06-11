package model;

/**
 * Created by deivi on 05/06/2018.
 */

public class BoletoPago  {

    private String nome;
    private double valor;
    private String dataPagamento;
    private String descricao;
    private int boletoId;




    public BoletoPago(String nome, double valor, String dataPagamento, String descricao, int boletoId){
        this.setNome(nome);
        this.setValor(valor);
        this.setDescricao(descricao);
        this.setDataPagamento(dataPagamento);
        this.setBoletoId(boletoId);

    }


    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getBoletoId() {
        return boletoId;
    }

    public void setBoletoId(Integer boletoId) {
        this.boletoId = boletoId;
    }


}
