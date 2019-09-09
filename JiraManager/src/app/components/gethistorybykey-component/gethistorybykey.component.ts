import { Component, OnInit, ViewChild } from '@angular/core';
import { ErrorComponent } from '../application-message-box-component/error-component/error.component';
import { MessageBoxComponent } from '../application-message-box-component/message-box/message-box.component';
import { ErrorMessage } from 'src/app/dataobjects/errormessage';


@Component({
  selector: 'app-gethistorybykey-component',
  templateUrl: './gethistorybykey.component.html',
  styleUrls: ['./gethistorybykey.component.css']
})

export class GethistorybykeyComponent implements OnInit {
  @ViewChild(MessageBoxComponent)
  messageBox: MessageBoxComponent;

  private errorMessage: ErrorMessage;

  constructor() {
    this.errorMessage = ErrorMessage.getErrorByErrorNumber(9000);
  }

  ngOnInit() {
    this.setErrorMessage();
  }



  setErrorMessage() {
    this.messageBox.setMessage(this.errorMessage);
  }

}
