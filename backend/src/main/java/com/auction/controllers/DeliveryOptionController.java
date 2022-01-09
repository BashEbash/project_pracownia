package com.auction.controllers;

import com.auction.entities.DeliveryOption;
import com.auction.services.DeliveryOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class DeliveryOptionController {

    @Autowired
    private DeliveryOptionService deliveryOptionService;

    @GetMapping(value = "deliveryOption/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryOption getDeliveryOption(@PathVariable Integer id) {
        return deliveryOptionService.findDeliveryOptionById(id);

    }

    @GetMapping(value = "deliveryOptions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<DeliveryOption> getAllDeliveryOptions() {
        return deliveryOptionService.getAllDeliveryOptions();

    }

    @PostMapping(value = "addDeliveryOption", produces = MediaType.APPLICATION_JSON_VALUE)
    public DeliveryOption addDeliveryOption(@RequestParam HashMap<String, String> delivery_option_data) {

        String option_name = delivery_option_data.get("option_name");
        String firm = delivery_option_data.get("firm");
        BigDecimal price = new BigDecimal(delivery_option_data.get("price"));

        DeliveryOption deliveryOption = new DeliveryOption(option_name, firm, price);
        deliveryOptionService.saveDeliveryOption(deliveryOption);

        return deliveryOption;
    }

    @DeleteMapping(value = "deliveryOption/{id}")
    public ResponseEntity deleteDeliveryOption(@PathVariable Integer id) {
        deliveryOptionService.deleteDeliveryOption(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/deliveryOption/edit")
    public ResponseEntity editUser(@RequestBody DeliveryOption deliveryOption) {

        if(deliveryOptionService.findDeliveryOptionById(deliveryOption.getId()) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        deliveryOptionService.saveDeliveryOption(deliveryOption);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
