select customer_id
from dbinsurance
where measurement_date >= current_date - 365
and distance_traveled = (select max(distance_traveled) from dbinsurance)

