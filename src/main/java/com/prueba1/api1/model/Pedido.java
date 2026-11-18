package com.prueba1.api1.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // representa un objeto en la base de datos
@Table(name = "Pedidos") // nombre de la tabla en la base de datos
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automáticamente el id
    private Long id;

    @Column(nullable = false)
    private String nombreLugar;

    @Column(nullable = false)
    private String telefonoCliente;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private LocalDateTime fechaPedido;

    @Enumerated(EnumType.STRING) // guarda el enum como String en la base de datos
    @Column(nullable = false)
    private EstadoPedido estadoPedido;

    @Column(nullable = false)
    private BigDecimal subtotal; // total sin extras

    @Column(nullable = false)
    private BigDecimal extras; // dinero extra

    @Column(nullable = false)
    private BigDecimal total; // total con extras

    // Getters y setters (o usa @Getter y @Setter de Lombok)

       public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}