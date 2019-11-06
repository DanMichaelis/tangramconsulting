import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManuallyPullJiraIssueComponent } from './manually-pull-jira-issue.component';

describe('ManuallyPullJiraIssueComponent', () => {
  let component: ManuallyPullJiraIssueComponent;
  let fixture: ComponentFixture<ManuallyPullJiraIssueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManuallyPullJiraIssueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManuallyPullJiraIssueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
