package com.dio.crud.meetingroom.meetingroommanagement.controller;

import com.dio.crud.meetingroom.meetingroommanagement.DTO.request.RoomDTO;
import com.dio.crud.meetingroom.meetingroommanagement.DTO.response.MessageResponseDTO;
import com.dio.crud.meetingroom.meetingroommanagement.exception.ResourceNotFoundException;
import com.dio.crud.meetingroom.meetingroommanagement.service.RoomService;

import java.util.List;
import javax.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
//@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class RoomController {

  private RoomService roomService;

  @Autowired
  public RoomController(
      RoomService roomService) {
    this.roomService = roomService;
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @GetMapping("/rooms")
  public List<RoomDTO> getAllRooms() {
    return roomService.getAllRooms();
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @GetMapping("/rooms/{roomId}")
  public ResponseEntity<RoomDTO> getRoomById(@PathVariable long roomId) throws ResourceNotFoundException {
      return roomService.findById(roomId);
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @PostMapping("/rooms")
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createRoom(@RequestBody @Valid RoomDTO roomDTO){
    return roomService.createRoom(roomDTO);
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @PutMapping("/rooms/{roomId}")
  public ResponseEntity<MessageResponseDTO> updateRoomById(@PathVariable long roomId ,@RequestBody @Valid RoomDTO roomDTO)
      throws ResourceNotFoundException {
    return roomService.updateRoomById(roomId,roomDTO);
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @DeleteMapping("/rooms/{roomId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteRoom(@PathVariable long roomId) throws ResourceNotFoundException {
    roomService.deleteRoom(roomId);
  }

}

