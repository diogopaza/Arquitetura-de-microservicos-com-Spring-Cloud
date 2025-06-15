package com.pedidos.dtos;

import java.math.BigDecimal;

public record PedidoRequestDto(String cliente,
                               String descricao,
                               BigDecimal valor) {
}
