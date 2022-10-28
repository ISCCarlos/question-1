package com.example.question1.service;

import com.example.question1.entity.Availability;
import com.example.question1.entity.Demand;
import com.example.question1.entity.Supply;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {
    public Double getDemandByProduct(String productId) {
        Demand demand = Demand.getDemand().stream()
                .filter(productDemand -> productDemand.getProductId().equals(productId))
                .limit(1)
                .findFirst()
                .orElse(null);

        return demand.getQuantity();
    }

    public Double getSupplyByProduct(String productId) {
        Supply supply = Supply.getSupply().stream()
                .filter(productSupply -> productSupply.getProductId().equals(productId))
                .limit(1)
                .findFirst()
                .orElse(null);

        return supply.getQuantity();
    }

    public Double getAvailabilityBySupplyDemand(Double supply, Double demand) {
        Double availability = supply - demand;

        if (availability.equals(0.0)) {
            availability = 0.0;
        }

        return availability;
    }

    public String getAvailabilityByProduct(String productId) {
        Double demand = getDemandByProduct(productId);
        Double supply = getSupplyByProduct(productId);

        Double availability = getAvailabilityBySupplyDemand(supply, demand);

        if (availability.equals(0.0)) {
            return "No availability";
        } else {
            Availability response = new Availability(productId, availability);
            return response.toString();
        }
    }
}
