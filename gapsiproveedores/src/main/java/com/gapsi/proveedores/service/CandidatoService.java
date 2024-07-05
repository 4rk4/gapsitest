package com.gapsi.proveedores.service;

import com.gapsi.proveedores.model.Candidato;
import com.gapsi.proveedores.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    CandidatoRepository repository;

    public Optional<Candidato> getActiveCandidato(){
        return repository.findByActive(true);
    }


}
