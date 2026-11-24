package com.prueba1.api1.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoParaLlevarRequest {
    private String nombreLugar;
    private String telefonoCliente;
    private String nombreCliente;
    private BigDecimal extras;
    private LocalDateTime horaEntrega;
    private List<DetallePedidoRequest> detalles;

    public String getNombreLugar() {
        return nombreLugar;
    }   

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public BigDecimal getExtras() {
        return extras;
    }

    public void setExtras(BigDecimal extras) {
        this.extras = extras;
    }

    public LocalDateTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalDateTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public List<DetallePedidoRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoRequest> detalles) {
        this.detalles = detalles;
    }
}
