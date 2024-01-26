package com.project.CrudRepository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.CrudRepository.models.products;

@Repository
public interface ProductRepository extends CrudRepository<products, Long> {

}
