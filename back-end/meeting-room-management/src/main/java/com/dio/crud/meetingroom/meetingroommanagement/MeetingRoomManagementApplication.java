package com.dio.crud.meetingroom.meetingroommanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dio.crud.meetingroom.meetingroommanagement.repository")
public class MeetingRoomManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomManagementApplication.class, args);
	}

}
