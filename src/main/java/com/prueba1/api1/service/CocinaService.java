package com.prueba1.api1.service;

import com.prueba1.api1.model.Cocina;
import com.prueba1.api1.model.Pedido;
import com.prueba1.api1.repository.CocinaRepository;
import com.prueba1.api1.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class CocinaService {
    private final PedidoRepository pedidoRepository;
    private final CocinaRepository cocinaRepository;

    public CocinaService(
            PedidoRepository pedidoRepository,
            CocinaRepository cocinaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.cocinaRepository = cocinaRepository;
    }

    public Cocina guardarEnCola(Pedido pedido) {
        Pedido guardado = pedidoRepository.save(pedido);
        return cocinaRepository.save(new Cocina(guardado));
    }
}