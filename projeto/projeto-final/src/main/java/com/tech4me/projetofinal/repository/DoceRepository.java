package com.tech4me.projetofinal.repository;

import java.util.Optional;

import com.tech4me.projetofinal.model.doce.Doce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoceRepository extends JpaRepository<Doce, Integer> {
    
    Optional<Doce> findById(Integer id);

    Optional<Doce> findByNome(String nome);
}
