import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClickableIconComponent } from './clickable-icon/clickableicon.component';
import { ProfileCardComponent } from './profile-card/profile-card.component';
import { GridsterModule } from 'angular-gridster2';
import { faFilm, faSchool, faBook, faBookOpen, faBookReader, faChalkboardTeacher, faUniversity, faNewspaper, fas } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';

import { GridsterLayoutComponent } from './gridster-layout/gridster-layout.component';
import { AvatarModule } from 'ngx-avatar';



@NgModule({
    declarations: [ClickableIconComponent, ProfileCardComponent, GridsterLayoutComponent],
    imports: [
        CommonModule,
        GridsterModule,
        AvatarModule,
        FontAwesomeModule
    ],
    exports: [ClickableIconComponent, ProfileCardComponent, GridsterLayoutComponent]
})
export class BasecomponentsModule {
    constructor(library: FaIconLibrary) {
        library.addIconPacks(fas);
        library.addIcons(faFilm, faUniversity, faBook, faBookReader, faChalkboardTeacher, faNewspaper);
    }
}
