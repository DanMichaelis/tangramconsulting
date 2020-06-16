import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';
import { Member } from './member';
import { UserService } from '../Services/user.service';
import { DatePipe } from '@angular/common';

export class OrganizationEvent {
    private eventId: string;
    private name: string;
    private eventDate: Date;
    private description: string;
    private author: Member;
    private created: Date;
    private lastUpdated: Date;
    private lastUpdateUser: Member;

    public constructor(eventName: string, description: string) {
        this.name = eventName;
        this.description = description;
        this.author = (new Member()).setFirstName(UserService.getCurrentUser().firstName).setLastName(UserService.getCurrentUser().lastName).setEmail(UserService.getCurrentUser().email);
        this.created = new Date();
        this.eventId = this.created.toISOString() + this.author.getFullNameAndTitle();
    }

    public getId(): string {
        return this.eventId;
    }

    public getName(): string {
        return this.name;
    }

    private setLastUpdateDate(): OrganizationEvent {
        this.lastUpdated = new Date();
        this.lastUpdateUser = (new Member()).setFirstName(UserService.getCurrentUser().firstName).setLastName(UserService.getCurrentUser().lastName).setEmail(UserService.getCurrentUser().email);
        return this;
    }

    public setDate(eventDate: Date): OrganizationEvent {
        this.eventDate = eventDate;
        this.setLastUpdateDate();
        return this;
    }

    public getEventDate(): Date {
        return this.eventDate;
    }

    public setDescription(description: string): OrganizationEvent {
        this.description = description;
        this.setLastUpdateDate();
        return this;
    }

    public getDescription(): string {
        return this.description;
    }

    public getAuthor(): Member {
        return this.author;
    }

    public getCreateDate(): Date {
        return this.created;
    }

    public getLastUpdater(): Member {
        return this.lastUpdateUser;
    }

    public getLastUpdateDate(): Date {
        return this.lastUpdated;
    }


}