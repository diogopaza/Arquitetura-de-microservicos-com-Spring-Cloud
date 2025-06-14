package com.pedidos.controllers;

import com.pedidos.dtos.PedidoDto;
import com.pedidos.models.PedidoModel;
import com.pedidos.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

   /* public ResponseEntity<PedidoModel> salvarProduto(PedidoDto pedidoDto) {
        try {
            return ResponseEntity.ok().body(this.pedidoService.salvarPedido(pedidoDto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }*/
}
