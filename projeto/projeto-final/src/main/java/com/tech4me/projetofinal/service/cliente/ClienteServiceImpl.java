package com.tech4me.projetofinal.service.cliente;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.projetofinal.exception.NotFoundException;
import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.model.cliente.Endereco;
import com.tech4me.projetofinal.model.cliente.EnderecoViaCep;
import com.tech4me.projetofinal.repository.ClienteRepository;
import com.tech4me.projetofinal.shared.ClienteDto;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository _clienteRepository;

    @Autowired
    private CepService _serviceCep;

    @Override
    public List<ClienteDto> obterTodos(){
        
        List<Cliente> clientes = _clienteRepository.findAll();

        return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> obterPorId(Long id){

        Optional<Cliente> cliente = _clienteRepository.findById(id);

        if(cliente.isPresent()){
            return cliente;
        }

        throw new NotFoundException("Pedido com o id: " + id + " não encontrado");

    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente){
        cliente.setId(id);
        ligarViaCepComEdereco(cliente.getEndereco());
        _clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public Cliente cadastrar(Cliente cliente){
        cliente.setId(null);
        ligarViaCepComEdereco(cliente.getEndereco());
        _clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public void deletar(Long id){
        Optional<Cliente> cliente = obterPorId(id);
        
        _clienteRepository.deleteById(id);
    }

    private void ligarViaCepComEdereco(Endereco endereco){

        EnderecoViaCep enderecoViaCep = _serviceCep.obterEndereco(endereco.getCep());
        endereco.setRua((enderecoViaCep.getLogradouro()));
        endereco.setComplemento((enderecoViaCep.getComplemento()));
        endereco.setBairro(enderecoViaCep.getBairro());
        endereco.setCidade(enderecoViaCep.getLocalidade());
        endereco.setEstado(enderecoViaCep.getUf());
    }
    
}
