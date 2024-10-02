package com.example.haibazo_entrancetest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_variations")
public class ProductVariations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @OneToMany(mappedBy="productVariations")
    private Set<ProductVariationOptions> options;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}

