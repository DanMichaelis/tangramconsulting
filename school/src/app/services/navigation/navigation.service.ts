import { Injectable } from '@angular/core';
import { NavigationItem } from '../domain/navigationitem';

@Injectable({
    providedIn: 'root'
})
export class NavigationService {

    constructor() { }

    getTopNavigationItems(): NavigationItem[] {
        const items: NavigationItem[] = [new NavigationItem('Mission', 0),
        new NavigationItem('Degrees', 1),
        new NavigationItem('Classes', 2),
        new NavigationItem('Departments', 3),
        new NavigationItem('Faculty', 4),
        new NavigationItem('Students', 5),
        new NavigationItem('Fraternities', 6),
        new NavigationItem('Sororities', 7)];
        /*
                items[0] = new NavigationItem('Mission', 0);
                items[1] = new NavigationItem('Degrees', 1);
                items[2] = new NavigationItem('Departments', 2);
                items[3] = new NavigationItem('Faculty', 3);
                items[4] = new NavigationItem('Students', 4);
                items[5] = new NavigationItem('Fraternities', 5);
                items[6] = new NavigationItem('Sororities', 6);
        */
        return items;
    }
}
