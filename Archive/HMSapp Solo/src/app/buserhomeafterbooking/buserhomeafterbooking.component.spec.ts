import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuserhomeafterbookingComponent } from './buserhomeafterbooking.component';

describe('BuserhomeafterbookingComponent', () => {
  let component: BuserhomeafterbookingComponent;
  let fixture: ComponentFixture<BuserhomeafterbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BuserhomeafterbookingComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuserhomeafterbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
