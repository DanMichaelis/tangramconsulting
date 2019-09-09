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
import { ErrorComponent } from './components/application-message-box-component/error-component/error.component';
import { WarningComponent } from './components/application-message-box-component/warning-component/warning.component';
import { ManuallyPullJiraIssueComponent } from './components/manually-pull-jira-issue/manually-pull-jira-issue.component';


@NgModule({
    declarations: [
        AppComponent,
        GenerateTestDataComponent,
        NavbarComponent,
        ParseJiraDataComponent,
        GethistorybykeyComponent,
        MessageBoxComponent,
        ErrorComponent,
        WarningComponent,
        ManuallyPullJiraIssueComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
