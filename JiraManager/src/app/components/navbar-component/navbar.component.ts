import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { MessageBoxComponent } from '../application-message-box-component/message-box/message-box.component';
import { UserMessage } from 'src/app/dataobjects/userMessage/usermessage';


@Component({
  selector: 'app-navbar-component',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isShowDropdown: Boolean = false;
  isErrored: Boolean = false;
  isWarninged: Boolean = false;
  selectedOperation: string = '';
  errorMessage: UserMessage;

  @Output('onOptionSelected') optionSelected = new EventEmitter<{ navItemSelected: string }>();
  @Output('onErrorOccurred') errorOccured = new EventEmitter<{ errorMessage: UserMessage }>();

  @ViewChild(MessageBoxComponent)
  messageBox: MessageBoxComponent;

  constructor() { }

  ngOnInit() {
  }

  toggleShowDropdown() {
    this.isShowDropdown = !this.isShowDropdown;
  }

  setSelectedOperation(event: Event) {
    console.log(event);
    this.selectedOperation = (<MouseEvent>event).toElement.lastChild.nodeValue;
    this.optionSelected.emit({ navItemSelected: this.selectedOperation });
  }

  clearSelectedOperation() {
    this.selectedOperation = '';
  }

  setError(errorMessage: string, severity: string, errorNumber: number, errType: string) {

  }

}
