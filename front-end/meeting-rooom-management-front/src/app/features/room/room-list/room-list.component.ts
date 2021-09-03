import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Room } from 'src/app/shared/models/room';
import { RoomStoreService } from '../services/room-store.service';
import { RoomService } from '../services/room.service';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css'],
})
export class RoomListComponent implements OnInit {

  room!: Room[];



  constructor(private router: Router,
              private roomStoreService: RoomStoreService) { }

  ngOnInit(): void {
    this.roomStoreService.rooms$.subscribe(room => this.room = room )
  }

  reloadData(): void {
    this.roomStoreService.fetchAll();
  }

  deleteRoom(id: number): void{
    this.roomStoreService.removeRoom(id);
  }

  roomDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }

}

