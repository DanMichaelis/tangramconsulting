export class TitleAndSubtitle {
    private title: string;
    private subTitle: string;

    constructor(title: string, subtitle?: string) {
        this.title = title;
        if (subtitle) {
            this.subTitle = subtitle;
        }
    }

    public getTitle(): string {
        return this.title;
    }

    public getSubTitle(): string {
        return this.subTitle;
    }

    public toString(): string {
        let returnString = 'Title=' + this.getTitle();
        if (this.getSubTitle()) {
            returnString = returnString.concat(' Subtitle=' + this.getSubTitle())
        }
        return returnString;
    }
}