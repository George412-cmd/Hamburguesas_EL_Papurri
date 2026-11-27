package com.prueba1.api1.repository;

import com.prueba1.api1.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {
       List<Pedido> findByConfirmadoChefFalse();
       List<Pedido> findAllByOrderByFechaPedidoDesc();


}