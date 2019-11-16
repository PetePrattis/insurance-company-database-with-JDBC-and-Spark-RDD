select
region_id as area, AVG(distance_traveled) as average_distance_traveled
from dbinsurance
group by area
order by area DESC;