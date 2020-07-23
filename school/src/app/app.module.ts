import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faFilm, faSchool, faBook, faBookOpen, faBookReader, faChalkboardTeacher, faUniversity, faNewspaper, fas }
    from '@fortawesome/free-solid-svg-icons';
import { HeaderBarComponent } from './navigation/header-bar/header-bar.component';
import { ServicesModule } from './services/services.module';
import { GridsterModule } from 'angular-gridster2';
import { BasecomponentsModule } from './basecomponents/basecomponents.module';
import { HttpClientModule } from '@angular/common/http';
import { AvatarModule } from 'ngx-avatar';

@NgModule({
    declarations: [
        AppComponent,
        HeaderBarComponent,

    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FontAwesomeModule,
        ServicesModule,
        GridsterModule,
        BasecomponentsModule,
        HttpClientModule,
        AvatarModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
    constructor(library: FaIconLibrary) {
        library.addIconPacks(fas);
        library.addIcons(faFilm, faUniversity, faBook, faBookReader, faChalkboardTeacher, faNewspaper);
    }
}
