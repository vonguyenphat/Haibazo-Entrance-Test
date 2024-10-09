package com.example.haibazo_entrancetest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "attributes")
public class Attributes {
    @Id
    private Long id;
    @OneToMany(mappedBy = "attributes")
    private Set<AttributeValue> attributeValues;
}
