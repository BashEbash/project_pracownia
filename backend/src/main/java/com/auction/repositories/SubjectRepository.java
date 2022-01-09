package com.auction.repositories;

import com.auction.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer>, PagingAndSortingRepository<Subject, Integer> {

    @Query(value = "select * from subject where number = ?1", nativeQuery = true)
    Subject findSubjectByNumber(Integer number);

    //@Query("select DeliveryOption from DeliveryOption join Subject.deliveryOptions where Subject.number = ?1")
    //List<DeliveryOption> getDeliveryOptionsBySubjectId(Integer number);
}
