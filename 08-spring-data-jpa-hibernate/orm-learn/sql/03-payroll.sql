-- Doc 2, Hands-on 3: payroll schema for one-to-many / many-to-many mappings.
USE ormlearn;

CREATE TABLE IF NOT EXISTS department (
    dp_id INT NOT NULL AUTO_INCREMENT,
    dp_name VARCHAR(50),
    PRIMARY KEY (dp_id)
);

CREATE TABLE IF NOT EXISTS employee (
    em_id INT NOT NULL AUTO_INCREMENT,
    em_name VARCHAR(50),
    em_salary DOUBLE,
    em_permanent BIT,
    em_date_of_birth DATE,
    em_dp_id INT,
    PRIMARY KEY (em_id),
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE IF NOT EXISTS skill (
    sk_id INT NOT NULL AUTO_INCREMENT,
    sk_name VARCHAR(50),
    PRIMARY KEY (sk_id)
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

INSERT INTO department (dp_name) VALUES ('Engineering'), ('Finance'), ('HR');
INSERT INTO skill (sk_name) VALUES ('Java'), ('SQL'), ('Spring');
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
    VALUES ('Alice', 90000, 1, '1990-05-01', 1),
           ('Bob', 75000, 0, '1992-08-15', 2),
           ('Carol', 82000, 1, '1988-11-30', 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1,1),(1,3),(3,2);
