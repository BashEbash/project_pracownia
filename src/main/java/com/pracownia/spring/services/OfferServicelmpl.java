package com.pracownia.spring.services;

import com.pracownia.spring.entities.Offer;
import com.pracownia.spring.repositories.OfferRepository;
import com.pracownia.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServicelmpl implements OfferService{

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
