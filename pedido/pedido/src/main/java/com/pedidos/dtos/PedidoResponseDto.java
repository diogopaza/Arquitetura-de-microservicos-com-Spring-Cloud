package com.pedidos.dtos;

import java.math.BigDecimal;

public record PedidoResponseDto(String cliente,
                                String descricao,
                                BigDecimal valor,
                                String mensagem) {
}
