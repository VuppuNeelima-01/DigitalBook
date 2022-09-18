import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadersignupComponent } from './readersignup.component';

describe('ReadersignupComponent', () => {
  let component: ReadersignupComponent;
  let fixture: ComponentFixture<ReadersignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReadersignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadersignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
