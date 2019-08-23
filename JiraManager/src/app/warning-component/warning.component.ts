import { Component, OnInit, Input } from '@angular/core';
import { MissingTranslationStrategy } from '@angular/compiler/src/core';

@Component({
  selector: 'app-warning',
  templateUrl: './warning.component.html',
  styleUrls: ['./warning.component.css']
})
export class WarningComponent implements OnInit {
  
  private _msg : String;
  showPanel : Boolean = false;

  constructor() {
    this._msg = null;
    this.showPanel = false;
    console.log("showPanel: " + this.showPanel);
  }

  clearError() {
    this.showPanel = false;
    console.log("showPanel: " + this.showPanel);
  }
  ngOnInit() {}

  set msg (msg : String) {
    this._msg = msg;
    
    if (msg !== null && msg.length > 0) {
      this.showPanel = true;
    } else {
      this.showPanel = false;
    }
    console.log("showPanel: " + this.showPanel);
  }

  get msg(): String {return this._msg;}

}