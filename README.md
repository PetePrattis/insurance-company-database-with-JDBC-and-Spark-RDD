# A JDBC client Program / Project

**This is a jdbc client project from my early days as a Computer Science student**

_This programm was created for the fifth semester class Database Management Systems 
and is the one of the final projects for the class_

> #### Description of project
>
>>A jdbc application that runs queries in pgAdmin to simulate the functionality of an insurance company's database using Apache Spark RDD for query implementation.

> #### Impementation and Instructions of project
>
> 1. Tip 1: I record the second runtime in order for the buffers to initialize 
> 2. Tip 2: I use the EXPLAIN command for the execution plan 
> 3. Tip 3: I run the queries in sequence so that the changes to buffers, parallelism, etc. continue to be active for the next query
> 4. Insert the data from the given dataset using proper queries and the command VACUUM FULL 
> 5. Implement some functionality using proper queries:
>> a. Find the customer who had the greatest mileage to a specific timestamp<br/>
>> b. Find the average mileage for the last month from all the data<br/>
>> c. Find the monthly sum of mileage for each customer<br/>
>> d. Find the average distance traveled for each customer<br/>
>> e. Find the average mileage per region.<br/>
> 6. Tip 4: Configure PostgreSQL to use more buffer than your computer's RAM with the command ALTER SYSTEM SET shared_buffers TO '256MB';
> 7. Run queries again
> 8. Tip 5: Configure PostgreSQL to use all the processing power of your computer with the command max_parallel_workers_per_gather
> 9. Create the appropriate indexes in the db to run the queries above faster
> 10. Break the dataset into shards / partitions using inheritance between tables using range method
> 11. Connect databse with JDBC client in Java using the proper library
> 12. Write a Java console application that will calculate some statistics, execute a query in Spark and will use the partitioning

> #### About this project
>
> - There is a predetermined dataset used for this project
> - The comments to make the code understandable, are within the archives
> - This project was written in Eclipse Java IDE
> - This repository was created to show the variety of the work I did and experience I gained as a student
>
