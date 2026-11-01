import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RacingClassList } from './racing-class-list';

describe('RacingClassList', () => {
  let component: RacingClassList;
  let fixture: ComponentFixture<RacingClassList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RacingClassList],
    }).compileComponents();

    fixture = TestBed.createComponent(RacingClassList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
