package com.gapsi.proveedores.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Candidato {

    @Id
    private String _id;
    private String nombre;
    private Boolean active;

}
