import { Component, OnInit, ViewChild } from '@angular/core';

import { UserMessageList } from 'src/app/dataobjects/userMessage/usermessagelist';
import { UserMessage } from 'src/app/dataobjects/userMessage/usermessage';

@Component({
  selector: 'app-message-box',
  templateUrl: './message-box.component.html',
  styleUrls: ['./message-box.component.css']
})
export class MessageBoxComponent implements OnInit {

  messageList: UserMessage[] = [];
  showComponent: boolean;

  constructor(public userMessageList: UserMessageList) {
    this.messageList = this.userMessageList.getAllMessages();
    this.showComponent = this.messageList.length > 0 && this.messageList[0] !== null;

  }

  ngOnInit() {
    this.userMessageList.subscribe(update => {
      this.messageList = this.userMessageList.getAllMessages();
      this.showComponent = this.messageList.length > 0 && this.messageList[0] !== null;
    })
  }
}
