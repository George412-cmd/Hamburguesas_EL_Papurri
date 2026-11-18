package com.prueba1.api1.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    // id autogenerado por la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nombre del lugar del pedido
    @Column(nullable = false)
    private String nombreLugar;

    // telefono del cliente
    @Column(nullable = false)
    private String telefonoCliente;

    // nombre del cliente
    @Column(nullable = false)
    private String nombreCliente;

    // fecha y hora de registro del pedido (se llena con LocalDateTime.now() al crearlo)
    @Column(nullable = false)
    private LocalDateTime fechaPedido;

    // estado actual del pedido (se guarda como texto en la base)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estadoPedido;

    // total sin extras
    @Column(nullable = false)
    private BigDecimal subtotal;

    // dinero extra
    @Column(nullable = false)
    private BigDecimal extras;

    // total con extras
    @Column(nullable = false)
    private BigDecimal total;

    // true cuando el chef ya confirmo el pedido
    @Column(nullable = false)
    private boolean confirmadoChef = false;

    // true cuando el cocinero ya confirmo el pedido
    @Column(nullable = false)
    private boolean confirmadoCocinero = false;

    // hora en que el pedido paso a listo (null mientras no este listo)
    private LocalDateTime fechaListo;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreLugar() { return nombreLugar; }
    public void setNombreLugar(String nombreLugar) { this.nombreLugar = nombreLugar; }

    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDateTime fechaPedido) { this.fechaPedido = fechaPedido; }

    public EstadoPedido getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(EstadoPedido estadoPedido) { this.estadoPedido = estadoPedido; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public BigDecimal getExtras() { return extras; }
    public void setExtras(BigDecimal extras) { this.extras = extras; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public boolean isConfirmadoChef() { return confirmadoChef; }
    public void setConfirmadoChef(boolean confirmadoChef) { this.confirmadoChef = confirmadoChef; }

    public boolean isConfirmadoCocinero() { return confirmadoCocinero; }
    public void setConfirmadoCocinero(boolean confirmadoCocinero) { this.confirmadoCocinero = confirmadoCocinero; }

    public LocalDateTime getFechaListo() { return fechaListo; }
    public void setFechaListo(LocalDateTime fechaListo) { this.fechaListo = fechaListo; }
}