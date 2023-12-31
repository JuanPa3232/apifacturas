package com.api.facturas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.facturas.models.ProductosModel;
import com.api.facturas.repositories.ProductosRepository;

@Service
public class ProductosServices {
    
    @Autowired 
    ProductosRepository prodRepo;

    public ArrayList<ProductosModel> getProductos(){
        return (ArrayList<ProductosModel>) prodRepo.findAll();
        
    }

    public ProductosModel saveProducto(ProductosModel producto){
        return prodRepo.save(producto);
    }

    public Optional<ProductosModel> getById(Long id){
        return prodRepo.findById(id);
    }

    public ProductosModel updateById(ProductosModel request, Long id){
        ProductosModel producto = prodRepo.findById(id).get();
        
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio_unitario(request.getPrecio_unitario());
        producto.setStock(request.getStock());
        producto.setId_categoria(request.getId_categoria());

        return prodRepo.save(producto);
    }


    public Boolean deleteProducto(Long id){
        try {
            prodRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

}