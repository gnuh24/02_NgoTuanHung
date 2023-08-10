DROP DATABASE IF EXISTS `Extra Assignment 4`;
CREATE DATABASE IF NOT EXISTS `Extra Assignment 4`;

USE `Extra Assignment 4`;

-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP TABLE IF EXISTS `Department`;
CREATE TABLE IF NOT EXISTS `Department`
(
	`Department_Number` TINYINT  PRIMARY KEY AUTO_INCREMENT,
    `Department_Name` NVARCHAR(55)
);

DROP TABLE IF EXISTS `Employee_Table`;
CREATE TABLE IF NOT EXISTS `Employee_Table`
(
	`Employee_Number` TINYINT  PRIMARY KEY AUTO_INCREMENT,
    `Employee_Name` NVARCHAR(55),
    `Department_Number` TINYINT,
FOREIGN KEY (`Department_Number`)  REFERENCES `Department`(`Department_Number`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Employee_Skill_Table`;
CREATE TABLE IF NOT EXISTS `Employee_Skill_Table`
(
	`Employee_Number` TINYINT  ,
    `Skill_Code` NVARCHAR(55),
    `Registered` DATE,
FOREIGN KEY (`Employee_Number`)  REFERENCES `Employee_Table`(`Employee_Number`) ON DELETE CASCADE
);

-- Question 2 Thêm ít nhất 10 bản ghi vào table
INSERT INTO `Department` (`Department_Number`, `Department_Name`)
VALUES
    (1, 'HR'),
    (2, 'Finance'),
    (3, 'IT'),
    (4, 'Marketing'),
    (5, 'Operations'),
    (6, 'Sales'),
    (7, 'Research'),
    (8, 'Production'),
    (9, 'Customer Service'),
    (10, 'Legal');

INSERT INTO `Employee_Table` (`Employee_Number`, `Employee_Name`, `Department_Number`)
VALUES
    (1, 'John Smith', 6),
    (2, 'Jane Doe', 3),
    (3, 'Michael Johnson', 9),
    (4, 'Emily Williams', 2),
    (5, 'Robert Brown', 3),
    (6, 'Lisa Jones', 5),
    (7, 'David Miller', 3),
    (8, 'Sarah Wilson', 1),
    (9, 'Daniel Anderson', 3),
    (10, 'Jessica Martinez', 7);
INSERT INTO `Employee_Skill_Table` (`Employee_Number`, `Skill_Code`, `Registered`)
VALUES
    (1, 'Java', '2023-01-15'),
    (2, 'C++', '2023-02-20'),
    (3, 'Python', '2023-03-10'),
    (4, 'Java', '2023-04-05'),
    (5, 'Python', '2023-05-12'),
    (6, 'C#', '2023-06-18'),
    (7, 'Java', '2023-07-25'),
    (8, 'Python', '2023-08-30'),
    (9, 'C++', '2023-09-07'),
    (10, 'C#', '2023-10-15'),
	(7, 'Python', '2023-07-25'),
	(7, 'C#', '2023-07-25'),
	(8, 'C++', '2023-08-30'),
	(2, 'Java', '2023-02-20');




    
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
-- NOTE!! Trường hợp nhân viên có nhiều skill
-- Dùng JOIN 
SELECT t1.`Employee_Number`, t1.`Employee_Name`, t2.`Skill_Code`
FROM `Employee_Table` t1
RIGHT JOIN `Employee_Skill_Table` t2 ON t1.`Employee_Number` = t2.`Employee_Number`
WHERE t2.`Skill_Code` = "Java";




-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT t1.`Department_Name`, COUNT(t1.`Department_Name`) AS NumberOfStaff
FROM `Department` t1
JOIN `Employee_Table` t2 ON t1.`Department_Number` = t2.`Department_Number`
GROUP BY t1.`Department_Name`
HAVING NumberOfStaff > 3 ;


-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
SELECT t1.`Department_Name`, GROUP_CONCAT(t2.`Employee_Name`) AS List_Of_Staff
FROM `Department` t1
LEFT JOIN `Employee_Table` t2 ON t1.`Department_Number` = t2.`Department_Number`
GROUP BY t1.`Department_Name`;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
-- Hướng dẫn: sử dụng DISTINCT 


-- Display ra tên những người có trên 1 skill - Dùng GROUP BY
-- DISTINCT được dùng ở đây cho những trường hợp mà database của chúng ta chưa được clean ^^ 
-- Ex: Một người có thể có 2 record (1, 'Java', '2023-01-15'), (1, 'Java', '2020-01-15') -> Dùng DISTINCT để lọc đi những trường hợp này
SELECT t1.`Employee_Name`, COUNT(DISTINCT t2.`Skill_Code`) AS `Number` , GROUP_CONCAT(t2.`Skill_Code`)  AS `Skill`
FROM `Employee_Table` t1
JOIN `Employee_Skill_Table` t2 ON t1.`Employee_Number` = t2.`Employee_Number`
GROUP BY t1.`Employee_Name`
HAVING `Number` > 1
ORDER BY `Number`  DESC;
 

