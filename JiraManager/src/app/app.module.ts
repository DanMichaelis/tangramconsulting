import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ErrorComponent } from './error-component/error.component';
import { WarningComponent } from './warning-component/warning.component';
import { FormsModule } from '@angular/Forms';
import { GenerateTestDataComponent } from './generate-test-data/generate-test-data.component';
import { NavbarComponent } from './navbar-component/navbar.component';
import { ParseJiraDataComponent } from './parse-jira-data-component/parse-jira-data.component';

@NgModule({
    declarations: [
        AppComponent,
        ErrorComponent,
        WarningComponent,
        GenerateTestDataComponent,
        NavbarComponent,
        ParseJiraDataComponent
    ],
    imports: [
        BrowserModule,
        FormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
