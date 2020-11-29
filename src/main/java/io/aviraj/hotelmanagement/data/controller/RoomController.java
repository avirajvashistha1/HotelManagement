package io.aviraj.hotelmanagement.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aviraj.hotelmanagement.data.entity.Room;
import io.aviraj.hotelmanagement.data.repository.RoomRepository;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/all")
	public Iterable<Room> getAllRooms(){
		return this.roomRepository.findAll();
	}
}
