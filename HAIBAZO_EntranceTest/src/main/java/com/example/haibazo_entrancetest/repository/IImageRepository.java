package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IImageRepository extends JpaRepository<Images,Long> {
}
