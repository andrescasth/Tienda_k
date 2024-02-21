package com.tienda_k.service.impl;

import com.tienda_k.dao.CategoriaDao;
import com.tienda_k.domain.Categoria;
import com.tienda_k.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service    
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var listado = categoriaDao.findAll();
        
        if (activos) {
            listado.removeIf(c -> !c.isActivo());
        }
        
        return listado;
        
    }
    
    @Override
     @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria) {
       return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
 
    @Override
     @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
 
    @Override
     @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);    }
    
    
}
