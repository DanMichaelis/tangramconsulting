import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  private _msg: String;
  showComponent: Boolean;

  constructor() {
    this._msg = null;
    this.showComponent = false;
  }

  clearError() {
    this.showComponent = false;
  }
  ngOnInit() { }

  set msg(msg: String) {
    this._msg = msg;
    this.showComponent = msg !== null && msg.length > 0;
  }

  get msg(): String { return this._msg; }

}
