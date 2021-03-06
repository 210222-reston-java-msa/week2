DROP TABLE IF EXISTS employeeapp.employee;

CREATE TABLE employeeapp.employee (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	username VARCHAR(50),
	pass_word VARCHAR(50)
);

INSERT INTO employeeapp.employee (first_name, last_name, username, pass_word)
	VALUES ('Timmy', 'Maximoff', 'tmax', 'secret');
	
SELECT * from employeeapp.employee;