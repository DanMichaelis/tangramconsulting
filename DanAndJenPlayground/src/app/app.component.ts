import { Component } from '@angular/core';
import { Tribe } from './data objects/tribe';
import { ClickableIcon } from './tiny-components/DataObjects/clickableicon';
import { Member } from './data objects/member';
import { Squad } from './data objects/squad';
import { DemoMembers } from './data objects/demo objects/demomembers';
import { DemoSquads } from './data objects/demo objects/demosquads';
import { ThreesummarycardwithaddandeditcontentComponent } from './large-components/threesummarycardwithaddandeditcontent/threesummarycardwithaddandeditcontent.component';
import { LeftAndRightClickableItems } from './tiny-components/DataObjects/leftandrightclickableitems';
import { DemoAvatars } from './data objects/demo objects/demoavatars';
import { SummaryCard } from './large-components/DataObjects/summarycard';
import { TitleAndSubtitle } from './tiny-components/DataObjects/titleandsubtitle';
import { SummaryCardRow } from './large-components/DataObjects/summarycardrow';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  tribes: Tribe[] = [];
  tribePointer: number;
  display: ThreesummarycardwithaddandeditcontentComponent;
  avatar: ClickableIcon = DemoAvatars.femaleAvatar;

  constructor() {
    this.tribePointer = 0;

    let tribe = new Tribe('First Tribe');
    tribe.setIcon(DemoAvatars.tribeIcon.setSize(60)).setName('Business Transformation Office').setType('Support Tribe');
    tribe.addLeader(DemoMembers.Keshma, 'Product Owner').addLeader(DemoMembers.Dan, 'Lead Developer');
    tribe.addSquad(DemoSquads.squad1).addSquad(DemoSquads.squad2).addSquad(DemoSquads.squad3);
    this.tribes.push(tribe);

    tribe = new Tribe('Second Tribe');
    tribe.setIcon(DemoAvatars.tribeIcon).setName('Production Tribe').setType('Product Tribe');
    tribe.addLeader(DemoMembers.Sam, 'Product Owner').addLeader(DemoMembers.Jen, 'Scrum Master');
    tribe.addSquad(DemoSquads.squad1).addSquad(DemoSquads.squad2).addSquad(DemoSquads.squad3).addSquad(DemoSquads.squad4).addSquad(DemoSquads.squad5);
    this.tribes.push(tribe);

    tribe = new Tribe('Third Tribe');
    tribe.setIcon(DemoAvatars.tribeIcon).setName('Global Trade Repository').setType('Delivery Tribe')
    tribe.addSquad(DemoSquads.squad1).addSquad(DemoSquads.squad2).addSquad(DemoSquads.squad3).addSquad(DemoSquads.squad4);
    this.tribes.push(tribe);
  }

  ngOnInit() {

  }

  AppComponent() {
  }

  public getNextTribe() {
    if (this.tribePointer == (this.tribes.length - 1)) {
      return this.tribes[this.tribePointer];
    } else {
      this.tribePointer++;
      return this.tribes[this.tribePointer];
    }
  }

  public getPreviousTribe() {
    if (this.tribePointer == 0) {
      return this.tribes[this.tribePointer];
    } else {
      this.tribePointer--;
      return this.tribes[this.tribePointer];
    }
  }

  public getLeftAndRightEditButtons(): LeftAndRightClickableItems {
    let bar = new LeftAndRightClickableItems(DemoAvatars.addIcon, DemoAvatars.editIcon);
    return bar;

  }

  public getTribeIcon(): ClickableIcon {
    return this.tribes[this.tribePointer].getIcon();
  }

  public getTribeNameAndType(): TitleAndSubtitle {
    return new TitleAndSubtitle(this.tribes[this.tribePointer].getName(), this.tribes[this.tribePointer].getType());
  }

  public createSummaryCardForTribeSquad(squad: Squad): SummaryCard {
    let cardClickableIcon = squad.getAvatar();
    let cardTitleAndSubtitle = new TitleAndSubtitle(squad.getName(), squad.getType());
    let cardEditIcon = DemoAvatars.editIcon;
    let cardRow: SummaryCardRow = null;
    let cardRows: SummaryCardRow[] = [];
    let cardRowCounter: number = 0;
    for (let member of squad.getMembers()) {
      cardRowCounter++;
      let cardRow = this.createSummaryCardRowForTribeSquadMember(member, squad);
      cardRows.push(cardRow);
    }
    return new SummaryCard(cardClickableIcon, cardTitleAndSubtitle, cardEditIcon, cardRows);

  }

  public createSummaryCardRowForTribeSquadMember(member: Member, squad: Squad): SummaryCardRow {
    let rowTitle = new TitleAndSubtitle(member.getFullName(), squad.getSquadRoleForMember(member));
    let rowActions: ClickableIcon[] = [DemoAvatars.emailIcon, DemoAvatars.skypeIcon, DemoAvatars.pencilIcon];
    if (member.getFirstName()=='Daniel') {
      rowActions.push(DemoAvatars.diamondIcon);
    }
    return new SummaryCardRow(rowTitle, rowActions);
  }

  public getSummaryCards(): SummaryCard[] {
    let cards: SummaryCard[] = [];
    console.log('Getting squads for tribe ' + this.tribes[this.tribePointer].getName());
    for (let squad of this.tribes[this.tribePointer].getSquads()) {
      cards.push(this.createSummaryCardForTribeSquad(squad));
    }
    return cards;
  }

  public setDisplay() {

  }

}
