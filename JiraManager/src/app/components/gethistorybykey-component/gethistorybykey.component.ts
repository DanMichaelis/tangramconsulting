import { Component, OnInit } from '@angular/core';


import { UserMessage } from 'src/app/dataobjects/userMessage/usermessage';
import { UserMessageList } from 'src/app/dataobjects/userMessage/usermessagelist';


@Component({
  selector: 'app-gethistorybykey-component',
  templateUrl: './gethistorybykey.component.html',
  styleUrls: ['./gethistorybykey.component.css']
})

export class GethistorybykeyComponent implements OnInit {
  constructor(userMessageList: UserMessageList) {
    userMessageList.addMessage(new UserMessage('Get History Not Yet Implemented', 9000, 'WARNING'));
  }
  ngOnInit() {

  }
}