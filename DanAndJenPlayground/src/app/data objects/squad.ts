import { Member } from './member';
import { ClickableIcon } from '../tiny-components/DataObjects/clickableicon';
import { DemoAvatars } from './demo objects/demoavatars';
import { DemoMembers } from './demo objects/demomembers';

export class Squad {
    name: string;
    type: string;
    members = new Map();
    avatar: ClickableIcon;
    mission: string;

    constructor() {
    }

    public setName(name: string): Squad {
        this.name = name;
        return this;
    }

    public getName(): string {
        return this.name;
    }

    public setType(type: string): Squad {
        this.type = type;
        return this;
    }

    public getType(): string {
        return this.type;
    }

    public setAvatar(avatar: ClickableIcon): Squad {
        this.avatar = avatar;
        return this;
    }

    public getAvatar(): ClickableIcon {
        return this.avatar;
    }

    public setMission(mission: string): Squad {
        this.mission = mission;
        return this;
    }

    public addMember(member: Member, role: string): Squad {
        this.members.set(member, role);
        return this;
    }

    public getMembers(): Member[] {
        let coeMembers = Array.from(this.members.keys());
        return coeMembers;
    }

    public getSquadRoleForMember(member: Member): string {
        return this.members.get(member);
    }

    public getMemberCount(): number {
        return this.members.size;
    }

}