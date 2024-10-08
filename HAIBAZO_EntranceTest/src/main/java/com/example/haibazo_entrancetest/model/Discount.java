package com.example.haibazo_entrancetest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private String discountType; //  fixed_amount or percentage
    private Double discountValue; //  10.000 or 10%
    private boolean isActive;
}
