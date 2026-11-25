package com.prueba1.api1.request;

import java.math.BigDecimal;

public class PagoRequest {
    private BigDecimal monto;

    public BigDecimal getMonto(){
        return monto;
    }

    public void setMonto(BigDecimal monto){
        this.monto = monto;
    }
}
