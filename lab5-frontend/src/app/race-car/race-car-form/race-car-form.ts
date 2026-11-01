import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { RaceCarService } from '../../services/race-car';

@Component({
  selector: 'app-race-car-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './race-car-form.html',
  styleUrl: './race-car-form.css',
})
export class RaceCarForm {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private service = inject(RaceCarService);

  classId = this.route.snapshot.paramMap.get('classId')!;
  carId = this.route.snapshot.paramMap.get('carId');

  form = inject(FormBuilder).nonNullable.group({
    modelName: ['', Validators.required],
    startNumber: [1, [Validators.required, Validators.min(1)]],
    engineDisplacement: [0, [Validators.required, Validators.min(0)]],
    hybridPowertrain: [false],
  });

  constructor() {
    if (this.carId) {
      this.service.get(this.carId)
        .subscribe(car => this.form.patchValue(car));
    }
  }

  save() {
    if (this.form.invalid) return;
    const id = this.carId ?? crypto.randomUUID();
    this.service.put(this.classId, id, this.form.getRawValue()).subscribe(() => 
      this.router.navigate(['/classes', this.classId])
    );
  }
}