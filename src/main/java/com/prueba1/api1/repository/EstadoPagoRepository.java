package com.prueba1.api1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba1.api1.model.EstadoPago;

@Repository 
public interface EstadoPagoRepository extends JpaRepository <EstadoPago, Long> {
    
}
