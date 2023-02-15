import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuserhomeComponent } from './buserhome.component';

describe('BuserhomeComponent', () => {
  let component: BuserhomeComponent;
  let fixture: ComponentFixture<BuserhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BuserhomeComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuserhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
