package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Subject;
import com.pracownia.spring.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer>, PagingAndSortingRepository<Subject, Integer> {
}
