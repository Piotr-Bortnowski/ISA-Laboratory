// GET list → GetRaceCarsResponse
export interface RaceCars {
  raceCars: RaceCarEntry[];
}

export interface RaceCarEntry {
  id: string;
  modelName: string;
}

// GET single → GetRaceCarResponse
export interface RaceCar {
  id: string;
  modelName: string;
  startNumber: number;
  engineDisplacement: number;
  hybridPowertrain: boolean;
  racingClass: { id: string };
}

// PUT body → PutRaceCarRequest
export interface RaceCarRequest {
  modelName: string;
  startNumber: number;
  engineDisplacement: number;
  hybridPowertrain: boolean;
}