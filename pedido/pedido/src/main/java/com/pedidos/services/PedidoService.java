package com.pedidos.services;

import com.pedidos.dtos.PedidoDto;
import com.pedidos.models.PedidoModel;
import com.pedidos.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    /*public PedidoModel salvarPedido(PedidoDto pedidoDto) {
        PedidoModel pedido = PedidoModel.builder()
                .cliente(pedidoDto.cliente())
                .descricao(pedidoDto.descricao())
                .valor(pedidoDto.valor())
                .build();
        this.pedidoRepository.save(pedido);
        return pedido;
    }*/
}
