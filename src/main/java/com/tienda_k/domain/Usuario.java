package com.tienda_k.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;



@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correp;
    private String telefonno;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn( name = "id_categoria")
    private Categoria categoria;
    
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<Rol> roles;
}
