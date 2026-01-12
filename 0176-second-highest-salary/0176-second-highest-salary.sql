select max(salary) SecondHighestSalary
from employee e
where (
    select count(distinct salary)
    from employee e2
    where e2.salary >= e.salary
) = 2
order by e.salary