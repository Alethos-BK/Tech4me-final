package com.tech4me.projetofinal.service.cliente;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.repository.ClienteRepository;
import com.tech4me.projetofinal.shared.ClienteDto;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public List<ClienteDto> obterTodos(){
        
        List<Cliente> clientes = _clienteRepository.findAll();

        return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto obterPorId(Long id){

        ModelMapper mapper = new ModelMapper();
        Optional<Cliente> cliente = _clienteRepository.findById(id);

        return mapper.map(cliente.get(), ClienteDto.class);
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
    public void deletar(Long id){
        ClienteDto cliente = obterPorId(id);
        
        _clienteRepository.deleteById(id);
    }
    
}
