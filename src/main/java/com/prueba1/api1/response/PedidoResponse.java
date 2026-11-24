package com.prueba1.api1.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponse {
    private long id;
    private String nombreLugar;
    private String telefonoCliente;
    private String nombreCliente;
    private LocalDateTime fechaPedido;
    private EstadoPedido estadoPedido;
    private BigDecimal total;
    private BigDecimal extras;
    private BigDecimal subtotal;
    private List<DetallePedidoResponse> detallePedidos;

}
