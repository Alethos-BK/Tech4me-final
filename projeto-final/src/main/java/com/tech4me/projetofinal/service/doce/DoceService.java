package com.tech4me.projetofinal.service.doce;

import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.doce.Doce;

public interface DoceService {
    List<Doce> obterTodos();
    Optional<Doce> obterPorId(Integer id);
    Doce atualizar(Integer id, Doce Doce);
    Doce cadastrar(Doce Doce);
    Doce deletar(Integer id);
   
}
