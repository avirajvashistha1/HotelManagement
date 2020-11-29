package io.aviraj.hotelmanagement.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.aviraj.hotelmanagement.data.entity.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{

}
