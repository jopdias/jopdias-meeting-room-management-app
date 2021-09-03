import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateRoomComponent } from './create-room/create-room.component';
import { RoomDetailsComponent } from './room-details/room-details.component';
import { RoomListComponent } from './room-list/room-list.component';
import { UpdateRoomComponent } from './update-room/update-room.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RoomService } from './services/room.service';



@NgModule({
  declarations: [
    CreateRoomComponent,
    RoomDetailsComponent,
    RoomListComponent,
    UpdateRoomComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [RoomService]
})
export class RoomModule { }
