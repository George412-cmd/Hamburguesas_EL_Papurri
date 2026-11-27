package com.prueba1.api1.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba1.api1.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository <Productos, Long> {
  
     List<Productos> findByCategoria(String categoria);

    List<Productos> findByPrecioLessThan(BigDecimal precio);

}

