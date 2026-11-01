import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { RaceCar, RaceCarRequest, RaceCars } from '../models/race-car';

@Service()
export class RaceCarService {
    private apiUrl = '/api/racing-classes';
    private http = inject(HttpClient);

    getAllByClass(classId: string): Observable<RaceCars> {
        return this.http.get<RaceCars>(`${this.apiUrl}/${classId}/race-cars`);
    }

    get(id: string): Observable<RaceCar> {
        return this.http.get<RaceCar>(`/api/race-cars/${id}`);
    }

    put(classId: string, id: string, request: RaceCarRequest): Observable<void> {
        return this.http.put<void>(`${this.apiUrl}/${classId}/race-cars/${id}`, request);
    }

    delete(id: string): Observable<void> {
        return this.http.delete<void>(`/api/race-cars/${id}`);
    }
}