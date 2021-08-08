package com.tech4me.projetofinal.repository;

import java.util.Optional;

import com.tech4me.projetofinal.model.cliente.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByNome(String nome);
    
}
