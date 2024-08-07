# Write your MySQL query statement below
select customer_id from Customer group by customer_id 
having count(distinct(product_key)) =
(select count(product_key) from Product);

-- first subquery will execute
-- and total count of product_key will get calculated

-- after that outer query will run
-- first customer records will be grouped by customer_id
-- then all those groups having distinct count of product_key
-- will get filtered 
-- at last select statement will select all those filtered out customer Ids