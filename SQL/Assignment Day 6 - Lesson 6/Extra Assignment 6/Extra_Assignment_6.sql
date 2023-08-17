-- CREATE DATABASE `Extra_Assignment_6`;
USE `Extra_Assignment_6`;
/*________________________________________________________________________QUERY________________________________________________________________________________________ */
-- a) Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào mỗi table trên

DROP TABLE IF EXISTS `Employees`;
CREATE TABLE IF NOT EXISTS `Employees`(
	`EmployeeID` TINYINT PRIMARY KEY AUTO_INCREMENT,
    `EmployeeLastName` NVARCHAR(50),
	`EmployeeFirstName` NVARCHAR(50),
    `EmployeeHireDate` DATE NOT NULL,
    `EmployeeStatus` NVARCHAR(50) NOT NULL,
    `SupervisorID` TINYINT NOT NULL,
    `SocialSecurityNumber` INT NOT NULL,
FOREIGN KEY ( `SupervisorID`) REFERENCES `Employees`(`EmployeeID`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Projects`;
CREATE TABLE IF NOT EXISTS `Projects`(
	`ProjectID` TINYINT PRIMARY KEY AUTO_INCREMENT,
    `ManagerID` TINYINT NOT NULL,
	`ProjectName` NVARCHAR(50) NOT NULL,
    `ProjectStartDate` DATE NOT NULL,
    `ProjectDescription` TEXT ,
    `ProjectDetails` TEXT,
    `ProjectCompletedOn` DATE NOT NULL,
FOREIGN KEY ( `ManagerID`) REFERENCES `Employees`(`EmployeeID`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `ProjectModules`;
CREATE TABLE IF NOT EXISTS `ProjectModules`(
	`ModuleID` TINYINT PRIMARY KEY,
    `ProjectID` TINYINT NOT NULL,
	`EmployeeID` TINYINT NOT NULL,
    `ProjectModuleDate` DATE NOT NULL,
    `ProjectModuleDescription` TEXT ,
    `ProjectModuleCompletedOn` DATE NOT NULL,
FOREIGN KEY (`EmployeeID`) REFERENCES `Employees`(`EmployeeID`) ON DELETE CASCADE,
FOREIGN KEY ( `ProjectID`) REFERENCES  `Projects`( `ProjectID`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `WorkDone`;
CREATE TABLE IF NOT EXISTS `WorkDone`(
	`WorkDoneID` TINYINT PRIMARY KEY AUTO_INCREMENT,
    `EmployeeID` TINYINT NOT NULL,
    `ModuleID` TINYINT NOT NULL,
    `WorkDoneDate` DATE NOT NULL,
	`WorkDoneDescription` TEXT,
    `WorkDoneStatus` NVARCHAR(20),
FOREIGN KEY (`EmployeeID`) REFERENCES `Employees`(`EmployeeID`) ON DELETE CASCADE,
FOREIGN KEY ( `ModuleID`) REFERENCES  `ProjectModules`( `ModuleID`) ON DELETE CASCADE
);

INSERT INTO Employees (EmployeeID, EmployeeLastName, EmployeeFirstName, EmployeeHireDate, EmployeeStatus, SupervisorID, SocialSecurityNumber)
VALUES
    (1, 'Smith', 'John', '2021-01-15', 'Active', 1, 123456789),
    (2, 'Johnson', 'Mary', '2019-06-15', 'Active', 1, 987654321),
    (3, 'Williams', 'James', '2022-03-10', 'Active', 1, 345678912),
    (4, 'Brown', 'Patricia', '2021-12-01', 'Active', 2, 567891234),
    (5, 'Jones', 'Robert', '2023-02-20', 'Active', 3, 789123456),
    (6, 'Garcia', 'Linda', '2022-07-10', 'Active', 2, 891234567),
    (7, 'Miller', 'Michael', '2021-04-05', 'Active', 3, 123456789),
    (8, 'Davis', 'Barbara', '2023-05-15', 'Active', 2, 234567891),
    (9, 'Rodriguez', 'William', '2020-09-20', 'Active', 1, 456789123),
    (10, 'Martinez', 'Susan', '2023-01-10', 'Active', 4, 678912345);

INSERT INTO Projects (ManagerID, ProjectName, ProjectStartDate, ProjectDescription, ProjectDetails, ProjectCompletedOn)
VALUES
    (1, 'Project A', '2023-01-15', 'Description A', 'Details A', '2023-01-30'),
    (2, 'Project B', '2023-02-10', 'Description B', 'Details B', '2023-07-20'),
    (3, 'Project C', '2023-03-05', 'Description C', 'Details C', '2023-08-15'),
    (4, 'Project D', '2023-04-20', 'Description D', 'Details D', '2023-09-10'),
    (5, 'Project E', '2023-05-12', 'Description E', 'Details E', '2023-10-05'),
    (6, 'Project F', '2023-06-08', 'Description F', 'Details F', '2023-11-20'),
    (7, 'Project G', '2023-07-25', 'Description G', 'Details G', '2023-12-15'),
    (8, 'Project H', '2023-08-15', 'Description H', 'Details H', '2023-12-31'),
    (9, 'Project I', '2023-09-03', 'Description I', 'Details I', '2024-01-15'),
    (10, 'Project J', '2023-10-18', 'Description J', 'Details J', '2024-02-10');

INSERT INTO ProjectModules (ModuleID, ProjectID, EmployeeID, ProjectModuleDate, ProjectModuleDescription, ProjectModuleCompletedOn)
VALUES
    (1, 1, 2, '2023-02-01', 'Module A of Project 1', '2023-02-15'),
    (2, 2, 3, '2023-03-10', 'Module B of Project 2', '2023-04-05'),
    (3, 3, 4, '2023-04-15', 'Module C of Project 3', '2023-05-20'),
    (4, 4, 5, '2023-05-25', 'Module D of Project 4', '2023-06-30'),
    (5, 1, 3, '2023-02-15', 'Module B of Project 1', '2023-03-05'),
    (6, 2, 4, '2023-03-20', 'Module C of Project 2', '2023-04-10'),
    (7, 3, 5, '2023-04-25', 'Module D of Project 3', '2023-05-30'),
    (8, 4, 6, '2023-06-01', 'Module E of Project 4 (Not Completed)', '2024-01-01'),
    (9, 1, 4, '2023-08-20', 'Module C of Project 1 (Future Completion)', '2023-08-25'),
    (10, 2, 5, '2023-08-25', 'Module D of Project 2 (Future Completion)', '2023-09-15');


INSERT INTO WorkDone (EmployeeID, ModuleID, WorkDoneDate, WorkDoneDescription, WorkDoneStatus)
VALUES
    (4, 3, '2023-04-20', 'Completed module C of Project 3', 'Completed'),
    (5, 4, '2023-06-01', 'Completed module D of Project 4', 'Completed'),
    (3, 1, '2023-02-18', 'Completed module A of Project 1', 'Completed'),
    (4, 2, '2023-03-25', 'Completed module B of Project 2', 'Completed'),
    (5, 3, '2023-04-30', 'Completed module C of Project 3', 'Completed'),
    (6, 4, '2023-06-15', 'Completed module D of Project 4', 'Completed'),
    (4, 1, '2023-08-23', 'Completed module A of Project 1 (Future Completion)', 'In Progress'),
    (5, 2, '2023-08-30', 'Completed module B of Project 2 (Future Completion)', 'In Progress'),
    (6, 3, '2023-09-15', 'Completed module C of Project 3 (Future Completion)', 'In Progress');
/* b) Viết stored procedure (không có parameter) để Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
remove từ các table liên quan trong khi removing (dùng lệnh print)*/

INSERT INTO Projects (ProjectID, ManagerID, ProjectName, ProjectStartDate, ProjectDescription, ProjectDetails, ProjectCompletedOn)
VALUES
    (1, 1, 'Project A', '2023-01-15', 'Description A', 'Details A', '2023-01-30');

DROP PROCEDURE IF EXISTS `Question_b`;
DELIMITER $$
CREATE PROCEDURE `Question_b` ()
	BEGIN
		SELECT * FROM `Projects`
        WHERE `ProjectCompletedOn` < DATE_SUB(NOW(), INTERVAL 3 MONTH);
        
        DELETE FROM `Projects`
		WHERE `ProjectCompletedOn` < DATE_SUB(NOW(), INTERVAL 3 MONTH);
    END$$
DELIMITER ;

CALL `Question_b`;

/* c) Viết stored procedure (có parameter) để in ra các module đang được thực
hiện)*/

DROP PROCEDURE IF EXISTS `Question_c`;
DELIMITER $$
CREATE PROCEDURE `Question_c`(IN `p_in_projectID` TINYINT)
	BEGIN
		SELECT t2.*, t1.`WorkDoneStatus` FROM `WorkDone` t1 JOIN `projectmodules` t2 ON t1.`ModuleID` = t2.`ModuleID`
        WHERE t1.`WorkDoneStatus` = "In Progress" AND `ProjectID` = `p_in_projectID`;
    END $$
DELIMITER ;

CALL `Question_c`(2);

-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)
DROP FUNCTION IF EXISTS `Question_d`;
DELIMITER $$
CREATE FUNCTION `Question_d`(`p_in_id` TINYINT) RETURNS VARCHAR(255)
	DETERMINISTIC 
    NO SQL
    BEGIN
		DECLARE `out_FullName` VARCHAR(255);
		SELECT 
            CONCAT(`EmployeeFirstName`, " ", `EmployeeLastName`)  INTO `out_FullName`  
			FROM `Employees`
            WHERE `p_in_id` = `EmployeeID` AND `EmployeeID` NOT IN (
				SELECT `EmployeeID` FROM `WorkDone`
            ) ;
		RETURN `out_FullName`;
    END $$
DELIMITER ;
SELECT `Question_d`(2) AS FullName;