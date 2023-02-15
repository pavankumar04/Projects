import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuseraddbookingComponent } from './buseraddbooking.component';

describe('BuseraddbookingComponent', () => {
  let component: BuseraddbookingComponent;
  let fixture: ComponentFixture<BuseraddbookingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BuseraddbookingComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuseraddbookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
