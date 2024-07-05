package com.gapsi.proveedores.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("proveedores")
public class Proveedor {

    @Id
    private String _id;
    private String nombre;
    private String razon;
    private String direccion;

}
