package com.tech4me.projetofinal.service.cliente;

import java.util.InputMismatchException;

import com.tech4me.projetofinal.model.cliente.EnderecoViaCep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class CepService {
    
    @Autowired
    private WebClient _cepWebCliente;

    public EnderecoViaCep obterEndereco(String cep){

        try{
            Mono<EnderecoViaCep> monoEndereco = this._cepWebCliente.method(HttpMethod.GET)
            .uri("http://viacep.com.br/ws/{cep}/json", cep).retrieve().bodyToMono(EnderecoViaCep.class);
        
             EnderecoViaCep endereco = monoEndereco.block();

             return endereco;
        } catch (Exception e){
            throw new InputMismatchException();
        }
    }
}
