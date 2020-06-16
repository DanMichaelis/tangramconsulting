import { Component, OnInit, Input } from '@angular/core';
import { TitleandsubtitleComponent } from 'src/app/tiny-components/titleandsubtitle/titleandsubtitle.component';
import { ClickableiconComponent } from 'src/app/tiny-components/clickableicon/clickableicon.component';
import { TitleAndSubtitle } from 'src/app/tiny-components/DataObjects/titleandsubtitle';
import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';

@Component({
  selector: 'app-summarycardrow',
  templateUrl: './summarycardrow.component.html',
  styleUrls: ['./summarycardrow.component.scss']
})
export class SummarycardrowComponent implements OnInit {

  @Input() private title: TitleAndSubtitle;
  @Input() private icons: ClickableIcon[];

  constructor() { }

  ngOnInit(): void {

  }

  public getRowTitle(): TitleAndSubtitle {
    console.log('SummaryRowComponent title:  ' + this.title.toString());
    return this.title;
  }

  public getIcons(): ClickableIcon[] {
    return this.icons;
  }

}
