import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClickableIconComponent } from './clickable-icon.component';

describe('ClickableIconComponent', () => {
  let component: ClickableIconComponent;
  let fixture: ComponentFixture<ClickableIconComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClickableIconComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClickableIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
