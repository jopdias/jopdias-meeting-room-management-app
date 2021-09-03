import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Room } from 'src/app/shared/models/room';
import { RoomStoreService } from '../services/room-store.service';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {
  submited : boolean = false;
  formRoom!: FormGroup;
  room = new Room();


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
    this.room.name = new FormControl(this.room.name).value;
    this.room.date = new FormControl(this.room.date).value;
    this.room.startHour = new FormControl(this.room.startHour).value;
    this.room.endHour = new FormControl(this.room.endHour).value;
    this.roomStoreService.addRoom(this.room);

  }

  onSubmit() {
    this.submited = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/rooms']);
  }

}
