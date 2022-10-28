package com.example.question1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Supply {
    private String productId;
    private Double quantity;

    public static List<Supply> getSupply() {
        Supply supply1 = Supply.builder().productId("Product1").quantity(10.0).build();

        Supply supply2 = Supply.builder().productId("Product2").quantity(5.0).build();

        List<Supply> list = new ArrayList<>();
        list.add(supply1);
        list.add(supply2);

        return list;
    }
}
