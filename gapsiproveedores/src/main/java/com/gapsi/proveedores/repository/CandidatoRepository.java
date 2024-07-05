package com.gapsi.proveedores.repository;

import com.gapsi.proveedores.model.Candidato;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CandidatoRepository extends MongoRepository<Candidato, String>
{
    Optional<Candidato> findByActive(Boolean active);
}
