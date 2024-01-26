package com.project.CrudRepository.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.CrudRepository.models.ResponseModel;
import com.project.CrudRepository.models.products;
import com.project.CrudRepository.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping // ending point using requestmapping as notation
public class ProductController {

    @Autowired
    private ProductService ps;

    @GetMapping("/list")
    public Iterable<products> list() {
        return ps.list();

    }

    @GetMapping("/products")
    public ResponseEntity<String> getAllproduct() {
        return ResponseEntity.ok("Deu certo");

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody products pm) {
        return ps.createAlter(pm, "register");

    }

    @PutMapping("/alter")
    public ResponseEntity<?> alter(@RequestBody products pm) {
        return ps.createAlter(pm, "alter");

    }

    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<ResponseModel> delete(@PathVariable Long codigo) {
        return ps.remover(codigo);

    }

}
