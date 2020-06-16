import { Injectable } from '@angular/core';
import { OrganizationEvent } from '../data objects/organizationevent';
import { UtilityService } from './utility.service';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private events: OrganizationEvent[] = [];

  constructor() {
    const today: Date = new Date();
    let evt = (new OrganizationEvent('2.2.1 Release', 'Delivery of the 2.2.1 release into the production environment')).setDate(new Date(today.getDate() + UtilityService.getRandomInt(10, 1)));
    this.events.push(evt);
    evt = (new OrganizationEvent('Town Hall', 'DSO Town Hall, sponsored by Tom Nicol')).setDate(new Date(today.getDate() + UtilityService.getRandomInt(10, 1)));
    this.events.push(evt);
    evt = (new OrganizationEvent('PIE Day', 'DSO Town Hall, sponsored by Tom Nicol')).setDate(new Date('3/14/2020'));
    this.events.push(evt);
    evt = (new OrganizationEvent('QTR', 'Release review for the quarter')).setDate(new Date(today.getDate() + UtilityService.getRandomInt(10, 1)));
    this.events.push(evt);

  }

  public getEventsByDate(calendarDate: Date): OrganizationEvent[] {
    const returnEvents: OrganizationEvent[] = [];
    for (const evt of this.events) {
      const comparisonDate = new Date(evt.getEventDate().setHours(0, 0, 0, 0));
      if (calendarDate === comparisonDate) {
        returnEvents.push(evt);
      }
    }
    return returnEvents;
  }

  public getAllEvents(): OrganizationEvent[] {
    return this.events;
  }

  public getEventsById(eventId: string): OrganizationEvent[] {
    const returnEvents: OrganizationEvent[] = [];
    for (const evt of this.events) {
      if (evt.getId() === eventId) {
        returnEvents.push(evt);
      }
    }
    return returnEvents;
  }
}

