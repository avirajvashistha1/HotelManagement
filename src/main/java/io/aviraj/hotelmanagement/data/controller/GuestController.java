package io.aviraj.hotelmanagement.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aviraj.hotelmanagement.data.entity.Guest;
import io.aviraj.hotelmanagement.data.repository.GuestRepository;

@RestController
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;
	
	@GetMapping("/all")
	public Iterable<Guest> getAllGuests(){
		return this.guestRepository.findAll();
	}
	
}
