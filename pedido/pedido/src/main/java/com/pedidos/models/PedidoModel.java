package com.pedidos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class PedidoModel {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    UUID id;

    @Column(name = "cliente")
    String cliente;

    @Column(name = "descricao")
    String descricao;

    /*importante notar o uso do BigDecimal pois estamos trabalhando com valores monetarios
    estamos definindo o total de 19 digitos antes e apos a virgula e 2 casas decimais
    */
    @Column(name = "valor", precision = 19, scale = 2)
    BigDecimal valor;
}
