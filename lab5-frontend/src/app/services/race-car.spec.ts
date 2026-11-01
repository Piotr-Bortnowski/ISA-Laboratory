import { TestBed } from '@angular/core/testing';
import { RaceCar } from './race-car';

describe('RaceCar', () => {
  let service: RaceCar;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RaceCar);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
