import { Injectable } from '@angular/core';
import { UserMessage } from '../dataobjects/userMessage/usermessage';

@Injectable({
  providedIn: 'root'
})
export class UserMessageService {

  constructor() { }

  public static getMessageByNumber(msgNo: number): UserMessage {
    return null;
  }
}
