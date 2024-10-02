package com.example.haibazo_entrancetest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "skus")
public class SKUs {
    @Id
    private String sku;
    private Double price;
    private String slug;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private int stock;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "skus_product_variation_options",
            joinColumns = { @JoinColumn(name = "sku") },
            inverseJoinColumns = { @JoinColumn(name = "option_id") })
    private Set<ProductVariationOptions> options = new HashSet<>();

    public void addOption(ProductVariationOptions option) {
        this.options.add(option);
        option.getSkus().add(this);
    }

    public void removeOption(long option_id) {
        ProductVariationOptions option = this.options.stream().filter(o -> o.getId() == option_id).findFirst().orElse(null);
        if (option != null) {
            this.options.remove(option);
            option.getSkus().remove(this);
        }
    }
}
