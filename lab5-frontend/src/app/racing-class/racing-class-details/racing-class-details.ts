import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Router } from '@angular/router';
import { RacingClassService } from '../../services/racing-class';
import { RacingClass } from '../../models/racing-class';
import { RaceCarEntry } from '../../models/race-car';
import { RaceCarService } from '../../services/race-car';

@Component({
  imports: [RouterLink],
  selector: 'app-racing-class-details',
  styleUrl: './racing-class-details.css',
  templateUrl: './racing-class-details.html',
})
export class RacingClassDetails {
  router: Router = inject(Router);
  racingClassService: RacingClassService = inject(RacingClassService);
  raceCarService: RaceCarService = inject(RaceCarService);

  private route = inject(ActivatedRoute)
  classId = this.route.snapshot.paramMap.get('classId')
  racingClass = signal<RacingClass|null>(null);
  classCars = signal<RaceCarEntry[]>([]);

  selectedCarId = signal<string | null>(null);

  selectCar(id: string) {
    // clicking the same item again unselects it
    this.selectedCarId.set(this.selectedCarId() === id ? null : id);
  }

  load() {
    if (this.classId) {
      this.racingClassService.get(this.classId).subscribe(rc => this.racingClass.set(rc));
      this.raceCarService.getAllByClass(this.classId).subscribe(respone => this.classCars.set(respone.raceCars));
    }
  }

  constructor() {
    this.load();
  }

  removeSelectedCar() {
    const id = this.selectedCarId();
    if (!id) return;

    this.raceCarService.delete(id).subscribe(() => {
      this.selectedCarId.set(null);
      this.load();
    });
  }

}
