package com.auction.repositories;

import com.auction.entities.DeliveryOption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeliveryOptionRepository extends CrudRepository<DeliveryOption, Integer>, PagingAndSortingRepository<DeliveryOption, Integer> {

    @Query(value = "select * from deliveryOption where id = ?1", nativeQuery = true)
    DeliveryOption findDeliveryOptionById(Integer id);

}
