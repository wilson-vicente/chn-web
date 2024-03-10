package com.examen.CHNExamen.repositories;

import com.examen.CHNExamen.model.PrestamosAprobadosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosAprobadosRepository extends JpaRepository<PrestamosAprobadosModel, Long>{
}
