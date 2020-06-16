import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { GridsterModule } from 'angular-gridster2';
import { AvatarModule } from 'ngx-avatar';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { AppComponent } from './app.component';
import { ClickableiconComponent } from './tiny-components/clickableicon/clickableicon.component';
import { TitleandsubtitleComponent } from './tiny-components/titleandsubtitle/titleandsubtitle.component';
import { ThreesummarycardwithaddandeditcontentComponent } from './large-components/threesummarycardwithaddandeditcontent/threesummarycardwithaddandeditcontent.component';
import { LeftandrightclickableitemsComponent } from './tiny-components/leftandrightclickableitems/leftandrightclickableitems.component';
import { SummarycardComponent } from './large-components/summarycard/summarycard.component';
import { SummarycardrowComponent } from './large-components/summarycardrow/summarycardrow.component';
import { ClickableIcon } from './tiny-components/DataObjects/clickableicon';
import { EventComponent } from './large-components/event/event.component';

@NgModule({
  declarations: [
    AppComponent,
    ClickableiconComponent,
    TitleandsubtitleComponent,
    ThreesummarycardwithaddandeditcontentComponent,
    LeftandrightclickableitemsComponent,
    SummarycardComponent,
    SummarycardrowComponent,
    EventComponent
  ],
  imports: [
    FontAwesomeModule,
    HttpClientModule,
    NgbModule,
    GridsterModule,
    AvatarModule,
    BrowserModule
  ],
  providers: [ClickableiconComponent, TitleandsubtitleComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
