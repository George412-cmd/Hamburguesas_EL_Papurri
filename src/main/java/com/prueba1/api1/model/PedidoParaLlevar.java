package com.prueba1.api1.model;

import java.util.List;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity // representa un objeto en la base de datos
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // se agregara como columna lo que se hereda
public class PedidoParaLlevar extends Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automáticamente el id
    private Long id;


    @Column(nullable = false)
    private String telefonoCliente;

    @Column(nullable = false)
    private LocalDateTime horaEntrega;
   
    //Relación a Pago
    @OneToOne //Solo un pedido puede tener un pago
    @JoinColumn(name = "pago_id") // nombre de la columna en la tabla Pedido que hace referencia a Pago
    private Pago pago;


    //Relación a Detalle Pedido para poner la lista

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();


    // Getters y setters para las relaciones
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }


    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }


    //Get y set de telefono :p

    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}
