package com.tech4me.projetofinal.model.doce;

import javax.persistence.Id;

public class Doce {

    @Id
    private Integer id;
    private String nome;
    private String preço;
    private String sabor;
    private String tamanho;
    private Integer quantidade;
    private String estoque;

     //#region Getters e Setters
     public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPreço() {
        return preço;
    }
    public void setPreço(String preço) {
        this.preço = preço;
    }
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getEstoque() {
        return estoque;
    }
    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }
    //#endregion

    public Doce(){}
    
    public Doce(String nome, String preço, String sabor, String tamanho, Integer quantidade, String estoque) {
        this.nome = nome;
        this.preço = preço;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }
    public Doce(Integer id, String nome, String preço, String sabor, String tamanho, Integer quantidade,
            String estoque) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }

  

    

    
    
}
