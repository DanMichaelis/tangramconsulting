import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatListModule} from '@angular/material/list';
import { MatListItem } from '@angular/material/list';
import {MatNavList} from '@angular/material/list';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatListModule,
    MatNavList,
    MatListItem
  ]
})
export class ComponentsModule { }
