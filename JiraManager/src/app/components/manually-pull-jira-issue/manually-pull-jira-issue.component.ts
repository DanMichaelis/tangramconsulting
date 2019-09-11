import { Component, OnInit, ViewChild } from '@angular/core';

import { UserMessageList } from 'src/app/dataobjects/userMessage/usermessagelist';
import { MetricsCollectionInteractionService } from 'src/app/Services/metricscollectioninteraction.service';

@Component({
  selector: 'app-manually-pull-jira-issue',
  templateUrl: './manually-pull-jira-issue.component.html',
  styleUrls: ['./manually-pull-jira-issue.component.css']
})
export class ManuallyPullJiraIssueComponent implements OnInit {

  projectToParse: string = null;
  methodResponse: string = null;

  constructor(private userMsgSvc: UserMessageList,
    public metricsCollectionSvc: MetricsCollectionInteractionService) {

  }

  ngOnInit() {

  }

  parseProject() {
    this.metricsCollectionSvc.invokeFileParsing(this.projectToParse);
    console.log('Method Response:  ' + this.methodResponse);
  }


}
