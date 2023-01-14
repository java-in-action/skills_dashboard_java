CREATE TABLE employees(
   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
   e_id VARCHAR(50) NOT NULL,
   name VARCHAR(30) NOT NULL,
   middle_name VARCHAR(30),
   last_name VARCHAR(100) NOT NULL,
   level INT,
   location VARCHAR(20),
   birthday DATE,
   CONSTRAINT EMPLOYEES_PK PRIMARY KEY (id)
);
 
CREATE TABLE skill(
   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
   short_name VARCHAR(15) NOT NULL,
   name VARCHAR(30) NOT NULL,
   description VARCHAR(100),
   CONSTRAINT SKILLS_PK PRIMARY KEY (id)
);
 
CREATE TABLE employee_skill(
   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
   employee_id BIGINT UNSIGNED NOT NULL,
   skill_id BIGINT UNSIGNED NOT NULL,
   CONSTRAINT EMPLOYEES_SKILLS_PK PRIMARY KEY (employee_id)
);
 
ALTER TABLE employee_skill ADD FOREIGN KEY (employee_id) REFERENCES employees(id);
ALTER TABLE employee_skill ADD FOREIGN KEY (skill_id) REFERENCES skill(id);

-- Data

INSERT INTO employee (id, e_id, name, middle_name, last_name, level, location, birthday)
VALUES
(1,'joe.doe','Joe', null, 'Doe', 11,'CD-MX','1990-01-01'),
(2,'jane.doe','Jane', null, 'Doe', 12,'MTY','1985-06-25');

INSERT INTO skill (id, short_name, name, description)
VALUES
(1, 'Leadership', 'Leadership', null),
(2, 'C#', 'C#', null),
(3, 'Java', 'Java', null),
(4, 'Angular', 'Angular', null),
(5, 'SQL', 'SQL', null);
 
INSERT INTO employee_skill
VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4);