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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String thumb;
    private String description;
    private String slug;
    private int quantity;
    private float rating;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    private boolean isDraft;
    private boolean isPublished;
    private boolean isDelete;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    @OneToMany(mappedBy="product")
    private Set<ProductVariations> productVariations;
    @OneToMany(mappedBy="product")
    private Set<SKUs> sku_list;
    @OneToMany(mappedBy="product")
    private Set<Images> images;
    @ManyToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;
}
