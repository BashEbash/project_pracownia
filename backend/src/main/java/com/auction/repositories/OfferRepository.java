package com.auction.repositories;

import com.auction.entities.Offer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;

public interface OfferRepository extends CrudRepository<Offer, Integer>, PagingAndSortingRepository<Offer, Integer> {

    @Query(value = "select * from offer where bidding_id = ?1 and amount = ?2", nativeQuery = true)
    Offer findOfferByBidding_idAndAmount(Integer bidding_id, BigDecimal amount);

    @Query(value = "select * from offer where bidding_id = ?1", nativeQuery = true)
    Iterable<Offer> findAllByBidding_id(Integer bidding_id);


}
