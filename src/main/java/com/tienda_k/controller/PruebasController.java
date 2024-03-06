package com.tienda_k.controller;

import com.tienda_k.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda_k.service.FirebaseStorageService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.tienda_k.domain.Categoria;
import com.tienda_k.service.ProductoService;


import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/pruebas")

public class PruebasController {
    
    @Autowired
    private CategoriaService categoriaService;
    
     @Autowired
    private ProductoService productoService;
    
    @GetMapping("/listado")
    public String listado(Model model){
        
        
        
        
        
        var listado = categoriaService.getCategorias(false);
        
        //pasar info de un java class a interface
        model.addAttribute("categorias",listado);
        
        
        var productos = productoService.getProductos(false);
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos", productos.size());
   
        return "/pruebas/listado";
    }
}       
