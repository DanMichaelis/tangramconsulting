import { ClickableIcon } from '../tiny-components/DataObjects/clickableicon';
import { Member } from './member';

export class COE {
    private name: string;
    private type: string;
    private icon: ClickableIcon;
    private mission: string;
    private members = new Map();

    constructor(name: string, type?: string) {
        this.name = name;
        if (type) { this.type = type; }
    }

    public setName(name: string): COE {
        this.name = name;
        return this;
    }

    public getName(): string {
        return this.name;
    }

    public setType(type: string): COE {
        this.type = type;
        return this;
    }

    public getType(): string {
        return this.type;
    }

    public setIcon(icon: ClickableIcon): COE {
        this.icon = icon;
        return this;
    }

    public getIcon(): ClickableIcon {
        return this.icon;
    }

    public setMission(mission: string): COE {
        this.mission = mission;
        return this;
    }

    public addMember(member: Member, role: String) {
        this.members.set(member, role);
    }

    public getMembers(): Member[] {
        let coeMembers = Array.from(this.members.keys());
        return coeMembers;
    }

    public getCOERoleForMember(member: Member): string {
        return this.members.get(member);
    }

}