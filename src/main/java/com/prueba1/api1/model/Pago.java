package com.prueba1.api1.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // representa un objeto en la base de datos
@Table(name = "pago") // nombre de la tabla en la base de datos
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automáticamente el id
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaPago;

    @Enumerated(EnumType.STRING) // guarda el enum como String en la base de datos
    @Column(nullable = false)
    private EstadoPago estadoPago;

    @Column(nullable = false)
    private BigDecimal monto; // cuanto se dio para pagar(total)


    // Getters y setters (o usa @Getter y @Setter de Lombok)

       public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPedido(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }
}

