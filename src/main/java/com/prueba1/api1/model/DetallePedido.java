package com.prueba1.api1.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity // representa un objeto en la base de datos
@Table(name = "DetallePedido") // nombre de la tabla en la base de datos
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automáticamente el id
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private BigDecimal PrecioUnitario;

    @Column(nullable = false)
    private BigDecimal subtotal; // subtotal sin extras


    //Relación a Pedido y lista productos
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "productos_id", nullable = false)
    private Productos producto;


}

