package com.dio.crud.meetingroom.meetingroommanagement.repository;


import com.dio.crud.meetingroom.meetingroommanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

}
