package com.sbn.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> 
{
//    // https://codingexplained.com/coding/java/spring-framework/updating-entities-with-update-query-spring-data-jpa
//    @Modifying
//    @Query("UPDATE Client c "
//            + "SET c.name = :name "
//            + "SET c.lastname = :lastname "
//            + "SET c.address = :address "
//            + "SET c.phone = :phone "
//            + "SET c.email = :email "
//            + "WHERE c.id = :id")
//    int updateClient(
//            @Param("id") Long id, 
//            @Param("name") String name,
//            @Param("lastname") String lastname,
//            @Param("address") String address,
//            @Param("phone") String phone,
//            @Param("email") String email
//    );
    
    @Modifying
    @Query("UPDATE Client c SET c.address = :address WHERE c.id = :companyId")
    int updateAddress(@Param("companyId") Long companyId, @Param("address") String address);
    
    // https://stackoverflow.com/questions/32295688/spring-data-jpa-update-method
    @Modifying
    @Query( "UPDATE Client u "
            + "SET u.firstname = ?1, "
            + "u.lastname = ?2, "
            + "u.address = ?3, "
            + "u.phone = ?4, "
            + "u.email = ?5 "
            + "WHERE u.id = ?6")
    public void update( String firstname, 
                        String lastname,
                        String address, 
                        String phone, 
                        String email, 
                        Long id);
}