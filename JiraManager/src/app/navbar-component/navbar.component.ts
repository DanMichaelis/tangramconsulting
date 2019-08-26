import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'navbar-component',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isShowDropdown: Boolean = false;
  selectedOperation: String = '';
  constructor() { }

  ngOnInit() {
  }

  toggleShowDropdown() {
    this.isShowDropdown = !this.isShowDropdown;
  }

  setSelectedOperation(event: Event) {
    console.log(event);
   this.selectedOperation = (<MouseEvent>event).toElement.lastChild.nodeValue;
  }

  clearSelectedOperation() {
    this.selectedOperation = '';
  }

}
