package com.pracownia.spring.services;

import com.pracownia.spring.repositories.DeliveryOptionRepository;
import com.pracownia.spring.entities.DeliveryOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeliveryOptionServicelmpl implements DeliveryOptionService{

    @Autowired
    private DeliveryOptionRepository deliveryOptionRepository;

    @Override
    public DeliveryOption saveDeliveryOption(DeliveryOption deliveryOption) {
        return deliveryOptionRepository.save(deliveryOption);
    }

    @Override
    public DeliveryOption findDeliveryOptionById(Integer id) {
        return deliveryOptionRepository.findDeliveryOptionById(id);
    }

    @Override
    public Iterable<DeliveryOption> getAllDeliveryOptions() {
        return deliveryOptionRepository.findAll();
    }

    @Override
    public Iterable<DeliveryOption> AllDeliveryOptionsPaging(Integer pageNr, Integer howManyOnPage) {
        return deliveryOptionRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public void deleteDeliveryOption(Integer id) {
        deliveryOptionRepository.deleteById(id);
    }

}
