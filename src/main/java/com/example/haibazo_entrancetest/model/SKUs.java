package com.example.haibazo_entrancetest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skus")
public class SKUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private Double price;
    private String slug;
    @JsonIgnore
    private boolean isDelete;
    private int stock;
    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    @Column(name = "sku_tier_idx", nullable = false, columnDefinition = "json")
    private String skuTierIdx;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
