import { TestBed } from '@angular/core/testing';
import { RacingClass } from './racing-class';

describe('RacingClass', () => {
  let service: RacingClass;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RacingClass);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
