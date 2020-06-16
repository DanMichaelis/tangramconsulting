import { ClickableIcon } from '../tiny-components/DataObjects/clickableicon';
import { Squad } from './squad';
import { COE } from './coe';
import { Member } from './member';

export class Tribe {
    private name: string;
    private type: string;
    private icon: ClickableIcon;
    private mission: string;
    private squads: Squad[] = [];
    private coes: COE[] = [];
    private leadership: Member[] = [];

    constructor(name: string, type?: string) {
        this.name = name;
        if (type) { this.type = type; }
    }

    public setName(name: string): Tribe {
        this.name = name;
        return this;
    }

    public getName(): string {
        return this.name;
    }

    public setType(type: string): Tribe {
        this.type = type;
        return this;
    }

    public getType(): string {
        return this.type;
    }

    public setIcon(icon: ClickableIcon): Tribe {
        this.icon = icon;
        return this;
    }

    public getIcon(): ClickableIcon {
        return this.icon;
    }

    public setMission(mission: string): Tribe {
        this.mission = mission;
        return this;
    }

    public setSquads(squads: Squad[]): Tribe {
        this.squads = squads;
        return this;
    }

    public addSquad(squad: Squad): Tribe {
        if (!this.squads) {
            this.squads = [];
        }
        this.squads.push(squad);
        return this;
    }

    public getSquads(): Squad[] {
        return this.squads;
    }

    public setCOEs(coes: COE[]): Tribe {
        if (!this.coes) {
            this.coes = []
        }
        this.coes = coes;
        return this
    }

    public addCOE(coe: COE): Tribe {
        this.coes.push(coe);
        return this;
    }

    public getCOEs(): COE[] {
        return this.coes;
    }

    public addLeader(member: Member, role: string): Tribe {
        member.setRole('Tribe:' + this.getName, role);
        return this;
    }

    public getLeaders(): Member[] {
        return this.leadership;
    }
}