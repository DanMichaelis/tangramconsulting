import { Component, OnInit, Input } from '@angular/core';
import { UserMessage } from 'src/app/dataobjects/userMessage/usermessage';

@Component({
  selector: 'app-usermessage',
  templateUrl: './usermessage.component.html',
  styleUrls: ['./usermessage.component.css']
})
export class UserMessageComponent implements OnInit {

  @Input() msg: UserMessage;
  displayClass: string;

  constructor() {

  }

  ngOnInit() {
    this.setDisplayClass();

  }

  setDisplayClass() {
    this.displayClass = 'w-100 h-25';
    if (this.msg.getType() === 'ERROR') {
      this.displayClass = this.displayClass = ' alert-danger';
    } else if (this.msg.getType() === 'WARNING') {
      this.displayClass = this.displayClass + ' alert-warning';
    } else if (this.msg.getType() === 'MESSAGE') {
      this.displayClass = this.displayClass + ' alert-success';
    } else {
      this.displayClass = this.displayClass + ' alert-info';
    }
  }

}
