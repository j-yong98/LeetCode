select (select d.name from department d where d.id = e.departmentId) department, e.name employee, e.salary
from (
    select departmentId, name, salary,
    dense_rank() over (partition by departmentId order by salary desc) dr
    from Employee
) e
where dr <= 3;