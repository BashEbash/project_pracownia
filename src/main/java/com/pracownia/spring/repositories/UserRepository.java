package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends CrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

        @Query(value = "select * from user where login = ?1", nativeQuery = true)
        User findUserByLogin(String login);

}
