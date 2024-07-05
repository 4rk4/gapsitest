package com.gapsi.proveedores.service;

import com.gapsi.proveedores.model.Proveedor;
import com.gapsi.proveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository repository;

    public Optional<Proveedor> getProveedorById(String id){
        return repository.findById(id);
    }

    public Optional<Proveedor> getProveedorByNombre(String nombre){
        return repository.findByNombre(nombre);
    }

    public Optional<Proveedor> getProveedorByRazon(String razon){
        return repository.findByRazon(razon);
    }

    public List<Proveedor> getAllProveedores(){
        return repository.findAll();
    }

    public List<Proveedor> getAllProveedoresByNombreLike(String nombre){
        return repository.findByNombreLike(nombre);
    }

    public boolean saveNewProveedor(Proveedor newProveedor){

        Optional<Proveedor> aux=repository.findByNombre(newProveedor.getNombre());
        if(aux.isEmpty()){
             Proveedor saveProveedor=repository.save(newProveedor);
             return !saveProveedor.get_id().isBlank();
        }else{
           return false;
        }

    }

    public Page<Proveedor> findPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Proveedor> getProveedorList(int page, int size, String sortDir, String sort) {
        PageRequest pageReq
                = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);

        Page<Proveedor> proveedorPage =  repository.findAll(pageReq);
        return proveedorPage.getContent();
    }

    private void deleteProveedor(Proveedor proveedor){
        repository.delete(proveedor);
    }

    public boolean deleteProveedorById(String id){

        Optional<Proveedor> aux=repository.findById(id);
        if(aux.isPresent()){
            this.deleteProveedor(aux.get());
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteProveedorByNombre(String nombre){

        Optional<Proveedor> aux=repository.findByNombre(nombre);
        if(aux.isPresent()){
            this.deleteProveedor(aux.get());
            return true;
        }else{
            return false;
        }

    }

}
