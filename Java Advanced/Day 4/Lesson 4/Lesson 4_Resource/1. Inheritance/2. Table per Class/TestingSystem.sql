-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Employee
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
	id					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,		
    `name`				VARCHAR(50) NOT NULL
);

-- create table 2: Regular_Employee
DROP TABLE IF EXISTS `Regular_Employee`;
CREATE TABLE `Regular_Employee` (
	id					INT UNSIGNED PRIMARY KEY,		
    `name`				VARCHAR(50) NOT NULL,
    `salary`			INT,
	`bonus`				INT,
    FOREIGN KEY (id) REFERENCES `Employee`(id)
);

-- create table 3: Contract_Employee
DROP TABLE IF EXISTS `Contract_Employee`;
CREATE TABLE `Contract_Employee` (
	id					INT UNSIGNED PRIMARY KEY,		
    `name`				VARCHAR(50) NOT NULL,
    pay_per_hour		INT,
    contract_duration	VARCHAR(50),
    FOREIGN KEY (id) REFERENCES `Employee`(id)
);

/*============================== INSERT EMPLOYEE =======================================*/
/*======================================================================================*/
-- Add Employee
INSERT INTO `Employee`	(	`name` 			) 
VALUE
						('tran duc hieu'	),
						('ngo van nam'		),
						('tran van dat'		);
                        
-- Add Regular_Employee
INSERT INTO `Regular_Employee`	(	id	,		`name`		, 	`salary`,	`bonus`	) 
VALUE
								(	1	,	'tran duc hieu'	,	2000	,	100		),
								(	2	,	'ngo van nam'	,	2000	,	100		);
                        
-- Add Contract_Employee
INSERT INTO `Contract_Employee`	(	id	,	`name`, 		pay_per_hour,	contract_duration	) 
VALUE
								(	3	, 'tran van dat'	,		10		,		'3 years'		);
                        
                        
                        