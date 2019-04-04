package com.restowa.domain.repository;

import com.restowa.domain.model.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a WHERE street=:street AND city=:city AND state=:state AND zipcode=:zipcode AND country=:country")
    public List<Address> findAddressByDetails(@Param("street") String street,@Param("city") String city,@Param("state") String state,@Param("zipcode") String zipcode,@Param("country") String country);
}