package com.tech4me.projetofinal.service.pedido;

import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.pedido.Pedido;
import com.tech4me.projetofinal.shared.PedidoDto;

public interface PedidoService {
    
    List<PedidoDto> obterTodos();
    Optional<Pedido> obterPorId(Long id);
    Pedido cadastrarPedido(PedidoDto pedidoDto);
    Pedido atualizar(Long id, PedidoDto pedidoDto);
    void deletar(Long id);

}
