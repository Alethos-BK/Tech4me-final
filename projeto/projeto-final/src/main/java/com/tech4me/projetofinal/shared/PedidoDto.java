package com.tech4me.projetofinal.shared;

import java.time.LocalDateTime;
import java.util.List;

import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.model.doce.Doce;

public class PedidoDto {
    
    private Long id;

    private LocalDateTime dataVenda;

    private Cliente cliente;

    private List<Doce> doce;

    private Double valorTotal;

    public PedidoDto() {
    }

    public PedidoDto(LocalDateTime dataVenda, Cliente cliente, List<Doce> doce, Double valorTotal) {
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.doce = doce;
        this.valorTotal = valorTotal;
    }

    public PedidoDto(Long id, LocalDateTime dataVenda, Cliente cliente, List<Doce> doce, Double valorTotal) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.doce = doce;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Doce> getDoce() {
        return doce;
    }

    public void setDoce(List<Doce> doce) {
        this.doce = doce;
    }

    public Double getValorTotal() {
        return valorTotal;
    }   

}
