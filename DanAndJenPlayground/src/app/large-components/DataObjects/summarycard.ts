import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';
import { TitleAndSubtitle } from '../../tiny-components/DataObjects/titleandsubtitle';
import { SummaryCardRow } from './summarycardrow';

export class SummaryCard {
    private cardIcon: ClickableIcon;
    private cardTitle: TitleAndSubtitle;
    private cardEditIcon: ClickableIcon;
    private cardRows: SummaryCardRow[];

    public constructor(icon: ClickableIcon, title: TitleAndSubtitle, editIcon: ClickableIcon, data: SummaryCardRow[]) {
        this.cardIcon = icon;
        this.cardEditIcon = editIcon;
        this.cardTitle = title;
        this.cardRows = data;
    }

    public getCardIcon(): ClickableIcon {
        return this.cardIcon;
    }

    public getCardTitle(): TitleAndSubtitle {
        return this.cardTitle;
    }

    public getEditIcon(): ClickableIcon {
        return this.cardEditIcon;
    }

    public getCardData(): SummaryCardRow[] {
        return this.cardRows;
    }
}