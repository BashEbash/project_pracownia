package com.pracownia.spring.services;

import com.pracownia.spring.entities.DeliveryOption;
import com.pracownia.spring.repositories.DeliveryOptionRepository;
import com.pracownia.spring.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOptionServicelmpl implements DeliveryOptionService{

    @Autowired
    private DeliveryOptionRepository deliveryOptionRepository;

    @Override
    public DeliveryOption saveDeliveryOption(DeliveryOption deliveryOption) {
        return deliveryOptionRepository.save(deliveryOption);
    }
}
