package com.prueba1.api1.repository;

import com.prueba1.api1.model.EstadoPedido;
import com.prueba1.api1.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    // trae los pedidos de un estado (ej. listo) por paginas, para no cargar todos de golpe.
    Page<Pedido> findByEstadoPedido(EstadoPedido estadoPedido, Pageable pageable);

    // trae todos los pedidos de un cliente segun su telefono, del mas reciente al mas antiguo.
    List<Pedido> findByTelefonoClienteOrderByFechaPedidoDesc(String telefonoCliente);

    // busca pedidos cuyo nombre de cliente contenga el texto dado, sin importar mayusculas.
    List<Pedido> findByNombreClienteContainingIgnoreCase(String nombreCliente);

    // trae los pedidos de un lugar, comparando el nombre exacto sin importar mayusculas.
    List<Pedido> findByNombreLugarIgnoreCase(String nombreLugar);

    // trae los pedidos registrados entre dos fechas (ambas incluidas).
    List<Pedido> findByFechaPedidoBetween(LocalDateTime desde, LocalDateTime hasta);

    // trae los pedidos de un estado que se registraron dentro de un rango de fechas.
    List<Pedido> findByEstadoPedidoAndFechaPedidoBetween(
            EstadoPedido estadoPedido, LocalDateTime desde, LocalDateTime hasta);

    // cuenta cuantos pedidos hay en un estado (ej. cuantos estan en espera).
    long countByEstadoPedido(EstadoPedido estadoPedido);

    

    /* trae los pedidos de un estado, el primero en registrarse sale primero.
     con en espera es la cola de cocina; con listo es la lista de pedidos listos.*/
    List<Pedido> findByEstadoPedidoOrderByFechaPedidoAsc(EstadoPedido estadoPedido);

    // trae los pedidos de varios estados a la vez (ej. en espera y listo), en orden de registro.
    List<Pedido> findByEstadoPedidoInOrderByFechaPedidoAsc(Collection<EstadoPedido> estados);

    

    // pedidos en espera que el chef todavia no ha confirmado, en orden de registro.
    List<Pedido> findByEstadoPedidoAndConfirmadoChefFalseOrderByFechaPedidoAsc(EstadoPedido estadoPedido);

    // pedidos en espera que el cocinero todavia no ha confirmado, en orden de registro.
    List<Pedido> findByEstadoPedidoAndConfirmadoCocineroFalseOrderByFechaPedidoAsc(EstadoPedido estadoPedido);

   

    /* boton del chef: marca confirmadoChef = true, solo si el pedido sigue en espera.
     devuelve 1 si lo actualizo, 0 si el pedido ya no estaba en espera.*/
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Pedido p SET p.confirmadoChef = true " +
           "WHERE p.id = :id AND p.estadoPedido = com.prueba1.api1.model.EstadoPedido.EnEspera")
    int confirmarChef(@Param("id") Long id);

    /* boton del cocinero: marca confirmadoCocinero = true, solo si el pedido sigue en espera.
    devuelve 1 si lo actualizo, 0 si el pedido ya no estaba en espera.*/
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Pedido p SET p.confirmadoCocinero = true " +
           "WHERE p.id = :id AND p.estadoPedido = com.prueba1.api1.model.EstadoPedido.EnEspera")
    int confirmarCocinero(@Param("id") Long id);

    /* pasa el pedido a listo, pero solo si el chef y el cocinero ya confirmaron.
    devuelve 1 si lo paso a listo, 0 si todavia falta una confirmacion (o ya no estaba en espera).*/
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Pedido p SET p.estadoPedido = com.prueba1.api1.model.EstadoPedido.Listo, " +
           "p.fechaListo = :ahora " +
           "WHERE p.id = :id " +
           "AND p.estadoPedido = com.prueba1.api1.model.EstadoPedido.EnEspera " +
           "AND p.confirmadoChef = true AND p.confirmadoCocinero = true")
    int marcarListoSiConfirmados(@Param("id") Long id, @Param("ahora") LocalDateTime ahora);

  

    /* suma el total de los pedidos entregados en un rango de fechas (no cuenta cancelados).
     devuelve null si no hubo ningun pedido en ese rango.*/
    @Query("SELECT SUM(p.total) FROM Pedido p " +
           "WHERE p.estadoPedido = com.prueba1.api1.model.EstadoPedido.Entregado " +
           "AND p.fechaPedido BETWEEN :desde AND :hasta")
    BigDecimal sumarVentasEntregadas(@Param("desde") LocalDateTime desde,
                                     @Param("hasta") LocalDateTime hasta);
}