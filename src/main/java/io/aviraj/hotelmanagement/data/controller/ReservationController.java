package io.aviraj.hotelmanagement.data.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aviraj.hotelmanagement.business.domain.RoomReservation;
import io.aviraj.hotelmanagement.business.service.ReservationService;
import io.aviraj.hotelmanagement.data.entity.Reservations;
import io.aviraj.hotelmanagement.data.repository.ReservationRepository;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/all")
	public Iterable<Reservations> getAllReservations(){
		return this.reservationRepository.findAll();
	}
	
	@GetMapping("/bydate")
	public Iterable<RoomReservation> getReservationByDate() {
		List<Date> dateList = new ArrayList<>();
		this.reservationRepository.findAll().forEach(r->dateList.add(r.getReservationDate()));
		List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(new java.sql.Date(dateList.get(0).getTime()));
		return roomReservationList;
	}
	
	
}
