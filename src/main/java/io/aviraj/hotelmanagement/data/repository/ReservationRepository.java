package io.aviraj.hotelmanagement.data.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.aviraj.hotelmanagement.data.entity.Reservations;

@Repository
public interface ReservationRepository extends CrudRepository<Reservations, Long>{
	public List<Reservations> findByReservationDate(Date date); 
}
