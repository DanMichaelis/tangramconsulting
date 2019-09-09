export class ErrorMessage {
    private errorNumber: number;
    private errorMessage: string;
    private errorType: string;
    private severity: string;

    static errors: ErrorMessage[] = [
        new ErrorMessage(9000, 'Not Yet Implemented', 'System', 'Warning'),
        new ErrorMessage(9999, 'General System Error', 'System', 'Error')

    ]

    constructor(errNo: number, errMsg: string, errType: string, sev: string) {
        this.errorNumber = errNo;
        this.errorMessage = errMsg;
        this.errorType = errType;
        this.severity = sev;
    }

    public ErrorMessage(): ErrorMessage {
        return new ErrorMessage(9999, null, null, null);
    }

    public setErrorNumber(errNo: number) {
        if (errNo) {
            this.errorNumber = errNo;
        } else {
            this.errorNumber = 9999;
        }
    }

    public getErrorNumber(): number {
        if (!this.errorNumber) {
            this.setErrorNumber(null);
        }
        return this.errorNumber;
    }

    public getErrorMessage(): string {
        if (!this.errorMessage) {
            this.setErrorMessage(null);
        }
        return this.errorMessage;
    }

    public setErrorMessage(errMsg: string) {
        this.errorMessage = errMsg;
    }

    public getErrorType(): string {
        if (!this.errorType) {
            this.setErrorType(null);
        }
        return this.errorType;
    }

    public setErrorType(errType: string) {
        if (errType) {
            this.errorType = errType;
        } else {
            this.errorType = "General System Error";
        }
    }

    public setSeverity(sev: string) {
        if (sev) {
            this.severity = sev;
        } else {
            this.severity = "ERROR";
        }
    }

    public getSeverity(): string {
        if (!this.severity) {
            this.setSeverity(null);
        }
        return this.severity;
    }

    public toString(): string {
        return this.getSeverity() + ': ' + this.getErrorNumber() + ' - ' + this.getErrorType() + ': ' + this.getErrorMessage();
    }

    public static getErrorByErrorNumber(errNo: number): ErrorMessage {
        for (let e of this.errors) {
            if (e.getErrorNumber() == errNo) {
                return e;
            }
        }
        return null;
    }
}