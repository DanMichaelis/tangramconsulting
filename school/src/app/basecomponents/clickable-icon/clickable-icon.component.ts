import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AvatarModule } from 'ngx-avatar';

@Component({
  selector: 'app-clickable-icon',
  templateUrl: './clickable-icon.component.html',
  styleUrls: ['./clickable-icon.component.css']
})
export class ClickableIconComponent implements OnInit {
private avatarDescription: string;
    private facebookId: string;
    private googleId: string;
    private twitterId: string;
    private vkId: string;
    private skypeId: string;
    private gravatarId: string;
    private gitHubId: string;

    private name: string;
    private avatarValue: string;
    private avatarInitialSize: number; // Deliberately inaccessable; may be future implemented
    private avatarBgColor: string;  // Deliberately inaccessable; may be future implemented
    private avatarFgColor: string;  // Deliberately inaccessable; may be future implemented
    private avatarSize: string;  // Deliberately inaccessable; may be future implemented
    private avatarRound: boolean;
    private avatarCornerRadius: number;  // Deliberately inaccessable; may be future implemented
    private avatarBorderColor: string;  // Deliberately inaccessable; may be future implemented

    // Image Values
    private imageDescription: string;

    // Icon Values
    private iconDescription: string;
    private fontAwesomeIcon: string;

    // Multi-use Values
    private imageSrc: string;
    private altText: string;
    private size = 35;
    decorativeOnly: boolean = false;

    public static getAvatarIcon(description: string, skypeId: string, name: string, value: string, image: string, size?: number): ClickableIconComponent {
        let icon: ClickableIconComponent = new ClickableIconComponent();
        icon.avatarDescription = description;
        icon.skypeId = skypeId;
        icon.name = name;
        icon.avatarValue = value;
        icon.imageSrc = image;
        if (size) {
            icon.size = size;
        }
        return icon;
    }

    public static getImageIcon(description: string, altText: string, image: string): ClickableIconComponent {
        let icon: ClickableIconComponent = new ClickableIconComponent();
        icon.imageDescription = description;
        icon.imageSrc = image;
        icon.altText = altText;
        return icon;
    }

    public static getClassBasedICon(description: string, fontAwesomeClass: string, altText: string): ClickableIconComponent {
        let icon: ClickableIconComponent = new ClickableIconComponent();
        icon.iconDescription = description;
        icon.fontAwesomeIcon = fontAwesomeClass;
        icon.altText = altText;
        return icon;
    }

    constructor() { }

    public setDecorativeOnly(isDecorative: boolean): ClickableIconComponent {
        this.decorativeOnly = this.decorativeOnly;
        return this;
    }

    public getAvatarDescription(): string {
        return this.avatarDescription;
    }

    public getFacebookId(): string {
        return this.facebookId;
    }

    public getGoogleId(): string {
        return this.googleId;
    }

    public getTwitterId(): string {
        return this.twitterId;
    }

    public getVkId(): string {
        return this.vkId;
    }

    public getSkypeId(): string {
        return this.skypeId;
    }

    public getGravatarId(): string {
        return this.gravatarId;
    }

    public getGitHubId(): string {
        return this.gitHubId
    }

    public getAvatarName(): string {
        return this.name;
    }

    public getAvatarValue(): string {
        return this.avatarValue;
    };

    public isAvatarRound(): boolean {
        return this.avatarRound;
    }

    public getImageDescription(): string {
        return this.imageDescription;
    }

    public getIconDescription(): string {
        return this.iconDescription;
    }

    public isDecorativeOnly(): boolean {
        return this.decorativeOnly;
    }

    public getFontAwesomeIcon(): string {
        let classString: string = this.fontAwesomeIcon;
        if (!this.isDecorativeOnly()) {
            classString = classString.concat(' clickable-icon');
        }

        return classString;
    }

    public getImageSrc(): string {
        console.log('Retrieving image from ' + this.imageSrc);
        return this.imageSrc;
    }

    public getAltText(): string {
        return this.altText;
    }

    public setSize(size: number): ClickableIconComponent {
        this.size = size;
        return this;
    }

    public getAvatarSize() {
        return this.size;
    }

    public getImageHeight() {
        return this.size;
    }

    public getImageWidth() {
        return this.size;
    }

    public isAvatar(): boolean {
        if (this.avatarDescription) {
            return true;
        }
        return false;
    }

    public isImage(): boolean {
        if (this.imageDescription) {
            return true;
        }
        return false;
    }

    public isIcon(): boolean {
        if (this.iconDescription) {
            return true;
        }
        return false;
    }

    public toString(): string {
        let returnString = '';

        if (this.isAvatar()) {
            // Return the Avatar definition
            returnString = 'name=' + this.getAvatarName()
                + ' description=' + this.getAvatarDescription()
                + ' skypeId=' + this.getSkypeId();
        }

        if (this.isImage()) {
            returnString = 'name=' + this.getImageDescription()
                + ' imageSource=' + this.getImageSrc()
                + ' altText=' + this.getAltText();
        }
        return returnString;
    }
@Output() clickableIconEvent: EventEmitter<any> = new EventEmitter<any>();


  ngOnInit(): void {
  }


  public iconClicked(event: Event) {
    this.clickableIconEvent.emit(event);
  }

}
