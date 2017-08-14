package com.sbn.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> 
{
    // https://codingexplained.com/coding/java/spring-framework/updating-entities-with-update-query-spring-data-jpa
    @Modifying
    @Query("UPDATE Client c "
            + "SET c.name = :name "
            + "SET c.lastname = :lastname "
            + "SET c.address = :address "
            + "SET c.phone = :phone "
            + "SET c.email = :email "
            + "WHERE c.id = :id")
    int updateClient(
            @Param("id") Long id, 
            @Param("name") String name,
            @Param("lastname") String lastname,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("email") String email
    );
}