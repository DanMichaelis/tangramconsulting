import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  private _msg: String;
  showPanel: Boolean;

  constructor() {
    this._msg = null;
    this.showPanel = false;
  }

  clearError() {
    this.showPanel = false;
  }
  ngOnInit() { }

  set msg(msg: String) {
    this._msg = msg;
    this.showPanel = msg !== null && msg.length > 0;
  }

  get msg(): String { return this._msg; }

}
