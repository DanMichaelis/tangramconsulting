import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navigation/navbar/navbar.component';
import { MenuComponent } from './components/navigation/menu/menu.component';
import { MatListModule } from '@angular/material/list';
import { MissionStatementComponent } from './components/mission-statement/mission-statement.component';


@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        MenuComponent,
        MissionStatementComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        MatListModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
