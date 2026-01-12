select (
    select d.name
    from department d
    where d.id = e.departmentId
) department, e.name employee, e.salary
from (
    select id, name, salary, departmentId,
    dense_rank() over (partition by departmentId order by salary desc) as rn
    from employee
) e
where rn <= 3;