package com.dio.crud.meetingroom.meetingroommanagement.mappers;

import com.dio.crud.meetingroom.meetingroommanagement.DTO.request.RoomDTO;
import com.dio.crud.meetingroom.meetingroommanagement.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {

  RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

  @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
  Room toModel(RoomDTO roomDTO);
  RoomDTO toDTO(Room room);

}
