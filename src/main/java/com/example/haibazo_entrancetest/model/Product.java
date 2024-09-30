package com.example.haibazo_entrancetest.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String thumb;
    private String description;
    private Double price;
    private String slug;
    private int quantity;
    private float rating;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    private boolean isDraft;
    private boolean isPublished;
    private boolean isDelete;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = false)
    private Date updatedAt;
}
