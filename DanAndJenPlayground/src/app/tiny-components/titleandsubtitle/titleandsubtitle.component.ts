import { Component, OnInit, Input } from '@angular/core';
import { TitleAndSubtitle } from '../DataObjects/titleandsubtitle';

@Component({
  selector: 'app-titleandsubtitle',
  templateUrl: './titleandsubtitle.component.html',
  styleUrls: ['./titleandsubtitle.component.scss']
})
export class TitleandsubtitleComponent implements OnInit {

  @Input() data: TitleAndSubtitle;

  constructor() { }


  ngOnInit(): void {
  }

  public getTitle(): string {
    if (this.data) {
      return this.data.getTitle();
    } else {
      return 'No Title';
    }
  }

  public getSubTitle(): string {
    if (this.data) {
      return this.data.getSubTitle();
    } else { return 'No Subtitle'; }
  }

  public toString(): string {
    let returnString = 'Title=' + this.data.getTitle();
    if (this.data.getSubTitle()) {
      returnString = returnString.concat(' Subtitle=' + this.data.getSubTitle())
    }
    return returnString;
  }

}
