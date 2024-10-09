package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttributeValueRepository extends JpaRepository<AttributeValue,Long> {
}
