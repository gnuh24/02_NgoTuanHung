DROP DATABASE `test1`;
CREATE DATABASE `test1`;

USE `test1`;

DROP TABLE IF EXISTS`User`;
CREATE TABLE IF NOT EXISTS`User`(
	`ID` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `fullName` VARCHAR(255),
    `email` VARCHAR(255),
    `password` VARCHAR(255),
    `expinyear` TINYINT UNSIGNED,
	`proSkill` VARCHAR(255),
    `projectID` TINYINT UNSIGNED,
    `role` ENUM("MANAGER", "EMPLOYEE")
);

INSERT INTO `User` 	(`FullName`				, `Email`					, `Password`			, `ExpInYear`		, `ProSkill`		, `ProjectId`		, `Role`) 
VALUES 				('Nguyen Khanh 1'		,'nguyenkhanh1@gmail.com'		, 'abcd1234A'		, NULL				, 'python'			, '1'				, 'EMPLOYEE'),
					('Nguyen Khanh 2'		,'nguyenkhanh2@gmail.com'		, 'abcd1234B'		, NULL				, 'c++'			, '2'				, 'EMPLOYEE'),
					('Nguyen Khanh 3'		,'nguyenkhanh3@gmail.com'		, 'abcd1234B'			, '5'				, NULL				, '2'				, 'MANAGER'),
                    ('Nguyen Khanh 4'		,'nguyenkhanh4@gmail.com'		, 'abcd1234B'			, '10'				, NULL				, '1'				, 'MANAGER'),
                    ('Nguyen Khanh 5'		,'nguyenkhanh5@gmail.com'		, 'abcd1234B'			, '6'				, NULL				, '1'				, 'MANAGER'),
                    ('Nguyen Khanh 6'		,'nguyenkhanh6@gmail.com'		, 'abcd1234B'			, NULL				, 'dev'				, '1'				, 'EMPLOYEE'),
                    ('Nguyen Khanh 7'		,'nguyenkhanh7@gmail.com'		, 'abcd1234B'			, NULL				, 'test'			, '1'				, 'EMPLOYEE'),
                    ('Nguyen Khanh 8'		,'nguyenkhanh8@gmail.com'		, 'abcd1234B'			, NULL				, 'csharp'			, '2'				, 'EMPLOYEE'),
                    ('Nguyen Khanh 9'		,'nguyenkhanh9@gmail.com'		, 'abcd1234B'			, NULL				, 'html'			, '2'				, 'EMPLOYEE'),
                    ('Nguyen Khanh 10'		,'nguyenkhanh10@gmail.com'		, 'abcd1234B'			, NULL				, 'css'				, '2'				, 'EMPLOYEE');

SELECT * FROM User 
WHERE projectid = ?
ORDER BY `role`;

SELECT * FROM User 
WHERE role = "MANAGER";

SELECT * FROM User
WHERE email = ? AND password = ?;