import { Component, OnInit, ViewChild } from '@angular/core';
import { MessageBoxComponent } from '../application-message-box-component/message-box/message-box.component';
import { ErrorMessage } from 'src/app/dataobjects/errormessage';

@Component({
  selector: 'app-manually-pull-jira-issue',
  templateUrl: './manually-pull-jira-issue.component.html',
  styleUrls: ['./manually-pull-jira-issue.component.css']
})
export class ManuallyPullJiraIssueComponent implements OnInit {

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
