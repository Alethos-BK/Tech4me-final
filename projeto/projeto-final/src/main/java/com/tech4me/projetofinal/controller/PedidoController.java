package com.tech4me.projetofinal.controller;

import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.pedido.Pedido;
import com.tech4me.projetofinal.service.cliente.ClienteService;
import com.tech4me.projetofinal.service.pedido.PedidoService;
import com.tech4me.projetofinal.shared.PedidoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService _pedidoService;;

    @GetMapping()
    public ResponseEntity<List<PedidoDto>> obterTodos(){
        return new ResponseEntity<>(_pedidoService.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obterPorId(@PathVariable(value ="id") Long id){
        return _pedidoService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody PedidoDto pedido){
        return _pedidoService.atualizar(id, pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody PedidoDto pedido){
        return new ResponseEntity<> (_pedidoService.cadastrarPedido(pedido), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value="id") Long id){
        _pedidoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
