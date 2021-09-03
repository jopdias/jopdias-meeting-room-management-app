package com.dio.crud.meetingroom.meetingroommanagement.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Table(name="meetingroom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="name" ,nullable = false)
  private String name;

  @Column(name="date" ,nullable = false)
  private String date;

  @Column(name="startHour" ,nullable = false)
  private String startHour;

  @Column(name="endHour" ,nullable = false)
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
    Room room = (Room) o;
    return id.equals(room.id) && name.equals(room.name) && date.equals(room.date)
        && startHour.equals(
        room.startHour) && endHour.equals(room.endHour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date, startHour, endHour);
  }
}
