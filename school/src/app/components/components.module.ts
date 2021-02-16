import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatListModule } from '@angular/material/list';
import { MatListItem } from '@angular/material/list';
import { MatNavList } from '@angular/material/list';
import { MissionStatementComponent } from './mission-statement/mission-statement.component';
import { GridsterModule } from 'angular-gridster2';



@NgModule({
    declarations: [MissionStatementComponent],
    imports: [
        CommonModule,
        MatListModule,
        MatNavList,
        MatListItem,
        GridsterModule
    ]
})
export class ComponentsModule { }
