package io.aviraj.hotelmanagement.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.aviraj.hotelmanagement.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
