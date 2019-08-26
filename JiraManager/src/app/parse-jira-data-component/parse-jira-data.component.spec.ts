import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParseJiraDataComponent } from './parse-jira-data.component';

describe('ParseJiraDataComponent', () => {
  let component: ParseJiraDataComponent;
  let fixture: ComponentFixture<ParseJiraDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParseJiraDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParseJiraDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
