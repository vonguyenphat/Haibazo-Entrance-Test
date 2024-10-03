package com.example.haibazo_entrancetest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String src;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
