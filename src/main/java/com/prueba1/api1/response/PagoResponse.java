package com.prueba1.api1.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.prueba1.api1.model.EstadoPago;

public class PagoResponse {
    private long id;
    private LocalDateTime fechaPago;
    private EstadoPago estadoPago;
    private BigDecimal monto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
