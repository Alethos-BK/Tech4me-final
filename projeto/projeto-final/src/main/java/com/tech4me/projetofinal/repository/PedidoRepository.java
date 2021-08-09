package com.tech4me.projetofinal.repository;

import java.util.Optional;

import com.tech4me.projetofinal.model.pedido.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
    Optional<Pedido> findById(Long id);


}
