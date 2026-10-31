import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RaceCarDetails } from './race-car-details';

describe('RaceCarDetails', () => {
  let component: RaceCarDetails;
  let fixture: ComponentFixture<RaceCarDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RaceCarDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(RaceCarDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
