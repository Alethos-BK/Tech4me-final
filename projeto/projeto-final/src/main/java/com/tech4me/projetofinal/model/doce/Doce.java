package com.tech4me.projetofinal.model.doce;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String preço;
    private String sabor;
    private String tamanho;
    private Integer quantidade;
    private String estoque;


     //#region Getters e Setters
     public Long getId() {
        return id;
    }
    public void setId(Long id) {
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


  

    

    
    
}
