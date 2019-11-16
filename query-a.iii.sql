select
customer_id as client, sum(distance_traveled) as monthly_distance_traveled, to_char(measurement_date, 'YYYY-MM') as month
from dbinsurance
group by client, month
order by client DESC;