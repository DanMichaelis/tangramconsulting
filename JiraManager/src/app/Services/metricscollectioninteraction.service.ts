import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { UserMessageList } from '../dataobjects/userMessage/usermessagelist';
import { UserMessage } from '../dataobjects/userMessage/usermessage';

@Injectable({
  providedIn: 'root'
})
export class MetricsCollectionInteractionService {

  metricsCollectionUrl: string = '/jira';

  constructor(private httpClient: HttpClient, private userMessageList: UserMessageList) { }

  invokeFileParsing(projectToParse: string) {
    this.httpClient.get<{ status: string }>
      ('http://localhost:10000' +
        this.metricsCollectionUrl +
        '/parsePulledIssueData?loadDirectory=' +
        projectToParse).subscribe(
          data => {
            let l_data = <{ status: string }>data;
            this.userMessageList.addSimpleMessage(l_data.status);
          },
          error => {
            let l_error = <HttpErrorResponse>error;
            this.userMessageList.addMessage(new UserMessage(l_error.message, 9999, 'ERROR', 'ERROR'));
          }
        )
  }
}