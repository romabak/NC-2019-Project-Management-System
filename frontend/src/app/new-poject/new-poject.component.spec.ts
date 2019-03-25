import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPojectComponent } from './new-poject.component';

describe('NewPojectComponent', () => {
  let component: NewPojectComponent;
  let fixture: ComponentFixture<NewPojectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPojectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPojectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
