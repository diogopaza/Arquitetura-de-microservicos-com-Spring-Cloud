package com.pedidos.dtos;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public record PedidoDto(String cliente,
                        String descricao,
                        BigDecimal valor) {
}
