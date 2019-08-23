import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  private _msg : String;
  private _show = false;

  constructor() {
	  this._msg = null;
  }

  clearError() {
    this._show = false;
  }
  ngOnInit() {}

  set msg (msg : String) {
    this._msg = msg;
    this._show = true;
  }

  get msg(): String {return this._msg;}

  get show() : Boolean {return this._show}

}
