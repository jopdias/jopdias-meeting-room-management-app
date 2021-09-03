package com.dio.crud.meetingroom.meetingroommanagement.service;

import com.dio.crud.meetingroom.meetingroommanagement.DTO.request.RoomDTO;
import com.dio.crud.meetingroom.meetingroommanagement.DTO.response.MessageResponseDTO;
import com.dio.crud.meetingroom.meetingroommanagement.exception.ResourceNotFoundException;
import com.dio.crud.meetingroom.meetingroommanagement.mappers.RoomMapper;
import com.dio.crud.meetingroom.meetingroommanagement.model.Room;
import com.dio.crud.meetingroom.meetingroommanagement.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RoomService {

  @Autowired
  public RoomService(
      RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  private RoomRepository roomRepository;

  private final RoomMapper roomMapper = RoomMapper.INSTANCE;


  public List<RoomDTO> getAllRooms() {
    List<Room> allRooms = roomRepository.findAll();
    return allRooms.stream()
        .map(roomMapper::toDTO)
        .collect(Collectors.toList());
  }


  public ResponseEntity<RoomDTO> findById(long roomId) throws ResourceNotFoundException {
    RoomDTO roomDTO = roomMapper.toDTO(verifyIfExists(roomId));
    return ResponseEntity.ok().body(roomDTO);
  }

  public MessageResponseDTO createRoom(RoomDTO roomDTO) {

    Room roomToSave = roomMapper.toModel(roomDTO);
    Room savedRoom = roomRepository.save(roomToSave);

    return createMessageResponse(savedRoom.getId(), "Created Room with ID: ");
  }

  public ResponseEntity<MessageResponseDTO> updateRoomById(long roomId, RoomDTO roomDTO)
      throws ResourceNotFoundException {

    verifyIfExists(roomId);
    Room roomToUpdate = roomMapper.toModel(roomDTO);
    Room updatedRoom = roomRepository.save(roomToUpdate);
    MessageResponseDTO updatedRoomMessage = createMessageResponse(updatedRoom.getId(), "Update Room with Id: ");

    return ResponseEntity.ok().body(updatedRoomMessage);

  }
  public void deleteRoom(long roomId) throws ResourceNotFoundException {
    verifyIfExists(roomId);
    roomRepository.deleteById(roomId);
  }

  public Room verifyIfExists(Long roomId) throws ResourceNotFoundException {
    return roomRepository.findById(roomId)
        .orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
  }

  private MessageResponseDTO createMessageResponse(Long roomId, String message){
    return MessageResponseDTO.builder().message(message+roomId).build();
  }

}

