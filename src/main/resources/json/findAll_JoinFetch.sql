/*
JPA:

@Query("select DISTINCT e from Employee e join fetch e.projects")
	public List<Employee> findAllJoinFetch();

*/


-- Generated SQL
SELECT employee0_.id          AS id1_0_0_,
       projects1_.id          AS id1_1_1_,
       employee0_.first_name  AS first_na2_0_0_,
       employee0_.last_name   AS last_nam3_0_0_,
       employee0_.salary      AS salary4_0_0_,
       projects1_.employee_id AS employee3_1_1_,
       projects1_.NAME        AS name2_1_1_,
       projects1_.employee_id AS employee3_1_0__,
       projects1_.id          AS id1_1_0__
FROM   emp_tbl employee0_
       INNER JOIN project projects1_
               ON employee0_.id = projects1_.employee_id