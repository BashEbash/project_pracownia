package com.pracownia.spring.services;

import com.pracownia.spring.entities.DeliveryOption;

import java.util.Set;

public interface DeliveryOptionService {
    DeliveryOption saveDeliveryOption(DeliveryOption deliveryOption);
    DeliveryOption findDeliveryOptionById(Integer id);
    Iterable<DeliveryOption> getAllDeliveryOptions();
    Iterable<DeliveryOption> AllDeliveryOptionsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteDeliveryOption(Integer id);
}
