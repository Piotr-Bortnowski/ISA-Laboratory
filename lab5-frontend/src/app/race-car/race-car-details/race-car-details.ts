import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { RaceCarService } from '../../services/race-car';
import { RacingClassService } from '../../services/racing-class';
import { RaceCar } from '../../models/race-car';
import { RacingClass } from '../../models/racing-class';

@Component({
  selector: 'app-race-car-details',
  imports: [RouterLink],
  templateUrl: './race-car-details.html',
  styleUrl: './race-car-details.css',
})
export class RaceCarDetails {
  private route = inject(ActivatedRoute);
  private raceCarService = inject(RaceCarService);
  private racingClassService = inject(RacingClassService);

  classId = this.route.snapshot.paramMap.get('classId')!;
  carId = this.route.snapshot.paramMap.get('carId')!;

  raceCar = signal<RaceCar | null>(null);
  racingClass = signal<RacingClass | null>(null);

  constructor() {
    this.raceCarService.get(this.carId)
      .subscribe(car => this.raceCar.set(car));
    // load the class too, to show its name instead of just an id
    this.racingClassService.get(this.classId)
      .subscribe(rc => this.racingClass.set(rc));
  }
}