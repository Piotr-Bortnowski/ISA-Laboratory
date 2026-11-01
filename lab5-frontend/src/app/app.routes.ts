import { Routes } from '@angular/router';
import { RacingClassList } from './racing-class/racing-class-list/racing-class-list';
import { RacingClassForm } from './racing-class/racing-class-form/racing-class-form';
import { RacingClassDetails } from './racing-class/racing-class-details/racing-class-details';
import { RaceCarForm } from './race-car/race-car-form/race-car-form';
import { RaceCarDetails } from './race-car/race-car-details/race-car-details';

export const routes: Routes = [
    { path: '', redirectTo: 'classes', pathMatch: 'full' },
    { path: 'classes', component: RacingClassList },
    { path: 'classes/new', component: RacingClassForm },
    { path: 'classes/:classId/edit', component: RacingClassForm },
    { path: 'classes/:classId', component: RacingClassDetails },
    { path: 'classes/:classId/cars/new', component: RaceCarForm },
    { path: 'classes/:classId/cars/:carId/edit', component: RaceCarForm },
    { path: 'classes/:classId/cars/:carId', component: RaceCarDetails }
];
