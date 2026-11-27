package com.prueba1.api1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba1.api1.model.EstadoPedido;
@Repository
public interface EstadoPedidoRepository extends JpaRepository <EstadoPedido, Long> {
    
}
