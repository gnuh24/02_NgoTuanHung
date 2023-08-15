USE `testing_system_assignment_1`;

-- _______________________________________________________________QUERY ^^ __________________________________________________________________________________________________
    
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW `question_1` AS 
		SELECT t1.*, t2.`DepartmentName`
		FROM `account` t1 JOIN `department` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
		WHERE t2.`DepartmentName` = "Sales"
;


-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW `Question_2` AS
	SELECT t1.*, COUNT(t2.`GroupID`) AS `NumberOfGroups`
	FROM `account` t1 JOIN `groupaccount` t2 ON t1.`AccountID` = t2.`AccountID`
	GROUP BY t1.`AccountID`
	HAVING `NumberOfGroups` = (
		SELECT MAX(`SoLuong`) 
		FROM(
				SELECT COUNT(`GroupID`) AS `SoLuong`
				FROM `groupaccount`
				GROUP BY `AccountID`
			)  AS `Count`
	)
	ORDER BY t1.`AccountID`;
    
    
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE VIEW `Question_3` AS
	SELECT * FROM `question` 
	WHERE ( CHAR_LENGTH(`content`) - CHAR_LENGTH(REPLACE(`content`, " ", "")) + 1) > 300;
    
 DROP VIEW  `Question_3`;
 
-- Tạo câu hỏi test
INSERT INTO `question`
VALUES (11, "Trong ngày Premier League 2023-2024 khởi tranh, họ sẽ mất đi một trong những tiền đạo xuất sắc nhất.", 2, 1, 4,"2023-12-8");


-- Delete
DELETE FROM `question` 
WHERE `QuestionID` IN (
    SELECT `QuestionID` FROM (
        SELECT `QuestionID` FROM `question` 
        WHERE ( CHAR_LENGTH(`content`) - CHAR_LENGTH(REPLACE(`content`, " ", "")) + 1) > 10
    ) AS `QuestionToDelete`
);

-- Delete
WITH `QuestionsToDelete` AS (
    SELECT `QuestionID` FROM `Question_3`
)
DELETE FROM `Question`
WHERE `QuestionID` IN (SELECT * FROM `QuestionsToDelete`);




-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW `Question_4` AS
	SELECT t1.*, COUNT(t2.`AccountID`) AS `Quanlity` 
	FROM `department` t1 JOIN `account` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
	GROUP BY t1.`DepartmentID`
	HAVING `Quanlity` = (
		SELECT MAX(`SoLuong`) FROM (
			SELECT COUNT(`AccountID`) AS `SoLuong` FROM `account`
			GROUP BY `DepartmentID`
		) AS `Count`
	)
	ORDER BY t1.`DepartmentID`, t1.`DepartmentName`;


SELECT MAX(`SoLuong`) FROM (
			SELECT COUNT(`AccountID`) AS `SoLuong` FROM `account`
			GROUP BY `DepartmentID`
		) AS `Count`;


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW `Question_5` AS
	SELECT t1.* , t2.`FullName`
	FROM `question` t1 JOIN `account` t2 ON t1.`CreatorID` = t2.`AccountID`
	WHERE SUBSTRING_INDEX(t2.`FullName`, " ", 1) = "Nguyen";
