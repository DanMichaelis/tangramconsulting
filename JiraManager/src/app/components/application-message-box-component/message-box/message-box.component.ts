import { Component, OnInit, ViewChild } from '@angular/core';
import { ErrorComponent } from '../error-component/error.component';
import { WarningComponent } from '../warning-component/warning.component';
import { ErrorMessage } from 'src/app/dataobjects/errormessage';

@Component({
  selector: 'app-message-box',
  templateUrl: './message-box.component.html',
  styleUrls: ['./message-box.component.css']
})
export class MessageBoxComponent implements OnInit {

  private errorMessage: ErrorMessage;

  constructor() { }

  ngOnInit() {
  }

  @ViewChild(ErrorComponent)
  errorComponent: ErrorComponent;

  @ViewChild(WarningComponent)
  warningComponent: WarningComponent;

  public setMessage(msg: ErrorMessage) {
    this.errorMessage = msg;
    console.log(msg.getSeverity().toLowerCase() === 'warning');
    if (msg.getSeverity().toLowerCase() === 'warning') {
      console.log('Setting warning message:  ' + msg.toString());
      this.warningComponent.setMessage(this.errorMessage);
    }
    if (msg.getSeverity().toLowerCase() === 'error') {
      this.errorComponent.setMessage(this.errorMessage);
    }
  }
}
