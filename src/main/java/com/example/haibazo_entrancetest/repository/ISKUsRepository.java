package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.SKUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISKUsRepository extends JpaRepository<SKUs,Long> {
}
