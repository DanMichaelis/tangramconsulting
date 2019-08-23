import { Component, ViewChild } from '@angular/core';
import { ErrorComponent } from './error-component/error.component';
import {WarningComponent} from './warning-component/warning.component';
import { GenerateTestDataComponent } from './generate-test-data/generate-test-data.component';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {
	title = 'JiraManager';
	isError = false;
    isWarning = false;
    isShowDropdown = false;
	ec = new ErrorComponent();

	@ViewChild(ErrorComponent) 
	private errorComponent : ErrorComponent;
	
	@ViewChild(WarningComponent)
	private warningComponent : WarningComponent;

	@ViewChild(GenerateTestDataComponent)
	private generateTestDataComponent : GenerateTestDataComponent;

	toggleErrorMessage(msg: String) {
		this.isError = !this.isError;
		console.log('Error message is set: ' + this.isError)
		if (this.isError) {
			this.errorComponent.msg = msg;
		} else {
			this.errorComponent.msg = null;
		}
	}

	toggleWarningMessage(msg: String) {
		this.isWarning = msg !== null && msg.length > 0;
		console.log('Warning message is set: ' + this.isWarning);
		if (this.isWarning) {
			this.warningComponent.msg = msg;
		} else {
			this.warningComponent.msg = null;
		}
	}
	
	manuallyPullIssueData(event: Event) {
		console.log(event);
		if ((<MouseEvent>event).toElement.lastChild.nodeValue === 'Generate Test Data') {

		}
		this.toggleWarningMessage((<MouseEvent>event).toElement.lastChild.nodeValue + ' was clicked');
	}
    
    toggleShowDropdown() {
        this.isShowDropdown = !this.isShowDropdown;
    }
}
