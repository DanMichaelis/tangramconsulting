import { Component, OnInit, Input } from '@angular/core';
import { LeftAndRightClickableItems } from 'src/app/tiny-components/DataObjects/leftandrightclickableitems';
import { SummaryCard } from '../DataObjects/summarycard';

@Component({
  selector: 'app-threesummarycardwithaddandeditcontent',
  templateUrl: './threesummarycardwithaddandeditcontent.component.html',
  styleUrls: ['./threesummarycardwithaddandeditcontent.component.scss']
})

export class ThreesummarycardwithaddandeditcontentComponent implements OnInit {

  @Input() private addAndEditButtons: LeftAndRightClickableItems;
  @Input() private summaryCards: SummaryCard[];

  constructor() {

  }

  ngOnInit(): void {
  }

  public getSummaryCards(): SummaryCard[] {
    let cardCount: number = 0;
    for (let card of this.summaryCards) {
      cardCount++;
      console.log('Summary Card ' + cardCount + ' title:  ' + card.getCardTitle().toString());
    }
    return this.summaryCards;
  }

  public getAddAndEditButtons() {
    return this.addAndEditButtons;
  }
}
