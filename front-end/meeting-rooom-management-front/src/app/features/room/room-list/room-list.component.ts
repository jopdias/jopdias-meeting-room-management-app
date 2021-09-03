import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Room } from 'src/app/shared/models/room';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {

  rooms!: Room[];

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
    this.roomService.room$.subscribe(room => this.rooms = room )
  }

  reloadData(): void {
    this.roomService.getRoomList();
  }

  deleteRoom(id: number): void{
    this.roomService.deleteRoomById(id).subscribe(
      data => {
        console.log(data);
        this.reloadData;
      },
      error => console.log(error));
  }


  roomDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }

}
