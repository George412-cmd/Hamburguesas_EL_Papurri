package com.prueba1.api1.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba1.api1.model.Productos;
import com.prueba1.api1.repository.ProductosRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    public void cargarProductos() {
        
        if(productosRepository.count() == 0) {
      List<Productos> productos = List.of(
    new Productos("Hamburguesa Sencilla", BigDecimal.valueOf(60.00),"HAMBURGUESA"),
    new Productos("Hamburguesa Sencilla Combo", BigDecimal.valueOf(90.00), "COMBO"),
    new Productos("Hamburguesa Fit", BigDecimal.valueOf(60.00),     "HAMBURGUESA"),
    new Productos("Hamburguesa Fit Combo", BigDecimal.valueOf(90.00), "COMBO"),
    new Productos("Hamburguesa Hawaiana", BigDecimal.valueOf(95.00), "HAMBURGUESA"),
    new Productos("Hamburguesa Hawaiana Combo", BigDecimal.valueOf(120.00), "COMBO"),
    new Productos("Hamburguesa Perrona", BigDecimal.valueOf(110.00), "HAMBURGUESA"),
    new Productos("Hamburguesa Perrona Combo", BigDecimal.valueOf(140.00), "COMBO"),
    new Productos("Hamburguesa Ranchera", BigDecimal.valueOf(115.00), "HAMBURGUESA"),
    new Productos("Hamburguesa Ranchera Combo", BigDecimal.valueOf(145.00), "COMBO"),
    new Productos("Hamburguesa De Pollo", BigDecimal.valueOf(100.00), "HAMBURGUESA"),
    new Productos("Hamburguesa De Pollo Combo", BigDecimal.valueOf(130.00), "COMBO"),
    new Productos("Agua Jamaica 500ml", BigDecimal.valueOf(25.00), "BEBIDA"),
    new Productos("Agua Jamaica Litro", BigDecimal.valueOf(40.00), "BEBIDA"),
    new Productos("Agua Limón 500ml", BigDecimal.valueOf(20.00), "BEBIDA"),
    new Productos("Agua Limón Litro", BigDecimal.valueOf(40.00), "BEBIDA"),
    new Productos("Papas Orden", BigDecimal.valueOf(60.00), "Papa_Burrito"),
    new Productos("Papas Especiales", BigDecimal.valueOf(95.00), "Papa_Burrito"),
    new Productos("Papas SuperEspeciales", BigDecimal.valueOf(125.00), "Papa_Burrito"),
    new Productos("Papurri Sencilla", BigDecimal.valueOf(100.00), "Papa_Burrito"),
    new Productos("Papurri Borracha", BigDecimal.valueOf(95.00), "Papa_Burrito")
);
        productosRepository.saveAll(productos);
    }
    
}
public List<Productos> obtenerPorCategoria(String categoria){  

    if(categoria == null || categoria.isBlank()){
        throw new RuntimeException("Categoría inválida");
    }

    return productosRepository.findByCategoria(categoria);
}


public List<Productos> obtenerHamburguesas(String categoria) {
    return productosRepository.findByCategoria("Hamburguesas");

}

public List<Productos> obtenerCombos(String categoria) {
    return productosRepository.findByCategoria("COMBO");

}

public List<Productos> obtenerPapas_Burritos(String categoria) {
    return productosRepository.findByCategoria("Papa_Burrito");

}

public List<Productos> obtenerBebidas(String categoria) {
    return productosRepository.findByCategoria("BEBIDA");
}
