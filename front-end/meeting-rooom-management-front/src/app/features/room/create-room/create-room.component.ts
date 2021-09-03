import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Room } from 'src/app/shared/models/room';
import { RoomStoreService } from '../services/room-store.service';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {
  room: Room = new Room();
  submited : boolean = false;
  formControl = new FormControl('');

  constructor(private roomStoreService: RoomStoreService,
              private router: Router,
              private fb: FormBuilder) { }


  roomForm = this.fb.group({
    "name":["", Validators.required],
    "date":["", Validators.required],
    "startHour":["", Validators.required],
    "endHour":["", Validators.required]
  })



  ngOnInit(): void {
  }

  newRoom(): void{
    this.submited = false;
    this.room = new Room();
  }


  save() {

    this.roomStoreService.addRoom(this.roomForm);

  }

  onSubmit() {
    this.submited = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/rooms']);
  }

}
