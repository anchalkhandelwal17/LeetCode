# Write your MySQL query statement below
select product_id, year as first_year , quantity, price 
from Sales where (product_id, year) in
(select product_id, min(year) as year from Sales group by product_id);

-- first subquery will run 
-- it will group by products based on Ids from sales table
-- then it will select product_id, min year from all the groups

-- After that main query will run
-- it will select all those records having product_id, year 
-- same as subquery result