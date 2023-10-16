DROP DATABASE IF EXISTS `FinalExam`;
CREATE DATABASE IF NOT EXISTS `FinalExam`;


USE `FinalExam`;


-- _______________________________________________________________________________CREATE TABLE____________________________________________________________________
DROP TABLE IF EXISTS`User`;
CREATE TABLE IF NOT EXISTS`User`(
	`ID` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `fullName` VARCHAR(255),
    `email` VARCHAR(255),
    `password` VARCHAR(255),
    `expinyear` TINYINT UNSIGNED,
	`proSkill` VARCHAR(255),
    `projectID` TINYINT UNSIGNED,
    `role` ENUM("MANAGER", "EMPLOYEE", "ADMIN")
);


-- ________________________________________________________________INSERT DATA______________________________________________________________________________
INSERT INTO `User` 	(`FullName`				, `Email`					, `Password`			, `ExpInYear`		, `ProSkill`		, `ProjectId`		, `Role`) 
VALUES 				('Ngo Tuan Hung 1'		,'hungnt1@gmail.com'		, '123456789'		, NULL				, NULL				, '1'				, 'ADMIN'),
					('Ngo Tuan Hung 2'		,'hungnt2@gmail.com'		, '123456789'	, NULL				, NULL				, '2'				, 'ADMIN'),
					('Ngo Tuan Hung 3'			,'hungnt3@gmail.com'		, '123456789'			, '5'				, NULL				, '2'				, 'MANAGER'),
                    ('Ngo Tuan Hung 4'		,'hungnt4@gmail.com'		, '123456789'		, '10'				, NULL				, '1'				, 'MANAGER'),
                    ('Ngo Tuan Hung 5'			,'hungnt5@gmail.com'		, '123456789'			, '6'				, NULL				, '1'				, 'MANAGER'),
                    ('Ngo Tuan Hung 6'		,'hungnt6@gmail.com'	,'123456789'			, NULL				, 'dev'				, '1'				, 'EMPLOYEE'),
                    ('Ngo Tuan Hung 7'			,'hungnt7@gmail.com'		, '123456789'			, NULL				, 'test'			, '1'				, 'EMPLOYEE'),
                    ('Ngo Tuan Hung 8'			,'hungnt8@gmail.com'		, '123456789'			, NULL				, 'csharp'			, '2'				, 'EMPLOYEE'),
                    ('Ngo Tuan Hung 9'		,'hungnt9@gmail.com'		, '123456789'			, NULL				, 'html'			, '2'				, 'EMPLOYEE'),
                    ('Ngo Tuan Hung 10'		,'hungnt10@gmail.com'		, '123456789'			, NULL				, 'css'				, '2'				, 'EMPLOYEE');
             
             
               
