CREATE TABLE DBInsurance (
    customer_id TEXT NOT NULL,
    measurement_date TIMESTAMP NOT NULL,
    distance_traveled DECIMAL NOT NULL,
    region_id TEXT NOT NULL
);

Create Table this_year () Inherits (dbinsurance);

Create Table previous_years () Inherits (dbinsurance);

Create Index this_year_index On this_year (measurement_date);
Create Index previous_years_index On previous_years (measurement_date);

CREATE OR REPLACE FUNCTION year_insert_trigger()
RETURNS TRIGGER AS $$
BEGIN
IF (NEW.measurement_date  >= current_date - 365) THEN
INSERT INTO this_year VALUES (NEW.*);
ELSIF (NEW.measurement_date  < current_date - 365) THEN
INSERT INTO previous_years VALUES (NEW.*);
ELSE
RAISE EXCEPTION 'We are in a time paradox';
END IF;
RETURN NULL;
END;
$$ LANGUAGE
plpgsql;

CREATE  trigger partition_insert before insert on dbinsurance  for each row execute procedure year_insert_trigger();

COPY dbinsurance FROM 'C:\Users\Panagiotis Prattis\Desktop\db2_project_data.csv'
WITH CSV HEADER;


SELECT * FROM this_year