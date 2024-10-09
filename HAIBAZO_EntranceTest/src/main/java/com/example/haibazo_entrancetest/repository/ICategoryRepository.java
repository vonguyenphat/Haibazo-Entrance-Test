package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {

}
