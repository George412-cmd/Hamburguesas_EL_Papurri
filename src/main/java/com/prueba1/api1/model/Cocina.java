package com.prueba1.api1.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cola_espera")
public class Cocina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false)
    private LocalDateTime fechaIngreso;

    protected Cocina() {}

    public Cocina(Pedido pedido) {
        this.pedido = pedido;
        this.fechaIngreso = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }


    

}
