package com.sbn.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> 
{
    @Modifying
    @Query("UPDATE Client c "
            + "SET c.name = :name "
            + "SET c.lastname = :lastname "
            + "SET c.address = :address "
            + "SET c.phone = :phone "
            + "SET c.email = :email "
            + "WHERE c.id = :id")
    int updateClient(@Param("id") Long id, @Param("Client") Client client);
}