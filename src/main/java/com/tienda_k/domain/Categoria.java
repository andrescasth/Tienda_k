package com.tienda_k.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;



@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

}
