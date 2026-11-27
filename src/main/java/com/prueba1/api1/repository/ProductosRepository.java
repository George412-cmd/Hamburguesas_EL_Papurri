package com.prueba1.api1.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba1.api1.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository <Productos, Long> {
    List<Productos> findByNombreContaining(String nombre);

    List<Productos> findByPrecioLessThan(BigDecimal precio);

    Productos findByNombre(String nombre);
/*List<Productos> productos = List.of(
    new Productos("Hamburguesa Sencilla", BigDecimal.valueOf(60.00)),
    new Productos("Hamburguesa Sencilla Combo", BigDecimal.valueOf(90.00)),
    new Productos("Hamburguesa Fit", BigDecimal.valueOf(60.00)),
    new Productos("Hamburguesa Fit Combo", BigDecimal.valueOf(90.00)),
    new Productos("Hamburguesa Hawaiana", BigDecimal.valueOf(95.00)),
    new Productos("Hamburguesa Hawaiana Combo", BigDecimal.valueOf(120.00)),
    new Productos("Hamburguesa Perrona", BigDecimal.valueOf(110.00)),
    new Productos("Hamburguesa Perrona Combo", BigDecimal.valueOf(140.00)),
    new Productos("Hamburguesa Ranchera", BigDecimal.valueOf(115.00)),
    new Productos("Hamburguesa Ranchera Combo", BigDecimal.valueOf(145.00)),
    new Productos("Hamburguesa De Pollo", BigDecimal.valueOf(100.00)),
    new Productos("Hamburguesa De Pollo Combo", BigDecimal.valueOf(130.00)),
    new Productos("Agua Jamaica 500ml", BigDecimal.valueOf(25.00)),
    new Productos("Agua Jamaica Litro", BigDecimal.valueOf(40.00)),
    new Productos("Agua Limón 500ml", BigDecimal.valueOf(20.00)),
    new Productos("Agua Limón Litro", BigDecimal.valueOf(40.00)),
    new Productos("Ppas Orden", BigDecimal.valueOf(60.00)),
    new Productos("Papas Especiales", BigDecimal.valueOf(95.00)),
    new Productos("Papas SuperEspeciales", BigDecimal.valueOf(125.00)),
    new Productos("Papurri Sencilla", BigDecimal.valueOf(100.00)),
    new Productos("Papurri Borracha", BigDecimal.valueOf(95.00))
);

ProductosRepository.saveAll(productos);*/
}
