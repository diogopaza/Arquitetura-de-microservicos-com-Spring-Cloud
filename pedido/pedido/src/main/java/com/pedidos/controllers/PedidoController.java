package com.pedidos.controllers;

import com.pedidos.dtos.PedidoRequestDto;
import com.pedidos.dtos.PedidoResponseDto;
import com.pedidos.models.PedidoModel;
import com.pedidos.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> salvarPedido(@RequestBody PedidoRequestDto pedidoDto) {
        try {
            var novoPedido = this.pedidoService.salvarPedido(pedidoDto);
            URI uriNovoPedido = URI.create("/api/pedidos/" + novoPedido.getId());
            PedidoResponseDto pedidoResponseDto = new PedidoResponseDto(
                    pedidoDto.cliente(),
                    pedidoDto.descricao(),
                    pedidoDto.valor(),
                    "Pedido criado com sucesso!!!"
            );
            return ResponseEntity
                    .created(uriNovoPedido)
                    .body(pedidoResponseDto);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarPedidos() {
        try {
            return ResponseEntity.ok().body(this.pedidoService.listarPedidos());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
