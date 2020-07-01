import { Component, OnInit } from '@angular/core';
import { GridsterConfig, GridsterItem } from 'angular-gridster2';
import { LayoutService } from '../../services/layout.service';

@Component({
    selector: 'app-gridster-layout',
    templateUrl: './gridster-layout.component.html',
    styleUrls: ['./gridster-layout.component.scss']
})
export class GridsterLayoutComponent implements OnInit {
    get options(): GridsterConfig {
        return this.layoutService.options;
    }
    get layout(): GridsterItem[] {
        return this.layoutService.layout;
    }
    constructor(
        public layoutService: LayoutService) { }
    ngOnInit() { }
}
