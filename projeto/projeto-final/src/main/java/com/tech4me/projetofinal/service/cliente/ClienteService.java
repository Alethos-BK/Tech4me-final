package com.tech4me.projetofinal.service.cliente;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.shared.ClienteDto;

public interface ClienteService {
    
    List<ClienteDto> obterTodos();
    Optional<Cliente> obterPorId(Long id);
    Cliente atualizar(Long id, Cliente cliente);
    Cliente cadastrar(Cliente cliente);
    void deletar(Long id);
}
