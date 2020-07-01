import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClickableIconComponent } from './clickable-icon/clickable-icon.component';
import { ProfileCardComponent } from './profile-card/profile-card.component';
import { GridsterModule } from 'angular-gridster2';

import { GridsterLayoutComponent } from './gridster-layout/gridster-layout.component';



@NgModule({
    declarations: [ClickableIconComponent, ProfileCardComponent, GridsterLayoutComponent],
    imports: [
        CommonModule,
        GridsterModule
    ],
    exports: [ClickableIconComponent, ProfileCardComponent, GridsterLayoutComponent]
})
export class BasecomponentsModule { }
