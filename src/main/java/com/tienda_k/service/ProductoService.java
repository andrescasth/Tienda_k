package com.tienda_k.service;

import com.tienda_k.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    
    //Recupera una ista de registros de la tabla producto
    public List<Producto> getProductos(boolean activos);
    
    
    //Recupera un registro de la tabla producto, buscando
    //e; atributo idProducto
    
    public Producto getProducto(Producto producto);
    
    //elimina un registro de la tabla producto si encuentra un regsityo con el id pasado
    
    public void delete (Producto producto);
    
      //Si el paramentro producto pasado tiene un valor en idProducto lo intenta actualizar, si no tiene valor 
    //se crea el registro
    
    public void save (Producto producto);
}
