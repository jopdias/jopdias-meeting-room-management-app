import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Room } from 'src/app/shared/models/room';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

private baseUrl = 'http://localhost:8080/api/v1/rooms'

constructor(private httpClient: HttpClient) {}

getRoomsList(): Observable<any> {
  return this.httpClient.get(`${this.baseUrl}`);
}

getRoom(id:number): Observable<Room>{
  return this.httpClient.get<Room>(`${this.baseUrl}/${id}`);
}

saveRoom(room: Partial<Room>):Observable<Room>{
    return this.httpClient.post<Room>(`${this.baseUrl}`, room);
}

updateRoom(id:number, value: any): Observable<Room>{
  return this.httpClient.put<Room>(`${this.baseUrl}/${id}`, value);

}
deleteRoomById(id:number): Observable<any>{
  return this.httpClient.delete<Room>(`${this.baseUrl}/${id}`);
}

}
