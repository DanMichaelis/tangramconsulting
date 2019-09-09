import { Component, OnInit, Input } from '@angular/core';
import { ErrorMessage } from 'src/app/dataobjects/errormessage';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  private msg: ErrorMessage;
  showComponent: Boolean;

  constructor() {
    this.showComponent = false;
  }

  clearError() {
    this.showComponent = false;
  }
  ngOnInit() { }

  setMessage(msg: ErrorMessage) {
    this.msg = msg;
    this.showComponent = (msg.getErrorMessage() && msg.getErrorMessage().length > 0);
  }

  public toString(): string {
    return this.msg.toString();
  }
}
