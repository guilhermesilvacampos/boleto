package model;

import java.sql.Date;

/**
 * Created by deivi on 05/06/2018.
 */

public class Boleto {

    private String nome;
    private double valor;
    private Date dataVencimento;
    private String descricao;
    private Integer boletoId;
    boolean vencido = false;

    public Boleto(){}

    public Boleto(String nome, double valor, Date dataVencimento, String descricao, Integer boletoId, boolean vencido){
        this.nome=nome;
        this.valor=valor;
        this.dataVencimento=dataVencimento;
        this.descricao=descricao;
        this.boletoId=boletoId;
        this.vencido=vencido;
    }

    //possivel método q verifica se esta vencido

    public void verifVencimento(Date data, Integer boletoId){
        /* como eu imagino:

        if(data atual > que data do boleto){
            vencido=true;
        }else return false;

        Assim com alguma lógica implementada esse boleto iria pra tabela de vencidos

        */
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
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getBoletoId(){
        return boletoId;
    }
    public void setBoletoId(){
        this.boletoId=boletoId;
    }
}
