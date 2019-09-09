import { Component, OnInit } from '@angular/core';
import { ErrorMessage } from 'src/app/dataobjects/errormessage';

@Component({
  selector: 'app-warning',
  templateUrl: './warning.component.html',
  styleUrls: ['./warning.component.css']
})
export class WarningComponent implements OnInit {

  private msg: ErrorMessage;
  showComponent: boolean;

  constructor() {
    this.showComponent = false;
  }

  clearError() {
    this.showComponent = false;
  }
  ngOnInit() { }

  setMessage(msg: ErrorMessage) {
    this.msg = msg;
    console.log(msg.toString());
    this.showComponent = (msg.getErrorMessage().valueOf() && msg.getErrorMessage().length > 0);
  }

  public toString(): string {
    return this.msg.toString();
  }

}