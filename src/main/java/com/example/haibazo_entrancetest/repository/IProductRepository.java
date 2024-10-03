package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.isDelete = false and p.isDraft = false and p.isPublished = true and p.id = :id")
    Optional<Product> findById(@Param("id") Long id);

}
