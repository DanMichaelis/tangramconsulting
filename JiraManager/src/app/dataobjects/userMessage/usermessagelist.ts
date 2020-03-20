import { UserMessage } from './usermessage';
import { Observer, Observable, Subject } from 'rxjs';
import { nextContext } from '@angular/core/src/render3';

export class UserMessageList extends Subject<UserMessage> {
    private static messages: UserMessage[] = [];

    constructor() {
        super();
    }

    public getAllMessages(): UserMessage[] {
        let l_msgs: UserMessage[] = [];
        for (let l_msg of UserMessageList.messages) {
            l_msgs.push(l_msg);
        }
        return l_msgs;
    }

    public getErrors(): UserMessage[] {
        let l_msgs: UserMessage[] = [];
        for (let l_msg of UserMessageList.messages) {
            if (l_msg.getType() === 'ERROR') {
                l_msgs.push(l_msg);
            }
        }
        return l_msgs;
    }

    public getWarnings(): UserMessage[] {
        let l_msgs: UserMessage[] = [];
        for (let l_msg of UserMessageList.messages) {
            if (l_msg.getType() === 'WARNING') {
                l_msgs.push(l_msg);
            }
        }
        return l_msgs;
    }

    public getSuccesses(): UserMessage[] {
        let l_msgs: UserMessage[] = [];
        for (let l_msg of UserMessageList.messages) {
            if (l_msg.getType() === 'ERROR') {
                l_msgs.push(l_msg);
            }
        }
        return l_msgs;
    }

    public addMessage(msg: UserMessage) {
        if (null !== msg) {
            UserMessageList.messages.push(msg);
            this.next(msg);
        }
    }

    public addSimpleMessage(msg: string) {
        if (null !== msg && msg.length > 0) {
            let userMessage: UserMessage = new UserMessage(msg);
            UserMessageList.messages.push(userMessage);
            console.log('addSimpleMessage');
            this.next(userMessage);
        }
    }
}
