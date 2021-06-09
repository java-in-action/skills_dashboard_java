Create table employees(sysId int primary key, eId varchar(30), name varchar(30),level int, location varchar(20), birthday date);

CREATE TABLE skill (id INT PRIMARY KEY, description VARCHAR(100) NOT NULL);

CREATE TABLE employee_skill (employee_id INT NOT NULL, skill_id INT NOT NULL);
ALTER TABLE employee_skill ADD FOREIGN KEY (employee_id) REFERENCES employees(sysId);
ALTER TABLE employee_skill ADD FOREIGN KEY (skill_id) REFERENCES skill(id);

INSERT INTO skill VALUES (1, 'Leadership'), (2, 'C#'), (3, 'Java'), (4, 'Angular'), (5, 'SQL');
-- Data
insert into employees values (1,'carlos.baez','Baez Carlos',11,'CD-MX','1990-01-01');
insert into employees values (2,'s.coronado.andrad','Coronado Andrade, S.',12,'MTY','1985-06-25');
insert into employees values (3,'g.rodriguez.lozano','Rodriguez Lozano, G.',10,'CDMX','1978-04-14');
insert into employees values (4,'r.sanchez.rojas','Sanchez Rojas, R.',10,'MTY','1996-08-09');
insert into employees values (5,'ivan.albor','Albor, Ivan',9,'USA','1981-03-12');

INSERT INTO employee_skill VALUES (2, 1), (2, 2), (3, 3), (4, 4), (1, 5);

