package com.gapsi.proveedores.repository;

import com.gapsi.proveedores.model.Version;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VersionRepository extends MongoRepository<Version, String>
{
    Optional<Version> findFirstByOrderByVersionDesc();
}
