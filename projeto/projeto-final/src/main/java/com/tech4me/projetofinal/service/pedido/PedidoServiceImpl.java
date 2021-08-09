package com.tech4me.projetofinal.service.pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.projetofinal.model.pedido.Pedido;
import com.tech4me.projetofinal.repository.PedidoRepository;
import com.tech4me.projetofinal.shared.PedidoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository _pedidoRepository;

    @Override
    public List<PedidoDto> obterTodos(){

        List<Pedido> pedidos =_pedidoRepository.findAll();
    
        return pedidos.stream().map(pedido -> new ModelMapper().map(pedido, PedidoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPorId(Long id){

        return _pedidoRepository.findById(id);
    }

    @Override
    public Pedido cadastrarPedido(PedidoDto pedidoDto){

        ModelMapper mapper = new ModelMapper();

        Pedido pedido = mapper.map(pedidoDto, Pedido.class);
        
        return _pedidoRepository.save(pedido);

    }

    @Override
    public Pedido atualizar(Long id, PedidoDto pedidoDto){

        ModelMapper mapper = new ModelMapper();
    
        Pedido pedido = mapper.map(pedidoDto, Pedido.class);

        Optional<Pedido> pedidoAntigo = obterPorId(id);

        pedido.setId(pedidoAntigo.get().getId());

        return _pedidoRepository.save(pedido);

    }

    @Override
    public void deletar(Long id){

        Optional<Pedido> pedido = obterPorId(id);
    
        _pedidoRepository.deleteById(id);
    }
    
}
