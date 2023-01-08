package com.example.question1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Demand {
    private String productId;
    private Double quantity;

    public static List<Demand> getDemand() {
        Demand demand1 = Demand.builder().productId("Product1").quantity(2.0).build();

        Demand demand2 = Demand.builder().productId("Product2").quantity(5.0).build();

        List<Demand> list = new ArrayList<>();
        list.add(demand1);
        list.add(demand2);

        return list;
    }
}
