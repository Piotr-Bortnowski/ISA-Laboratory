import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RaceCarForm } from './race-car-form';

describe('RaceCarForm', () => {
  let component: RaceCarForm;
  let fixture: ComponentFixture<RaceCarForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RaceCarForm],
    }).compileComponents();

    fixture = TestBed.createComponent(RaceCarForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
