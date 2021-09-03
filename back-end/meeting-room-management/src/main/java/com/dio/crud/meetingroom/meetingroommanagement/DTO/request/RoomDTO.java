package com.dio.crud.meetingroom.meetingroommanagement.DTO.request;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

  private Long id;

  @NotEmpty
  private String name;

  @NotEmpty
  private String date;

  @NotEmpty
  private String startHour;

  @NotEmpty
  private String endHour;

  @Override
  public String toString() {
    return "Room{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", date='" + date + '\'' +
        ", startHour='" + startHour + '\'' +
        ", endHour='" + endHour + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoomDTO room = (RoomDTO) o;
    return id.equals(room.id) && name.equals(room.name) && date.equals(room.date)
        && startHour.equals(
        room.startHour) && endHour.equals(room.endHour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date, startHour, endHour);
  }
}
