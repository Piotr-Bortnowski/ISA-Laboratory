CREATE TABLE racing_classes (id UUID PRIMARY KEY);
CREATE TABLE race_cars (
  id UUID PRIMARY KEY,
  model_name VARCHAR(255),
  start_number INTEGER NOT NULL,
  engine_displacement DOUBLE PRECISION NOT NULL,
  hybrid_powertrain BOOLEAN NOT NULL,
  racing_class UUID REFERENCES racing_classes(id) ON DELETE CASCADE
);