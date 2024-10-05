package com.example.haibazo_entrancetest.repository;

import com.example.haibazo_entrancetest.dto.ProductFindAllDTO;
import com.example.haibazo_entrancetest.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value ="select p from Product p " +
            "join SKUs sku on sku.product.id = p.id " +
            "where p.isDelete = false and p.isDraft = false and p.isPublished = true and p.id = :id ")
    Optional<Product> findById(@Param("id") Long id);

    @Query(value = "SELECT new ProductFindAllDTO (p.id,p.name,p.thumb,p.slug,p.rating,min(sku.price))  FROM Product p " +
            "JOIN SKUs sku ON sku.product.id = p.id " +
            "JOIN ProductVariations pv ON pv.product.id = p.id " +
            "JOIN ProductVariationOptions pvo ON pvo.productVariations.id = pv.id " +
            "WHERE p.isDelete = false AND p.isDraft = false AND p.isPublished = true " +
            "AND (:category_id IS NULL OR p.category.id = :category_id) " +
            "AND (:attribute_value_id IS NULL OR p.attributeValue.id = :attribute_value_id) " +
            "AND ((:option_1 IS NULL AND :option_2 IS NULL AND :option_3 IS NULL) " +
            "    OR pvo.name IN (:option_1, :option_2, :option_3)) " +
            "GROUP BY p.id " +
            "HAVING ((:option_1 IS NOT NULL AND :option_2 IS NOT NULL AND :option_3 IS NOT NULL AND COUNT(*) = 3) " +
            "       OR (:option_1 IS NOT NULL AND :option_2 IS NOT NULL AND :option_3 IS NULL AND COUNT(*) = 2) " +
            "       OR (:option_1 IS NOT NULL AND :option_2 IS NULL AND :option_3 IS NULL AND COUNT(*) = 1) " +
            "       OR (:option_1 IS NULL AND :option_2 IS NULL AND :option_3 IS NULL))")
    Page<ProductFindAllDTO> findAllProduct(Pageable pageable,
                                           @Param("category_id") Long categoryId,
                                           @Param("attribute_value_id") Long attributeValueId,
                                           @Param("option_1") String option1,
                                           @Param("option_2") String option2,
                                           @Param("option_3") String option3);


    @Modifying
    @Query("update Product  set isPublished = true , isDraft=false where id =:product_id")
    int publishProductById(@Param("product_id") Long id);
}

