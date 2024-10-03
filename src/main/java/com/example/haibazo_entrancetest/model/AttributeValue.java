package com.example.haibazo_entrancetest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    private Long id;
    private String name;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "attributes_id")
    private Attributes attributes;
}
