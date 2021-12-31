package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.DeliveryOption;
import com.pracownia.spring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeliveryOptionRepository extends CrudRepository<DeliveryOption, Integer>, PagingAndSortingRepository<DeliveryOption, Integer> {
}
