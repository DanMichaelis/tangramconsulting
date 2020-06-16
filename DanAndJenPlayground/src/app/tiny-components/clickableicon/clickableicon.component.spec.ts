import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClickableiconComponent } from './clickableicon.component';

describe('ClickableiconComponent', () => {
  let component: ClickableiconComponent;
  let fixture: ComponentFixture<ClickableiconComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClickableiconComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClickableiconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
