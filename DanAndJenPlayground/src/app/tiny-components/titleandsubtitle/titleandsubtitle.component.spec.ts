import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TitleandsubtitleComponent } from './titleandsubtitle.component';

describe('TitleandsubtitleComponent', () => {
  let component: TitleandsubtitleComponent;
  let fixture: ComponentFixture<TitleandsubtitleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TitleandsubtitleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TitleandsubtitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
