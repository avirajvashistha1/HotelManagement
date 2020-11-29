package io.aviraj.hotelmanagement.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.aviraj.hotelmanagement.business.domain.RoomReservation;
import io.aviraj.hotelmanagement.business.service.ReservationService;
import io.aviraj.hotelmanagement.utils.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {

	private final ReservationService reservationService;

	public RoomReservationWebController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping
	public String getReservations(@RequestParam(value="date", required=false)String dateString, Model model) {
		Date date = DateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		System.out.println("Room Reservations : "+roomReservations);
		return "reservations";
	}
	
}
