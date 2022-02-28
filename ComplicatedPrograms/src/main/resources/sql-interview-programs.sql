select * from employees order by salary desc;
select job_id, avg(salary) from employees group by JOB_ID HAVING count(salary) < 1000 ;
select min(salary) from employees;
select min(salary) from employees;
select count(*) from employees;
select abs(-1009) from employees;
select abs(-9) from dual;
select employee_id, mod(employee_id, 2) from employees;
select upper(first_name) from employees;
select lower(first_name) from employees;
select INITCAP(first_name) from employees;
select first_name, LENGTH(first_name) from employees;
select salary, LENGTH(salary) from employees where length(salary) = 4;
select first_name, LPAD(first_name, 4) from employees;
select first_name, INSTR(first_name,'a') from employees;
select first_name, INSTR(first_name, 2, 2) from employees;
select first_name, substr(first_name,3,4) from employees;
select concat(first_name, last_name) as fullname from employees;
select first_name, trim('n' from first_name) from employees;
select trim('a' from 'aruna') from employees;
select rtrim(first_name, 'n') from employees; 
select ltrim(first_name, 'E') from employees;

-- date related funtions
select hire_date, add_months(hire_date, 2) from employees;
select hire_date, months_between('14-01-2019', sysdate)/12 from employees;
select sysdate, next_day(sysdate, 'Monday') as Monday from employees;
select last_day(sysdate) as lastdate from employees;
select hire_date, to_char(hire_date, 'DD-MON-YY') as lastdate from employees;


SELECT job_id, max(salary) FROM EMPLOYEES group BY job_id having  COUNT(salary)< 10000 order by job_id  ;
SELECT * FROM STUDENTS;
SELECT * FROM DEPARTMENT;
SELECT SALARY FROM employees ORDER BY SALARY DESC;
SELECT MAX(SALARY) FROM employees;
SELECT MIN(SALARY) FROM employees;
SELECT AVG(SALARY) FROM employees;
SELECT COUNT(SALARY) FROM employees;

-- 1. Fine the third highest salary from the Employee table.

SELECT * FROM EMPLOYEES ORDER BY SALARY DESC FETCH FIRST 3 ROWS ONLY;

-- 2. Find the nth highest salary from the table without using TOP/Limit keyword.

SELECT SALARY FROM EMPLOYEES E1 WHERE 4-1 = 
(SELECT COUNT(DISTINCT SALARY) FROM EMPLOYEES E2 WHERE E2.SALARY > E1.SALARY);

-- 3. Find duplicate rows in table. 

SELECT LAST_NAME, COUNT(*)
FROM EMPLOYEES
GROUP BY LAST_NAME
HAVING COUNT(*) > 1;

-- 4. Calculate the even records from a table. 

SELECT * FROM employees WHERE MOD(EMPLOYEE_ID, 1) = 0;

-- 5. Calculate the odd records from a table. 

SELECT * FROM employees WHERE MOD(EMPLOYEE_ID, 2) = 1;

-- 6. Display the first and the last record from the employees table.
SELECT * FROM employees WHERE employee_id = (SELECT MIN(employee_id) FROM employees);
SELECT MIN(employee_id) FROM employees;

-- 7. Display the first and the last record from the employees table.
SELECT * FROM employees WHERE employee_id = (SELECT MAX(employee_id) FROM employees);
SELECT MAX(employee_id) FROM employees;

-- 8. Copy all the rows of the table.
CREATE TABLE EMP_INFO AS SELECT employee_id, FIRST_NAME FROM employees FETCH FIRST 5 ROWS ONLY;
SELECT * FROM emp_info;
DROP TABLE EMP_INFO;
COMMIT;

-- 9. Create empty table as employee.
CREATE TABLE EMP_INFO AS SELECT * FROM employees where 3=4;
SELECT * FROM emp_info;
DROP TABLE EMP_INFO;
COMMIT;

-- 10. Retrive the list of the emploeeys working in the same department. 
SELECT employees.first_name, departments.department_name  FROM employees 
inner JOIN 
departments on employees.employee_id = departments.department_id;
GROUP BY departments.department_id; HAVING COUNT(*) > 1;

-- 11. Select gender from employees as male for female and female for mala and others for others.

SELECT CASE 
    WHEN S_GENDER = 'Male' THEN 'Female' 
    WHEN S_GENDER = 'Female' THEN 'Male'
    ELSE 'Others'
    END  AS S_GENDER, S_NAME FROM STUDENTS; 

-- Innter join

SELECT * FROM STUDENTS S
INNER JOIN DEPARTMENT D
ON s.s_id = D.s_id;


-- Group By
select count(s_name) from students group by s_gender;
















