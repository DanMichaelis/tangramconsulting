import { Component, OnInit, Input } from '@angular/core';
import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';
import { TitleAndSubtitle } from 'src/app/tiny-components/DataObjects/titleandsubtitle';
import { SummaryCardRow } from '../DataObjects/summarycardrow';


@Component({
  selector: 'app-summarycard',
  templateUrl: './summarycard.component.html',
  styleUrls: ['./summarycard.component.scss']
})
export class SummarycardComponent implements OnInit {

  @Input() cardIcon: ClickableIcon;
  @Input() cardTitle: TitleAndSubtitle;
  @Input() editIcon: ClickableIcon;
  @Input() rows: SummaryCardRow[];
  private themeType: string;

  constructor() { }

  ngOnInit(): void {
  }

  public getCardIcon(): ClickableIcon {
    return this.cardIcon;
  }

  public getCardTitle(): TitleAndSubtitle {
    this.themeType = this.cardTitle.getSubTitle()
    return this.cardTitle;
  }

  public getEditIcon(): ClickableIcon {
    return this.editIcon;
  }
  public getRows(): SummaryCardRow[] {
    return this.rows;
  }

  public getDataThemeType(): string {
    return this.themeType;
  }

}
