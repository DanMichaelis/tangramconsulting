import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftandrightclickableitemsComponent } from './leftandrightclickableitems.component';

describe('LeftandrightclickableitemsComponent', () => {
  let component: LeftandrightclickableitemsComponent;
  let fixture: ComponentFixture<LeftandrightclickableitemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftandrightclickableitemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftandrightclickableitemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
