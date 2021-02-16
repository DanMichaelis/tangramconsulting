import { Component, OnInit } from '@angular/core';
import { NavigationService } from '../../../services/navigation/navigation.service';
import { NavigationItem } from '../../../services/domain/navigationitem';
import { GridsterConfig, GridsterItem } from 'angular-gridster2';



@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
    options: GridsterConfig;
    public menuItems: NavigationItem[];
    navService: NavigationService;
    constructor(navService: NavigationService) {
        this.menuItems = navService.getTopNavigationItems();
    }

    ngOnInit(): void {
    }

}
