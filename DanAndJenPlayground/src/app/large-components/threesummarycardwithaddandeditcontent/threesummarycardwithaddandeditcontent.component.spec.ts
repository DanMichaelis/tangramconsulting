import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThreesummarycardwithaddandeditcontentComponent } from './threesummarycardwithaddandeditcontent.component';

describe('ThreesummarycardwithaddandeditcontentComponent', () => {
  let component: ThreesummarycardwithaddandeditcontentComponent;
  let fixture: ComponentFixture<ThreesummarycardwithaddandeditcontentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThreesummarycardwithaddandeditcontentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThreesummarycardwithaddandeditcontentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
