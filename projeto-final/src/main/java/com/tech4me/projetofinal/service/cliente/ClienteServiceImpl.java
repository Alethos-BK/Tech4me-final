package com.tech4me.projetofinal.service.cliente;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public List<Cliente> obterTodos(){
        return _clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obterPorId(Long id){
        return _clienteRepository.findById(id);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente){
        cliente.setId(id);
        _clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente cadastrar(Cliente cliente){
        cliente.setId(null);
        _clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente deletar(Long id){
        Optional<Cliente> doce = obterPorId(id);
        if(doce.isEmpty()){
            throw new InputMismatchException("Infelizmente o doce não encontrado.");
        }
        _clienteRepository.deleteById(id);
        return doce.get();
    }
    
}
