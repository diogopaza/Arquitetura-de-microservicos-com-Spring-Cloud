package com.pedidos.services;

import com.pedidos.dtos.PedidoRequestDto;
import com.pedidos.models.PedidoModel;
import com.pedidos.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoModel salvarPedido(PedidoRequestDto pedidoDto) {
        PedidoModel pedido = PedidoModel.builder()
                .cliente(pedidoDto.cliente())
                .descricao(pedidoDto.descricao())
                .valor(pedidoDto.valor())
                .build();
        this.pedidoRepository.save(pedido);
        return pedido;
    }

    public List<PedidoModel> listarPedidos() {
        return this.pedidoRepository.findAll();
    }
}
