import { Squad } from './squad';
import { COE } from './coe';
import { ClickableIcon } from '../tiny-components/DataObjects/clickableicon';
import { DemoAvatars } from './demo objects/demoavatars';

export class Member {
    firstName: string;
    middleName: string;
    lastName: string;
    email: string;
    skype: string;
    phoneNumber: string;
    title: string;
    avatar: ClickableIcon;
    entityRole = new Map();
    squads: Squad[];
    coes: COE[];

    constructor() {

    }

    public setFirstName(firstName: string): Member {
        this.firstName = firstName;
        return this;
    }

    public getFirstName(): string {
        return this.firstName;
    }

    public setMiddleName(middleName: string): Member {
        this.middleName = middleName;
        return this;
    }

    public getMiddleName(): string {
        return this.middleName;
    }

    public setLastName(lastName: string): Member {
        this.lastName = lastName;
        return this;
    }

    public getLastName(): string {
        return this.lastName;
    }

    public getFullName(): string {
        let fullName = this.getFirstName();

        if (this.middleName) {
            fullName = fullName.concat(' ', this.getMiddleName());
        }
        fullName = fullName.concat(' ', this.getLastName());
        return fullName;
    }

    public getFullNameAndTitle(): string {
        let fullName = this.getFullName();
        if (this.title) {
            fullName.concat(', ', this.getTitle());
        }
        return fullName;
    }

    public setEmail(email: string): Member {
        this.email = email;
        return this;
    }

    public getEmail(): string {
        return this.email;
    }

    public setSkypeId(skypeId: string): Member {
        this.skype = skypeId;
        return this;
    }

    public getSkypeId(): string {
        return this.skype;
    }

    public setPhoneNumber(phoneNumber: string): Member {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public getPhoneNumber(): string {
        return this.phoneNumber;
    }

    public setTitle(title: string): Member {
        this.title = title;
        return this;
    }

    public getTitle(): string {
        return this.title;
    }

    public setRole(entityName: string, role: string): Member {
        this.entityRole.set(entityName, role);
        return this;
    }

    public getRole(entityName: string): string {
        return this.entityRole.get(entityName);
    }

    public setAvatar(avatar: ClickableIcon): Member {
        this.avatar = avatar;
        return this;
    }

    public getAvatar(): ClickableIcon {
        return this.avatar;
    }
}