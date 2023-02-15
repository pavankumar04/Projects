import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreslistComponent } from './storeslist.component';

describe('StoreslistComponent', () => {
  let component: StoreslistComponent;
  let fixture: ComponentFixture<StoreslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoreslistComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StoreslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
