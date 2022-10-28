package com.example.question1.controller;

import com.example.question1.service.AvailabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController {

    private AvailabilityService availabilityService;

    @GetMapping("getAvailability")
    public ResponseEntity<String> getAvailability(@RequestParam(name="productId") String productId) {
        try {
            String response = availabilityService.getAvailabilityByProduct(productId);

            System.out.println(response);

            if (response.equals("No availability")) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
