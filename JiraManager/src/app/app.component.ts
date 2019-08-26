import { Component, ViewChild } from '@angular/core';
import { ErrorComponent } from './error-component/error.component';
import { WarningComponent } from './warning-component/warning.component';
import { GenerateTestDataComponent } from './generate-test-data/generate-test-data.component';
import { NavbarComponent } from './navbar-component/navbar.component';

@Component({

	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'JiraManager';
	isError = false;
	isWarning = false;


	@ViewChild(ErrorComponent)
	private errorComponent: ErrorComponent;

	@ViewChild(WarningComponent)
	private warningComponent: WarningComponent;

	@ViewChild(NavbarComponent)
	private navbarComponent: NavbarComponent;

	@ViewChild(GenerateTestDataComponent)
	private generateTestDataComponent: GenerateTestDataComponent;

	getSelectedComponent() : String {
		return this.navbarComponent.selectedOperation;
	}




}
