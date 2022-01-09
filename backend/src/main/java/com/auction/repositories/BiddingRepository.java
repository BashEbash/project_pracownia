package com.auction.repositories;

import com.auction.entities.Bidding;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BiddingRepository extends CrudRepository<Bidding, Integer>, PagingAndSortingRepository<Bidding, Integer> {

    @Query(value = "select * from bidding where id = ?1", nativeQuery = true)
    Bidding findBiddingById(Integer id);

}
