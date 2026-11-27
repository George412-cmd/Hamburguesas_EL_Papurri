package com.prueba1.api1.request;

import java.math.BigDecimal;

public class DetallePedidoRequest {
    private long productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    public long getProductoId() {
        return productoId;
    }
    
public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}
