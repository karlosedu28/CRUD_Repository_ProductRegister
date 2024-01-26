package com.project.CrudRepository.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.CrudRepository.models.ResponseModel;
import com.project.CrudRepository.models.products;
import com.project.CrudRepository.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    // methodo list products
    public Iterable<products> list() {
        return pr.findAll();
    }

    // methodo to create and alter products
    @Autowired
    private ResponseModel rm;

    public ResponseEntity<?> createAlter(products pm, String action) {

        if (pm.getProductname().equals("")) {
            rm.setMensage("Name is no found");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);

        } else if (pm.getBrand().equals("")) {
            rm.setMensage("Brand no entered");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getPrice() == 0) {
            rm.setMensage("Price cannot be 0");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);

        } else {
            if (action.equals("create")) {
                return new ResponseEntity<products>(pr.save(pm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<products>(pr.save(pm), HttpStatus.OK);
            }

        }

    }

    // method remove
    public ResponseEntity<ResponseModel> remover(Long codigo) {

        pr.deleteById(codigo);

        rm.setMensage("Product deleted sucessufly");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);

    }

}
