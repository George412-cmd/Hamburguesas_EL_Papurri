package com.prueba1.api1.repository;

import com.prueba1.api1.model.EstadoPedido;
import com.prueba1.api1.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(EstadoPedido estado);
}