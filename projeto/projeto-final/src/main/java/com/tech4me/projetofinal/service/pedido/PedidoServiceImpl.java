package com.tech4me.projetofinal.service.pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.projetofinal.exception.NotFoundException;
import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.model.doce.Doce;
import com.tech4me.projetofinal.model.pedido.Pedido;
import com.tech4me.projetofinal.repository.PedidoRepository;
import com.tech4me.projetofinal.service.cliente.ClienteService;
import com.tech4me.projetofinal.service.doce.DoceService;
import com.tech4me.projetofinal.shared.PedidoDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository _pedidoRepository;

    @Autowired
    private ClienteService _clienteService;

    @Autowired
    private DoceService _doceService;

    @Override
    public List<PedidoDto> obterTodos(){

        List<Pedido> pedidos =_pedidoRepository.findAll();
    
        return pedidos.stream().map(pedido -> new ModelMapper().map(pedido, PedidoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPorId(Long id){

        Optional<Pedido> pedido = _pedidoRepository.findById(id);

        if(pedido.isPresent()){
            return pedido;
        }

        throw new NotFoundException("Pedido com o id: " + id + " não encontrado");
    }

    @Override
    public Pedido cadastrarPedido(PedidoDto pedidoDto){

        ModelMapper mapper = new ModelMapper();

        Pedido pedido = mapper.map(pedidoDto, Pedido.class);
        //pedido.obterValorTotal();
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
