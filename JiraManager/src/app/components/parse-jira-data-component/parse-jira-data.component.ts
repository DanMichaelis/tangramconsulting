import { Component, OnInit } from '@angular/core';
import { AngularWaitBarrier } from 'blocking-proxy/built/lib/angular_wait_barrier';
import { element } from '@angular/core/src/render3';

@Component({
  selector: 'app-parse-jira-data',
  templateUrl: './parse-jira-data.component.html',
  styleUrls: ['./parse-jira-data.component.css']
})
export class ParseJiraDataComponent implements OnInit {

  inputFiles: Array<File> = [];
  inputFileMessage: string = 'No file selected';
  showPanel: Boolean = false;

  constructor() { }

  ngOnInit() {
  }


  handleFileInput(files: FileList) {

    Array.from(files).forEach(item => {
      this.inputFiles.push(item);
    })

    this.inputFiles.forEach(item => {
      console.log(item.name);
    })
  }

  updateInputFile(isUpdated: Boolean) {
  }
}
