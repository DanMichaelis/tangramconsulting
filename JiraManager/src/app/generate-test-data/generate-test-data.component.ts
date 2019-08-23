import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/Forms';

@Component({
  selector: 'app-generate-test-data',
  templateUrl: './generate-test-data.component.html',
  styleUrls: ['./generate-test-data.component.css']
})
export class GenerateTestDataComponent implements OnInit {

  showPanel = false;
  testIssueCount: Number;
  generatedTestCases: Number = 0;
  generatedTestCasePhrase: String = '0 test cases will be generated';

  constructor() { 
    this.setGeneratedTestCasePhrase(false);
  }

  ngOnInit() {
  }

  setGeneratedTestCasePhrase(isGenerated: Boolean) {
    console.log('isGenerated: ' + isGenerated);
    if (!isGenerated) {
    this.generatedTestCasePhrase =  this.generatedTestCases + ' test cases will be generated';
    } else {
      this.generatedTestCasePhrase =  this.generatedTestCases + ' test cases have been generated';
    }
  }

  generateTestData() {
    this.setGeneratedTestCasePhrase(true);
  }

}
