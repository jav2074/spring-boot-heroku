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
            + "SET c.name = :client.name "
            + "SET c.lastname = :client.lastname "
            + "SET c.address = :client.address "
            + "SET c.phone = :client.phone "
            + "SET c.email = :client.email "
            + "WHERE c.id = :id")
    int updateClient(@Param("id") Long id, @Param("client") Client client);
}