import { Component, OnInit, Input } from '@angular/core';
import { Member } from 'src/app/data objects/member';
import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';
import { OrganizationEvent } from 'src/app/data objects/organizationevent';
import { Icons } from 'src/app/data objects/constants/icons';
import { TitleAndSubtitle } from 'src/app/tiny-components/DataObjects/titleandsubtitle';
import { EventService } from 'src/app/Services/event.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  private static readonly cardTitle: string = "Events";
  private addEventIcon: ClickableIcon;
  private evtSvc: EventService;
  @Input() private events: OrganizationEvent[];


  constructor(evtSvc: EventService) {
    this.addEventIcon = ClickableIcon.getClassBasedICon('FontAwesome add icon', Icons.add, 'Add Event');
    this.events = evtSvc.getAllEvents();
  }

  ngOnInit(): void {
  }

  public getCardTitle(): TitleAndSubtitle {
    return new TitleAndSubtitle(EventComponent.cardTitle)
  }

  public getCardEditIcon(): ClickableIcon {
    return this.addEventIcon;
  }

  public getEvents(): OrganizationEvent[] {
    return this.events;
  }

  public getEventAvatar(evt: OrganizationEvent): ClickableIcon {
    console.log(evt.getEventDate().getDay());
    return ClickableIcon.getAvatarIcon('Date Icon for ' + evt.getName(),
      null,
      null,
      evt.getEventDate().toLocaleString('default', { month: 'short' }) + '\n' + evt.getEventDate().getDay(),
      null,
      35);
  }

  public getEventTitle(evt: OrganizationEvent): TitleAndSubtitle {
    return new TitleAndSubtitle(evt.getName());
  }

  public getEventIcons(): ClickableIcon[] {
    const icns: ClickableIcon[] = [];
    icns.push(ClickableIcon.getClassBasedICon('Font Awesome Pencil', Icons.edit, 'Edit Event'));
    icns.push(ClickableIcon.getClassBasedICon('Font Awesome Pencil', Icons.trashcan, 'Edit Event'));
    return icns;
  }

}

