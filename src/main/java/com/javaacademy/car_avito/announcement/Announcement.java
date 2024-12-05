package com.javaacademy.car_avito.announcement;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Announcement {

    private Integer id;
    private String brandName;
    private String color;
    private BigDecimal price;

}
