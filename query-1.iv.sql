select
customer_id as client, AVG(distance_traveled) as average_distance_traveled
from dbinsurance
group by client
order by client DESC;