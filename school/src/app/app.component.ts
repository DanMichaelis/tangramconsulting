import { Component } from '@angular/core';
import { HeaderBarComponent } from './navigation/header-bar/header-bar.component';
import { MetricsConversionServiceService } from './services/metrics-conversion-service.service';
import { LayoutService } from './services/layout.service';
import { GridsterLayoutComponent } from './basecomponents/gridster-layout/gridster-layout.component';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})

export class AppComponent {
    private layout: GridsterLayoutComponent;
    title = 'school';


    constructor(layoutService: LayoutService) {
        console.log(MetricsConversionServiceService.convertMetrictWeightToImperial(45));
        console.log(MetricsConversionServiceService.convertImperialWeightToMetric(99, 3.33));
        console.log(MetricsConversionServiceService.convertImperialWeightStringToMetric('99 lbs, 3.33 oz'));
        this.layout = new GridsterLayoutComponent(layoutService);

    }
}
