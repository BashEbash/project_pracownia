package com.auction.services;

import com.auction.entities.DeliveryOption;

public interface DeliveryOptionService {
    DeliveryOption saveDeliveryOption(DeliveryOption deliveryOption);
    DeliveryOption findDeliveryOptionById(Integer id);
    Iterable<DeliveryOption> getAllDeliveryOptions();
    Iterable<DeliveryOption> AllDeliveryOptionsPaging(Integer pageNr, Integer howManyOnPage);
    void deleteDeliveryOption(Integer id);
}
