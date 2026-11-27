package com.prueba1.api1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba1.api1.model.Pago;

@Repository 
public interface PagoRepository extends JpaRepository <Pago, Long> {
}