import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs';
import { RacingClass, RacingClasses, RacingClassRequest } from '../models/racing-class';

@Service()
export class RacingClassService {
    private apiUrl = '/api/racing-classes';
    private http = inject(HttpClient);

    getAll(): Observable<RacingClasses> {
        return this.http.get<RacingClasses>(this.apiUrl);
    }

    get(classId: string): Observable<RacingClass> {
        return this.http.get<RacingClass>(`${this.apiUrl}/${classId}`);
    }

    put(classId: string, request: RacingClassRequest): Observable<void> {
        return this.http.put<void>(`${this.apiUrl}/${classId}`, request);
    }

    delete(classId: string): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${classId}`);
    }
}