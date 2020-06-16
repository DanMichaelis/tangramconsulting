import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SummarycardrowComponent } from './summarycardrow.component';

describe('SummarycardrowComponent', () => {
  let component: SummarycardrowComponent;
  let fixture: ComponentFixture<SummarycardrowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SummarycardrowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SummarycardrowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
