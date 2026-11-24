package com.prueba1.api1.response;

import java.time.LocalDateTime;

public class CocinaResponse {
    private long id;
    private long pedidoid;
    private LocalDateTime fechaIngreso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(long pedidoid) {
        this.pedidoid = pedidoid;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
