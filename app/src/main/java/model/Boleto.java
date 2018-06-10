package model;

import java.sql.Date;

/**
 * Created by deivi on 05/06/2018.
 */

public class Boleto {

    private String nome;
    private double valor;
    private String dataVencimento;
    private String descricao;
    private Integer boletoId;
   private boolean vencido = false;


    public Boleto(){}

    public Boleto(String nome, double valor, String dataVencimento, String descricao){
        this.nome=nome;
        this.valor=valor;
        this.dataVencimento=dataVencimento;
        this.descricao=descricao;

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
    public String getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(String dataVencimento) {
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
