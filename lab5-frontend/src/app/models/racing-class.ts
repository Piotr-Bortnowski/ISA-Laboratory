// GET list → GetRacingClassesResponse
export interface RacingClasses {
  racingClasses: RacingClassEntry[];
}

export interface RacingClassEntry {
  id: string;
  name: string;
}

// GET single → GetRacingClassResponse
export interface RacingClass {
  id: string;
  name: string;
  maxHorsepower: number;
  minWeight: number;
}

// PUT body → PutRacingClassRequest
export interface RacingClassRequest {
  name: string;
  maxHorsepower: number;
  minWeight: number;
}