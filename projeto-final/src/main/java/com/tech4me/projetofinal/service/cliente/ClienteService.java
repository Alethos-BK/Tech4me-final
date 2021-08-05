package com.tech4me.projetofinal.service.cliente;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.cliente.Cliente;

public interface ClienteService {
    
    List<Cliente> obterTodos();
    Optional<Cliente> obterPorId(Long id);
    Cliente atualizar(Long id, Cliente cliente);
    Cliente cadastrar(Cliente cliente);
    Cliente deletar(Long id);
}
