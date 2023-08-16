
CREATE DATABASE IF NOT EXISTS `Extra_Assignment_6`;
USE `Extra_Assignment_6`;

-- a) Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào mỗi table trên
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE IF NOT EXISTS `Employee` (
	`EmployeeID` TINYINT PRIMARY KEY AUTO_INCREMENT,
	`EmployeeLastName` NVARCHAR(50),
	`EmployeeFirstName` NVARCHAR(50),
	`EmployeeHireDate` DATE,
	`EmployeeStatus` NVARCHAR(50),
	`SupervisorID` TINYINT,
    `SocialSecurityNumber` INT,
    FOREIGN KEY (`SupervisorID`) REFERENCES `Employee`(`EmployeeID`)
);

DROP TABLE IF EXISTS `Projects`;
CREATE TABLE IF NOT EXISTS `Projects` (
	`ProjectID`  TINYINT PRIMARY KEY AUTO_INCREMENT,
    `ManagerID` TINYINT UNIQUE KEY NOT NULL,
    `ProjectName` NVARCHAR(50) NOT NULL,
    `ProjectStarDate` DATE NOT NULL,
	`ProjectDescription` TEXT,
	`ProjectDetails` TEXT,
    `ProjectCompletedOn` DATE NOT NULL,
    FOREIGN KEY (`ManagerID`) REFERENCES `Employee`(`EmployeeID`)
);

DROP TABLE IF EXISTS `Project_Modules`;
CREATE TABLE IF NOT EXISTS `Project_Modules` (
	`ModuleID` TINYINT PRIMARY KEY AUTO_INCREMENT,
    `ProjectID` TINYINT NOT NULL,
    `EmployeeID` TINYINT NOT NULL,
    `ProjectModuleDate` DATE NOT NULL,
    `ProjectModulesCompletedOn` DATE NOT NULL,
    `ProjectModulesDescription` TEXT,
    FOREIGN KEY (`ProjectID`) REFERENCES `Projects`(`ProjectID`),
    FOREIGN KEY (`EmployeeID`) REFERENCES `Employee`(`EmployeeID`)
);

DROP TABLE IF EXISTS `Work_Done`;
CREATE TABLE IF NOT EXISTS  `Work_Done` (
	`WorkDoneID` TINYINT PRIMARY KEY AUTO_INCREMENT,
    `EmployeeID` TINYINT NOT NULL,
    `ModuleID` TINYINT NOT NULL,
    `WorkDoneDate` DATE NOT NULL,
    `WorkDoneDescription` TEXT,
	`WorkDoneStatus` NVARCHAR(50),
    FOREIGN KEY (`EmployeeID`) REFERENCES `Employee`(`EmployeeID`),
    FOREIGN KEY (`ModuleID`) REFERENCES `Project_Modules`(`ModuleID`)
);

INSERT INTO `Employee` (`EmployeeLastName`, `EmployeeFirstName`, `EmployeeHireDate`, `EmployeeStatus`, `SupervisorID`, `SocialSecurityNumber`)
VALUES
    ('Smith', 'John', '2020-01-01', 'Active', NULL, 12345),
    ('Johnson', 'Mary', '2019-06-15', 'Active', 1, 67890),
    ('Williams', 'James', '2022-03-10', 'Active', 1, 54321),
    ('Brown', 'Patricia', '2021-12-01', 'Active', 2, 98765),
    ('Jones', 'Robert', '2023-02-20', 'Active', 3, 13579),
    ('Garcia', 'Linda', '2022-07-10', 'Active', 2, 86420),
    ('Miller', 'Michael', '2021-04-05', 'Active', 3, 24680),
    ('Davis', 'Barbara', '2023-05-15', 'Active', 2, 97531),
    ('Rodriguez', 'William', '2020-09-20', 'Active', 1, 98712),
    ('Martinez', 'Susan', '2023-01-10', 'Active', 4, 65432);

INSERT INTO `Projects` (`ManagerID`, `ProjectName`, `ProjectStarDate`, `ProjectDescription`, `ProjectDetails`, `ProjectCompletedOn`)
VALUES
    (1, 'Project A', '2023-01-15', 'Description A', 'Details A', '2023-06-30'),
    (2, 'Project B', '2023-02-10', 'Description B', 'Details B', '2023-07-20'),
    (3, 'Project C', '2023-03-05', 'Description C', 'Details C', '2023-08-15'),
    (4, 'Project D', '2023-04-20', 'Description D', 'Details D', '2023-09-10'),
    (5, 'Project E', '2023-05-12', 'Description E', 'Details E', '2023-10-05'),
    (6, 'Project F', '2023-06-08', 'Description F', 'Details F', '2023-11-20'),
    (7, 'Project G', '2023-07-25', 'Description G', 'Details G', '2023-12-15'),
    (8, 'Project H', '2023-08-15', 'Description H', 'Details H', '2023-12-31'),
    (9, 'Project I', '2023-09-03', 'Description I', 'Details I', '2024-01-15'),
    (10, 'Project J', '2023-10-18', 'Description J', 'Details J', '2024-02-10');
    
INSERT INTO `Project_Modules` (`ProjectID`, `EmployeeID`, `ProjectModuleDate`, `ProjectModulesCompletedOn`, `ProjectModulesDescription`)
VALUES
    (1, 2, '2023-02-01', '2023-02-15', 'Module A of Project 1'),
    (2, 3, '2023-03-10', '2023-04-05', 'Module B of Project 2'),
    (3, 4, '2023-04-15', '2023-05-20', 'Module C of Project 3'),
    (4, 5, '2023-05-25', '2023-06-30', 'Module D of Project 4'),
    (1, 3, '2023-02-15', '2023-03-05', 'Module B of Project 1'),
    (2, 4, '2023-03-20', '2023-04-10', 'Module C of Project 2'),
    (3, 5, '2023-04-25', '2023-05-30', 'Module D of Project 3'),
    (4, 6, '2023-06-01', '2024-01-01', 'Module E of Project 4 (Not Completed)'),
    (1, 4, '2023-08-20', '2023-08-25', 'Module C of Project 1 (Future Completion)'),
    (2, 5, '2023-08-25', '2023-09-15', 'Module D of Project 2 (Future Completion)'),
    (3, 6, '2023-09-10', '2023-10-10', 'Module E of Project 3 (Future Completion)')
    -- Add more rows as needed
    ;

INSERT INTO `Work_Done` (`EmployeeID`, `ModuleID`, `WorkDoneDate`, `WorkDoneDescription`, `WorkDoneStatus`)
VALUES
    (2, 1, '2023-02-10', 'Completed module A of Project 1', 'Completed'),
    (3, 2, '2023-03-15', 'Completed module B of Project 2', 'Completed'),
    (4, 3, '2023-04-20', 'Completed module C of Project 3', 'Completed'),
    (5, 4, '2023-06-01', 'Completed module D of Project 4', 'Completed'),
    (3, 1, '2023-02-18', 'Completed module A of Project 1', 'Completed'),
    (4, 2, '2023-03-25', 'Completed module B of Project 2', 'Completed'),
    (5, 3, '2023-04-30', 'Completed module C of Project 3', 'Completed'),
    (6, 4, '2023-06-15', 'Completed module D of Project 4', 'Completed'),
    (4, 1, '2023-08-23', 'Completed module A of Project 1 (Future Completion)', 'In Progress'),
    (5, 2, '2023-08-30', 'Completed module B of Project 2 (Future Completion)', 'In Progress'),
    (6, 3, '2023-09-15', 'Completed module C of Project 3 (Future Completion)', 'In Progress')
    -- Add more rows as needed
    ;
    
/* b) Viết stored procedure (không có parameter) để Remove tất cả thông tin
project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
remove từ các table liên quan trong khi removing (dùng lệnh print)*/

-- c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện
DROP PROCEDURE IF EXISTS `Question_C`;
DELIMITER $$
CREATE PROCEDURE `Question_C`()
	BEGIN
		SELECT t1.* FROM `Project_Module`; 
    END $$
DELIMITER ;
CALL `Question_C`;
-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)