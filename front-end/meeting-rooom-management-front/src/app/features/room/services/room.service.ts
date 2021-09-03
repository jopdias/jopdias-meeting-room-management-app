import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Room } from 'src/app/shared/models/room';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

private baseUrl = 'http://localhost:8080/api/v1/rooms'

constructor(private htppClient: HttpClient) {}

private roomSubject = new BehaviorSubject<Room[]>([]);

get room$(): Observable<Room[]> {
  return this.roomSubject.asObservable();
}

set room(value: Room[]){
  this.roomSubject.next(value);
}

getRoomList(): void {
    const as : Observable<any> = this.htppClient.get<Room[]>(`${this.baseUrl}`);
    as.subscribe(room=>{this.room = [...this.roomSubject.value, ...room];});
}

getRoom(id:number): Observable<Room>{
  return this.htppClient.get<Room>(`${this.baseUrl}/${id}`);
}

saveRoom(room: Room):Observable<Room>{
  if(room.id){
    return this.htppClient.put<Room>(`${this.baseUrl}/${room.id}`, room);
  }else{
    return this.htppClient.post<Room>(`${this.baseUrl}`, room);
  }
}

deleteRoomById(id:number): Observable<any>{
  return this.htppClient.delete<Room>(`${this.baseUrl}/${id}`);
}

}
