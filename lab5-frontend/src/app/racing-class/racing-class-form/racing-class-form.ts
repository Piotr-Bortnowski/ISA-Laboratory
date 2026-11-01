import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { RacingClassService } from '../../services/racing-class';
import { FormBuilder, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  imports: [RouterLink, ReactiveFormsModule],
  selector: 'app-racing-class-form',
  styleUrl: './racing-class-form.css',
  templateUrl: './racing-class-form.html',
})
export class RacingClassForm {
  router: Router = inject(Router);
  racingClassService: RacingClassService = inject(RacingClassService);
  form = inject(FormBuilder).nonNullable.group({
    name: ['', Validators.required],
    maxHorsepower: [0, [Validators.required, Validators.min(1)]],
    minWeight: [0, [Validators.required, Validators.min(1)]],
  });

  newUUID: string|null = null;

  private route = inject(ActivatedRoute)
  classId = this.route.snapshot.paramMap.get('classId')

  constructor() {
    if (this.classId) {
      this.racingClassService.get(this.classId).subscribe(rc => this.form.patchValue(rc));
    }
  }

  private save() {
    if (this.form.invalid) {
      return
    }

    const id = this.classId ?? crypto.randomUUID();
    this.racingClassService.put(id, this.form.getRawValue()).subscribe(() => this.router.navigate(['/classes']))
  }
}
