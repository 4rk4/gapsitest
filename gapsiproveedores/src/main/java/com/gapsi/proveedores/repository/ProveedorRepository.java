package com.gapsi.proveedores.repository;

import com.gapsi.proveedores.model.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepository extends MongoRepository<Proveedor, String>
{
    public Optional<Proveedor> findByRazon(String razon);

    public Optional<Proveedor> findByNombre(String nombre);

    public List<Proveedor> findByNombreLike(String nombre);
}
