package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Bidding;
import com.pracownia.spring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BiddingRepository extends CrudRepository<Bidding, Integer>, PagingAndSortingRepository<Bidding, Integer> {

}
