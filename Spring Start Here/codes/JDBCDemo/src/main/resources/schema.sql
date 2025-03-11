CREATE TABLE exhibits (
                          id INTEGER PRIMARY KEY,
                          name VARCHAR(255),
                          num_acres NUMERIC
);

CREATE TABLE names (
                       id INTEGER PRIMARY KEY,
                       species_id INTEGER,
                       name VARCHAR(255),
                       FOREIGN KEY (species_id) REFERENCES exhibits(id)
);
