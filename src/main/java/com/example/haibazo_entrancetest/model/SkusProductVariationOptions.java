package com.example.haibazo_entrancetest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skus_product_variation_options")
public class SkusProductVariationOptions {
    @Id
    @ManyToOne
    @JoinColumn(name = "sku_id")
    private SKUs skUs;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_variation_id")
    private ProductVariations productVariations;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_variation_options_id")
    private ProductVariationOptions productVariationOptions;
}
