import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ErrorComponent } from './error-component/error.component';
import { WarningComponent } from './warning-component/warning.component';
import { FormsModule } from '@angular/Forms';
import { GenerateTestDataComponent } from './generate-test-data/generate-test-data.component';

@NgModule({
    declarations: [
        AppComponent,
        ErrorComponent,
        WarningComponent,
        GenerateTestDataComponent
    ],
    imports: [
        BrowserModule,
        FormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
