package com.prueba1.api1.repository;

import com.prueba1.api1.model.PedidoPresencial;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoPresencialRepository extends JpaRepository<PedidoPresencial, Long> {
PedidoPresencial findByIdentificadorFisico(String identificadorFisico);
List<PedidoPresencial> findByEstado(String estado);

List<PedidoPresencial> findByTotalGreaterThan(BigDecimal total);

List<PedidoPresencial> findByFechaBetween(
    LocalDateTime inicio,
    LocalDateTime fin
);
List<PedidoPresencial> findByPagoIsNotNull();

List<PedidoPresencial> findByPagoIsNull();
List<PedidoPresencial> findByIdentificadorFisicoContaining(String texto);
}
