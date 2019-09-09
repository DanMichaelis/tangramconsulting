import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GethistorybykeyComponentComponent } from './gethistorybykey-component.component';

describe('GethistorybykeyComponentComponent', () => {
  let component: GethistorybykeyComponentComponent;
  let fixture: ComponentFixture<GethistorybykeyComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GethistorybykeyComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GethistorybykeyComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
