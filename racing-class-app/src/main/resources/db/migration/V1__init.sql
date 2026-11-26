CREATE TABLE racing_classes (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  max_horsepower INTEGER NOT NULL,
  min_weight INTEGER NOT NULL
);