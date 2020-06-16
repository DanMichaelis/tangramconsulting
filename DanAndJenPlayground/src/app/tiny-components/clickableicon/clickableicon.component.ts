import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ClickableIcon } from '../DataObjects/clickableicon';

@Component({
  selector: 'app-clickableicon',
  templateUrl: './clickableicon.component.html',
  styleUrls: ['./clickableicon.component.scss']
})
export class ClickableiconComponent implements OnInit {

  // Avatar Parameters
  @Input() icon: ClickableIcon;

  @Output() clickableIconEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }


  public iconClicked(event: Event) {
    this.clickableIconEvent.emit(event);
  }

}
