package com.tienda_k.service.impl;

import com.tienda_k.dao.ProductoDao;
import com.tienda_k.domain.Producto;
import com.tienda_k.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service    
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var listado = productoDao.findAll();
        
        
        if (activos) {
            listado.removeIf(c -> !c.isActivo());
        }
        
        return listado;
        
    }
    
    @Override
     @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
 
    @Override
     @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
 
    @Override
     @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);    
    
    }
    
    
}
