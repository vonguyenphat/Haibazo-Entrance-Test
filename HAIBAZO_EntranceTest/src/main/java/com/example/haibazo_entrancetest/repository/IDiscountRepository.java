package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountRepository extends JpaRepository<Discount,Long> {

}
