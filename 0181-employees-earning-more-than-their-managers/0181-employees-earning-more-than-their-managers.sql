/* Write your PL/SQL query statement below */
select e.name employee
from employee e
where e.managerid is not null
and (
    select salary
    from employee
    where id = e.managerid
) < salary