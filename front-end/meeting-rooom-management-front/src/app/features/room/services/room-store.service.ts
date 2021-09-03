import { Injectable } from '@angular/core';
import { async, BehaviorSubject } from 'rxjs';
import { uuid } from 'src/app/shared/functions/uuid';
import { Room } from 'src/app/shared/models/room';
import { RoomService } from './room.service';

@Injectable({
  providedIn: 'root'
})
export class RoomStoreService {

constructor(private roomService: RoomService) {
  this.fetchAll()
 }

 private readonly _rooms= new BehaviorSubject<Room[]>([]);

 readonly rooms$ = this._rooms.asObservable();

 get rooms(): Room[] {
   return this._rooms.getValue();
 }

 set rooms(value: Room[]){
  this._rooms.next(value);
 }

 async fetchAll(){
   this.rooms = this.roomService.getRoomsList()
     .subscribe(
       room => this.rooms = [...this._rooms.value, ...room]
     );
 }

 async removeRoom(id: number, serverRemove = true) {
  // optimistic update
  const room = this.rooms.find(t => t.id === id);
  this.rooms = this.rooms.filter(room => room.id !== id);

  if(serverRemove) {
    try {
      this.roomService.deleteRoomById(id);
    } catch (e) {
      console.error(e);
      this.rooms = [...this.rooms, room!];
    }
  }
  }



async addRoom(room: Room) {
      this.roomService.saveRoom(room)
      .subscribe(room=>
        this.rooms =  [room, ...this._rooms.value]
      )
      }
    }











