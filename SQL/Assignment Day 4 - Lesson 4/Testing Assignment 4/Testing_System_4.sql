USE `testing_system_assignment_1`;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT t1.*, t2.`DepartmentName`
FROM `account` t1
JOIN `department` t2 ON t1.`DepartmentID` = t2.`DepartmentID`;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `account`  WHERE `CreateDate` > "2010-12-20";

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT t1.*, t2.`PositionName` 
FROM `account` t1
JOIN `position` t2 ON t1.`PositionID` = t2.`PositionID`
WHERE `PositionName` = "Dev" ;


-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT t1.`DepartmentName`, COUNT(t1.`DepartmentName`) AS Quanlity
FROM `department` t1
JOIN `account` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
GROUP BY t1.`DepartmentName`
HAVING Quanlity > 3;


-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT t1.`QuestionID`, COUNT(t2.`ExamID`) AS `Quanlity`
FROM `question`t1
JOIN `examquestion` t2 ON t1.`QuestionID` = t2.`QuestionID` 
GROUP BY t1.`QuestionID`
HAVING COUNT(t2.`ExamID`) = (
    SELECT MAX(`Count`)
    FROM (
        SELECT COUNT(`ExamID`) AS `Count`
        FROM `examquestion`
        GROUP BY `QuestionID`
    ) AS `subQuery1`
)
ORDER BY t1.`QuestionID`;

-- Subquery 1
SELECT MAX(`Count`)
    FROM (
		SELECT t1.`QuestionID`, COUNT(t2.`ExamID`) AS `Count`
        FROM `question` t1
		JOIN `examquestion` t2 ON t1.`QuestionID` = t2.`QuestionID`
        GROUP BY t1.`QuestionID`
    ) AS `subQuery1`;
    
-- Subquery2
SELECT COUNT(t2.`ExamID`) AS `Count`
        FROM `question` t1
		JOIN `examquestion` t2 ON t1.`QuestionID` = t2.`QuestionID`
        GROUP BY t1.`QuestionID`;


-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT t1.*, COUNT(t2.`QuestionID`) AS `Quanlity`
FROM `categoryquestion` t1
LEFT JOIN `question` t2 ON t1.`CategoryID` = t2.`CategoryID`
GROUP BY t1.`CategoryID`
ORDER BY t1.`CategoryID`;


-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT t1.`QuestionID`, COUNT(t2.`ExamID`) AS Quanlity
FROM `question`t1
LEFT JOIN `examquestion` t2 ON t1.`QuestionID` = t2.`QuestionID` 
GROUP BY t1.`QuestionID`
ORDER BY t1.`QuestionID`; 

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT t1.*, COUNT(t2.`AnswerID`) AS `Answer`
FROM `question` t1
JOIN `answer` t2 ON t1.`QuestionID` = t2.`QuestionID`
GROUP BY t1.`QuestionID`
HAVING `Answer` = (
	SELECT MAX(`countAnswer`) FROM (
		SELECT COUNT(t2.`AnswerID`) AS `countAnswer`
        FROM `question` t1
		JOIN `answer` t2 ON t1.`QuestionID` = t2.`QuestionID`
		GROUP BY t1.`QuestionID`
    ) AS `subQuery1`
)
ORDER BY t1.`QuestionID`;


-- Question 9: Thống kê số lượng account trong mỗi group
SELECT t1.*, COUNT(t2.`AccountID`)  AS Quanlity
FROM `group` t1
LEFT JOIN `groupaccount` t2 ON t1.`GroupID` = t2.`GroupID`
GROUP BY t1.`GroupID`
ORDER BY t1.`GroupID`;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT t1.*, COUNT(t2.`AccountID`) AS `Quanlity`
FROM `position` t1
JOIN `account` t2 ON t1.`PositionID` = t2.`PositionID`
GROUP BY t1.`PositionID`
HAVING `Quanlity` = (
	SELECT MIN(`count`) FROM (
		SELECT  COUNT(t2.`AccountID`) AS `count`
        FROM `position` t1
		JOIN `account` t2 ON t1.`PositionID` = t2.`PositionID`
		GROUP BY t1.`PositionID`
    ) AS `subQuery1`
)
ORDER BY t1.`PositionID` DESC;



-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
-- THống kê 1
SELECT 
    t1.`DepartmentName`,
    t3.`PositionName`,
    COUNT(t2.`AccountID`) AS Quanlity
FROM
    `department` t1
        JOIN
    `account` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
        JOIN
    `position` t3 ON t2.`PositionID` = t3.`PositionID`
GROUP BY t1.`DepartmentName` , t3.`PositionName`
ORDER BY t1.`DepartmentName` , t3.`PositionName`
;


-- Thống kê 2
SELECT t4.`DepartmentName`, GROUP_CONCAT(`Quanlity`) AS `SoLuong`
FROM (
    SELECT t1.`DepartmentName`, CONCAT(t3.`PositionName`, " - ", COUNT(t2.`AccountID`)) AS `Quanlity`
    FROM `department` t1
    JOIN `account` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
    JOIN `position` t3 ON t2.`PositionID` = t3.`PositionID`
    GROUP BY t1.`DepartmentName`, t3.`PositionName`
) AS t4-- Đặt alias tại đây
GROUP BY t4.`DepartmentName`;
    
    
    
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT t1.`QuestionID`, t1.`Content`, t2.`TypeName`, t1.`CreatorID`
FROM `question` t1 JOIN `typequestion` t2 
ON t1.`TypeID` = t2.`TypeID`
ORDER BY t1.`QuestionID`;


-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT t1.*, COUNT(t2.`QuestionID`) As `Quanlity`
FROM `typequestion` t1
JOIN `question`t2 ON t1.`TypeID` = t2.`TypeID`
GROUP BY t1.`TypeID`
ORDER BY `Quanlity` DESC;



-- Question 14:Lấy ra group không có account nào
-- Question 15: Lấy ra group không có account nào
SELECT t1.*, COUNT(t2.`AccountID`)  AS `Account`
FROM `group` t1
LEFT JOIN `groupaccount` t2 ON t1.`GroupID` = t2.`GroupID`
GROUP BY t1.`GroupID`
HAVING `Account` = 0
ORDER BY t1.`GroupID`;

-- Question 16: Lấy ra question không có answer nào
SELECT t1.*, COUNT(t2.`AnswerID`) As `Quanlity`
FROM `question` t1
LEFT JOIN `answer` t2 ON t1.`QuestionID` = t2.`QuestionID` 
GROUP BY t1.`QuestionID`
HAVING `Quanlity` = 0
ORDER BY t1.`QuestionID`;
/*
Question 17:
a) Lấy các account thuộc nhóm thứ 1
b) Lấy các account thuộc nhóm thứ 2
c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
*/

SELECT t1.*, t2.`GroupID`
FROM `account` t1
JOIN `groupaccount` t2 ON t1.`AccountID` = t2.`AccountID`
WHERE t2.`GroupID` = 1

UNION 

SELECT t1.*, t2.`GroupID`
FROM `account` t1
JOIN `groupaccount` t2 ON t1.`AccountID` = t2.`AccountID`
WHERE t2.`GroupID` = 2
;


/*
Question 18:
a) Lấy các group có lớn hơn 5 thành viên
b) Lấy các group có nhỏ hơn 7 thành viên
c) Ghép 2 kết quả từ câu a) và câu b)
*/

SELECT `GroupID`, COUNT(`AccountID`) AS `Member`
FROM`groupaccount`
GROUP BY `GroupID`
HAVING  `Member` > 5
UNION ALL
SELECT `GroupID`, COUNT(`AccountID`) AS `Member`
FROM`groupaccount`
GROUP BY `GroupID`
HAVING  `Member` < 7
;

