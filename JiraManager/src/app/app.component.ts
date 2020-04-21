import { Component, ViewChild } from '@angular/core';
import { NavbarComponent } from './components/navbar-component/navbar.component';
import { GenerateTestDataComponent } from './components/generate-test-data/generate-test-data.component';
import { GethistorybykeyComponent } from './components/gethistorybykey-component/gethistorybykey.component';
import { MessageBoxComponent } from './components/application-message-box-component/message-box/message-box.component';
import { UserMessage } from './dataobjects/userMessage/usermessage';


@Component({

	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'JiraManager';
	isError = false;
	isWarning = false;

	@ViewChild(NavbarComponent)
	private navbarComponent: NavbarComponent;

	getSelectedComponent(): string {
		return this.navbarComponent.selectedOperation;
	}

}
