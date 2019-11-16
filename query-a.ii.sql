select AVG(distance_traveled) as average_distance_traveled
from dbinsurance 
where date_measured  >= current_date - 365