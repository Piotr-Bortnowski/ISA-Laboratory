import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RacingClassForm } from './racing-class-form';

describe('RacingClassForm', () => {
  let component: RacingClassForm;
  let fixture: ComponentFixture<RacingClassForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RacingClassForm],
    }).compileComponents();

    fixture = TestBed.createComponent(RacingClassForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
