import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/Forms';
import { GenerateTestDataComponent } from './components/generate-test-data/generate-test-data.component';
import { NavbarComponent } from './components/navbar-component/navbar.component';
import { ParseJiraDataComponent } from './components/parse-jira-data-component/parse-jira-data.component';
import { GethistorybykeyComponent } from './components/gethistorybykey-component/gethistorybykey.component';
import { MessageBoxComponent } from './components/application-message-box-component/message-box/message-box.component';
import { ManuallyPullJiraIssueComponent } from './components/manually-pull-jira-issue/manually-pull-jira-issue.component';
import { UserMessageService } from './Services/usermessage.service';
import { UserMessageList } from './dataobjects/userMessage/usermessagelist';
import { MetricsCollectionInteractionService } from './Services/metricscollectioninteraction.service';
import { UserMessageComponent } from './components/application-message-box-component/usermessage/usermessage.component';


@NgModule({
    declarations: [
        AppComponent,
        GenerateTestDataComponent,
        NavbarComponent,
        ParseJiraDataComponent,
        GethistorybykeyComponent,
        MessageBoxComponent,
        ManuallyPullJiraIssueComponent,
        UserMessageComponent
    ],
    imports: [
        NgModule,
        BrowserModule,
        FormsModule,
        HttpClientModule
    ],
    providers: [UserMessageService, UserMessageList, MetricsCollectionInteractionService],
    bootstrap: [AppComponent]
})
export class AppModule { }
