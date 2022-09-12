import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigitalbookComponent } from './digitalbook.component';

describe('DigitalbookComponent', () => {
  let component: DigitalbookComponent;
  let fixture: ComponentFixture<DigitalbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DigitalbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DigitalbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
