import { Component, OnInit } from '@angular/core';
import { RoomServiceService } from './room-service.service';
import { Room } from './Room';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  errorMsg : any;
  room: Room[];
 
  constructor(private roomServ : RoomServiceService) { }

  ngOnInit() {
    this.roomServ.getRoom()
    .subscribe(
      data => this.room = data,
      error => this.errorMsg = error
    );

  }
}
