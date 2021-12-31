package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Offer;
import com.pracownia.spring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfferRepository extends CrudRepository<Offer, Integer>, PagingAndSortingRepository<Offer, Integer> {
}
