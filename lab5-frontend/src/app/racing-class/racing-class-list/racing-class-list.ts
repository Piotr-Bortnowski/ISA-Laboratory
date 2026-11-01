import { Component, inject, signal } from '@angular/core';
import { RacingClassService } from '../../services/racing-class';
import { RacingClassEntry } from '../../models/racing-class';
import { RouterLink } from '@angular/router';

@Component({
  imports: [RouterLink],
  selector: 'app-racing-class-list',
  styleUrl: './racing-class-list.css',
  templateUrl: './racing-class-list.html'
})
export class RacingClassList {
  racingClassService: RacingClassService = inject(RacingClassService)
  racingClasses = signal<RacingClassEntry[]>([])
  selectedId = signal<string | null>(null);


  constructor() {
      this.load();
  }

  private load() {
    this.racingClassService.getAll().subscribe(response => this.racingClasses.set(response.racingClasses));
  }

  private remove(id: string) {
    this.racingClassService.delete(id).subscribe(() => this.load());
    this.load();
  }


  select(id: string) {
    // clicking the same item again unselects it
    this.selectedId.set(this.selectedId() === id ? null : id);
  }

  removeSelected() {
    const id = this.selectedId();
    if (!id) return;
    this.racingClassService.delete(id).subscribe(() => {
      this.selectedId.set(null);
      this.load();
    });
  }
}
