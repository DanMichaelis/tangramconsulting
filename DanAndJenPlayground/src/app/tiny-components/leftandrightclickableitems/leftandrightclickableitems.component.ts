import { Component, OnInit, Input } from '@angular/core';
import { ClickableIcon } from '../DataObjects/clickableicon';
import { DemoAvatars } from 'src/app/data objects/demo objects/demoavatars';

@Component({
  selector: 'app-leftandrightclickableitems',
  templateUrl: './leftandrightclickableitems.component.html',
  styleUrls: ['./leftandrightclickableitems.component.scss']
})
export class LeftandrightclickableitemsComponent implements OnInit {

  @Input() private leftClickableIcon: ClickableIcon = DemoAvatars.addIcon;
  @Input() private rightClickableIcon: ClickableIcon = DemoAvatars.editIcon;

  constructor() {
  }

  public getLeftIcon(): ClickableIcon {
    return this.leftClickableIcon;
  }

  public getRightIcon(): ClickableIcon {
    return this.rightClickableIcon;
  }

  ngOnInit(): void {
  }

}
