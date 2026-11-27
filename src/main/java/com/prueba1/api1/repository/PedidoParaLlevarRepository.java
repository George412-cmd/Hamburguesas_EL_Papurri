package com.prueba1.api1.repository;

import com.prueba1.api1.model.PedidoParaLlevar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoParaLlevarRepository extends JpaRepository<PedidoParaLlevar, Long> {

}
