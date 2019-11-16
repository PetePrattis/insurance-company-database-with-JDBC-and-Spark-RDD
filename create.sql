CREATE TABLE DBInsurance (
    customer_id TEXT NOT NULL,
    measurement_date TIMESTAMP NOT NULL,
    distance_traveled DECIMAL NOT NULL,
    region_id TEXT NOT NULL
);

COPY DBinsurance FROM 'C:\Users\Panagiotis Prattis\Desktop\db2_project_data.csv'
WITH CSV HEADER;