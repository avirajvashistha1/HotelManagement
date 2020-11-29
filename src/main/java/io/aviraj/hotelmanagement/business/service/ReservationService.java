package io.aviraj.hotelmanagement.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aviraj.hotelmanagement.business.domain.RoomReservation;
import io.aviraj.hotelmanagement.data.entity.Guest;
import io.aviraj.hotelmanagement.data.entity.Reservations;
import io.aviraj.hotelmanagement.data.entity.Room;
import io.aviraj.hotelmanagement.data.repository.GuestRepository;
import io.aviraj.hotelmanagement.data.repository.ReservationRepository;
import io.aviraj.hotelmanagement.data.repository.RoomRepository;

@Service
public class ReservationService {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;	
	
	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}



	public List<RoomReservation> getRoomReservationsForDate(Date date){
//		List<Reservations> reservations = this.reservationRepository.findByReservationDate(new java.sql.Date(date.getTime()));
		List<Reservations> reservations = getDummyList();
		List<RoomReservation> roomReservations = new ArrayList<>();
		reservations.forEach(reservation -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setGuestId(reservation.getGuestId());
			roomReservation.setRoomId(reservation.getRoomId());
			roomReservation.setDate(reservation.getReservationDate());
			Optional<Guest> guestOp = guestRepository.findById(reservation.getGuestId());
			if (guestOp.isPresent()) {
				Guest guest = guestOp.get();
				roomReservation.setFirstName(guest.getFirstName());
				roomReservation.setLastName(guest.getLastName());
			}
			Optional<Room> roomOp = roomRepository.findById(reservation.getRoomId());
			if(roomOp.isPresent()) {
				Room room = roomOp.get();
				roomReservation.setRoomName(room.getRoomName());
				roomReservation.setRoomNumber(room.getRoomNumber());
			}
			roomReservations.add(roomReservation);
		});		
		return roomReservations;
	}
	
	private List<Reservations> getDummyList(){
		List<Reservations> reservations = new ArrayList<>();
		this.reservationRepository.findAll().forEach(r->{
			reservations.add(r);
		});
		return reservations;
	}
}
