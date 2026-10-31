import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RacingClassDetails } from './racing-class-details';

describe('RacingClassDetails', () => {
  let component: RacingClassDetails;
  let fixture: ComponentFixture<RacingClassDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RacingClassDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(RacingClassDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
