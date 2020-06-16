import { ClickableIcon } from '../../tiny-components/DataObjects/clickableicon';
import { TitleAndSubtitle } from 'src/app/tiny-components/DataObjects/titleandsubtitle';

export class SummaryCardRow {
    private title: TitleAndSubtitle;
    private actions: ClickableIcon[];

    public constructor(title: TitleAndSubtitle, actions: ClickableIcon[]) {
        this.title = title;
        this.actions = actions;
    }

    public getTitle(): TitleAndSubtitle {
        return this.title;
    }

    public getActionIcons(): ClickableIcon[] {
        return this.actions;
    }

    public toString(): string {
        let returnString = 'Title=' + this.getTitle();
        if (this.actions) {
            returnString = returnString.concat(', actions=[');
            let actionCount = 0;
            for (let icon of this.actions) {
                if (actionCount == 0) {
                    returnString = returnString.concat(icon.toString());
                } else {
                    returnString = returnString.concat(', ' + icon.toString());
                }
                actionCount++;
            }
        }
        return returnString;
    }
}