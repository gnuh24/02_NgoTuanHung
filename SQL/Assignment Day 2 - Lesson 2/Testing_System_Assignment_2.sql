USE `testing_system_assignment_1`;
-- FIle này dùng để insert data vào các table

-- DEPARTMENT
INSERT INTO `Department`(`DepartmentName`)
VALUE 
	('HR'),
	('Finance'),
	('IT'),
	('Sales'),
	('Marketing'),
	('Operations'),
	('Research'),
	('Customer Service'),
	('Production'),
	('Administration');
    
-- POSITION
INSERT INTO `Position`(`PositionName`)
VALUE 
	('Dev'),
	('Test'),
	('Scrum Master'),
	('PM');
    
    
-- ACCOUNT
INSERT INTO `Account` (Email, Username, FullName, DepartmentID, PositionID, CreateDate) 
VALUES 
	('user1@example.com', 'user1', 'User 1', 1, 1, '2023-06-01'),
	('user2@example.com', 'user2', 'User 2', 2, 2, '2023-06-02'),
	('user3@example.com', 'user3', 'User 3', 3, 3, '2023-06-03'),
	('user4@example.com', 'user4', 'User 4', 4, 1, '2023-06-04'),
	('user5@example.com', 'user5', 'User 5', 5, 2, '2023-06-05'),
	('user6@example.com', 'user6', 'User 6', 6, 3, '2023-06-06'),
	('user7@example.com', 'user7', 'User 7', 7, 4, '2023-06-07'),
	('user8@example.com', 'user8', 'User 8', 8, 1, '2023-06-08'),
	('user9@example.com', 'user9', 'User 9', 9, 2, '2023-06-09'),
	('user10@example.com', 'user10', 'User 10', 10, 3, '2023-06-10');
    
-- GROUP 
INSERT INTO `Group` (GroupName, CreateID, CreateDate) 
VALUES  	
	('Group 1', 1, '2023-06-01'),
	('Group 2', 2, '2023-06-02'),
	('Group 3', 3, '2023-06-03'),
	('Group 4', 4, '2023-06-04'),
	('Group 5', 5, '2023-06-05'),
	('Group 6', 6, '2023-06-06'),
	('Group 7', 7, '2023-06-07'),
	('Group 8', 8, '2023-06-08'),
	('Group 9', 9, '2023-06-09'),
	('Group 10', 10, '2023-06-10');
    
-- GroupAccount table
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate) VALUES 
    (1, 1, '2023-06-01'),
    (2, 2, '2023-06-02'),
    (3, 3, '2023-06-03'),
    (4, 4, '2023-06-04'),
    (5, 5, '2023-06-05'),
    (6, 6, '2023-06-06'),
    (7, 7, '2023-06-07'),
    (8, 8, '2023-06-08'),
    (9, 9, '2023-06-09'),
    (10, 10, '2023-06-10');


-- TypeQuestion table
INSERT INTO `TypeQuestion` (TypeName) 
VALUES 
    ('Essay'),
    ('Multiple-Choice');


-- CategoryQuestion table
INSERT INTO `CategoryQuestion` (CategoryName) VALUES 
    ('Category 1'),
    ('Category 2'),
    ('Category 3'),
    ('Category 4'),
    ('Category 5'),
    ('Category 6'),
    ('Category 7'),
    ('Category 8'),
    ('Category 9'),
    ('Category 10');
    
INSERT INTO `Question` (Content, CategoryID, TypeID, CreatorID, CreateDate) VALUES 
    ('Question 1', 1, 1, 1, '2023-06-01'),
    ('Question 2', 2, 2, 2, '2023-06-02'),
    ('Question 3', 3, 1, 3, '2023-06-03'),
    ('Question 4', 4, 2, 4, '2023-06-04'),
    ('Question 5', 5, 1, 5, '2023-06-05'),
    ('Question 6', 6, 2, 6, '2023-06-06'),
    ('Question 7', 7, 1, 7, '2023-06-07'),
    ('Question 8', 8, 2, 8, '2023-06-08'),
    ('Question 9', 9, 1, 9, '2023-06-09'),
    ('Question 10', 10, 2, 10, '2023-06-10');

-- Data for the Answer table
INSERT INTO `Answer` (Content, QuestionID, isCorrect) VALUES 
    ('Answer 1', 1, 'True'),
    ('Answer 2', 1, 'False'),
    ('Answer 3', 2, 'True'),
    ('Answer 4', 2, 'False'),
    ('Answer 5', 3, 'True'),
    ('Answer 6', 3, 'False'),
    ('Answer 7', 4, 'True'),
    ('Answer 8', 4, 'False'),
    ('Answer 9', 5, 'True'),
    ('Answer 10', 5, 'False');

-- Data for the Exam table
INSERT INTO `Exam` (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate) VALUES 
    (1, 'Exam 1', 1, 60, 1, '2023-06-01'),
    (2, 'Exam 2', 2, 90, 2, '2023-06-02'),
    (3, 'Exam 3', 3, 120, 3, '2023-06-03'),
    (4, 'Exam 4', 4, 90, 4, '2023-06-04'),
    (5, 'Exam 5', 5, 60, 5, '2023-06-05'),
    (6, 'Exam 6', 1, 120, 6, '2023-06-06'),
    (7, 'Exam 7', 2, 90, 7, '2023-06-07'),
    (8, 'Exam 8', 3, 60, 8, '2023-06-08'),
    (9, 'Exam 9', 4, 120, 9, '2023-06-09'),
    (10, 'Exam 10', 5, 90, 10, '2023-06-10');

-- Data for the ExamQuestion table
INSERT INTO `ExamQuestion` (ExamID, QuestionID) VALUES 
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (5, 10);
    

    

    
    