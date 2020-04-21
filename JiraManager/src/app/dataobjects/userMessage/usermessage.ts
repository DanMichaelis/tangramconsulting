export class UserMessage {
    private messageNumber: number;
    private message: string;
    private messageType: string;
    private messageSeverity: string;

    constructor(msg: string, msgNumber?: number, msgType?: string, msgSev?: string) {

        this.message = msg;
        if (msgNumber) {
            this.messageNumber = msgNumber;
        } else {
            this.messageNumber = 0;
        }
        if (msgType && msgType.length > 0) {
            this.messageType = msgType;
        } else {
            this.messageType = 'MESSAGE';
        }
        if (msgSev && msgSev.length > 0) {
            this.messageSeverity = msgSev;
        } else {
            this.messageSeverity = 'INFO';
        }
    }

    public setNumber(errNo: number) {
        if (errNo) {
            this.messageNumber = errNo;
        } else {
            this.messageNumber = 0;
        }
    }

    public getNumber(): number {
        if (!this.messageNumber) {
            this.setNumber(null);
        }
        return this.messageNumber;
    }

    public getMessage(): string {
        if (!this.message) {
            this.setMessage(null);
        }
        return this.message;
    }

    public setMessage(errMsg: string) {
        this.message = errMsg;
    }

    public getType(): string {
        if (!this.messageType) {
            this.setType(null);
        }
        return this.messageType;
    }

    public setType(errType: string) {
        if (errType) {
            this.messageType = errType;
        } else {
            this.messageType = 'MESSAGE';
        }
    }

    public setSeverity(sev: string) {
        if (sev) {
            this.messageSeverity = sev;
        } else {
            this.messageSeverity = 'INFO';
        }
    }

    public getSeverity(): string {
        if (!this.messageSeverity) {
            this.setSeverity(null);
        }
        return this.messageSeverity;
    }

    public toString(): string {

        return this.getSeverity() + ': ' + this.getNumber() + ' - ' + this.getType() + ': ' + this.getMessage();
    }
}
