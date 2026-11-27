package com.prueba1.api1.repository;

import com.prueba1.api1.model.Cocina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface CocinaRepository extends JpaRepository<Cocina, Long> {
    List<Cocina> findAllByOrderByFechaIngresoAsc();
}
