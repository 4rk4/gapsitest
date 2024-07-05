package com.gapsi.proveedores.controller;

import com.gapsi.proveedores.model.Candidato;
import com.gapsi.proveedores.model.Proveedor;
import com.gapsi.proveedores.model.Version;
import com.gapsi.proveedores.service.CandidatoService;
import com.gapsi.proveedores.service.ProveedorService;
import com.gapsi.proveedores.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/gapsi/v1")
public class ProveedoresRestController {

    @Autowired
    ProveedorService service;

    @Autowired
    VersionService versionService;

    @Autowired
    CandidatoService candidatoService;

    @GetMapping("/version")
    public ResponseEntity getVersion() throws Exception {

        Optional<Version> result=versionService.getLastVersion();
        if(result.isPresent()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            Map<String, String> body = new HashMap<>();
            body.put("message", "No se encontro la version");
            return new ResponseEntity<>(body, HttpStatus.OK);
        }

    }

    @GetMapping("/candidato")
    public ResponseEntity getCandidato() throws Exception {

        Optional<Candidato> result=candidatoService.getActiveCandidato();
        if(result.isPresent()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            Map<String, String> body = new HashMap<>();
            body.put("message", "No se encontro el candidato");
            return new ResponseEntity<>(body, HttpStatus.OK);
        }

    }

    @GetMapping("/proveedores")
    public ResponseEntity getAllProveedores() throws Exception {

        List<Proveedor> result=service.getAllProveedores();
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            Map<String, String> body = new HashMap<>();
            body.put("message", "NNo se encontraron proveedores");
            return new ResponseEntity<>(body, HttpStatus.OK);
        }

    }


    @PostMapping("/proveedores/guardar")
    public ResponseEntity getAllProveedores(@RequestBody Proveedor newProveedor) throws Exception {
        Map<String, String> body = new HashMap<>();
        boolean saved=service.saveNewProveedor(newProveedor);
        if(saved){
            body.put("message", "Proveedor guardado con exito");
        }else{
            body.put("message", "El proveedor no se guardo debido a que ya existe otro con el mismo nombre");
        }
        return new ResponseEntity<>(body, HttpStatus.OK);

    }

    @GetMapping("/proveedores/paginated/{page}/{size}/{sortDir}/{sort}")
    @ResponseBody
    public List<Proveedor> getProveedores(
            @PathVariable("page") int page,
            @PathVariable("size") int size,
            @PathVariable("sortDir") String sortDir,
            @PathVariable("sort") String sort) {

        List<Proveedor> proveedorList = service.getProveedorList(page, size, sortDir, sort);
        return proveedorList;
    }


    @DeleteMapping("/proveedores/borrar/{nombre}")
    public ResponseEntity deleteProveedo( @PathVariable("nombre") String nombre) throws Exception {

        Map<String, String> body = new HashMap<>();
        Optional<Proveedor> proveedor=service.getProveedorByNombre(nombre);
;       if(proveedor.isPresent()){
            boolean deleted=service.deleteProveedorByNombre(proveedor.get().getNombre());
            body.put("message",  deleted?"Proveedor eliminado con exito":"Ocurrio un error al eliminar");
        }else{
            body.put("message", "El proveedor que se intenta eliminar no existe");
        }
        return new ResponseEntity<>(body, HttpStatus.OK);

    }
}
