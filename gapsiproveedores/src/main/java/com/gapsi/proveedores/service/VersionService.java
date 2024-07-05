package com.gapsi.proveedores.service;

import com.gapsi.proveedores.model.Version;
import com.gapsi.proveedores.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VersionService {

    @Autowired
    VersionRepository repository;

    public Optional<Version> getLastVersion(){
        return repository.findFirstByOrderByVersionDesc();
    }


}
