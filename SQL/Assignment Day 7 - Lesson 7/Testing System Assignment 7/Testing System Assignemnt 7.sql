USE `testing_system_assignment_1`;


-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

-- Hiểu theo ý đầu tiên: Không cho phép tạo thêm GROUP có ngày tạo từ 1 năm trước
DROP TRIGGER IF EXISTS `Quesiton_1_a`;
DELIMITER $$
CREATE TRIGGER `Quesiton_1_a`
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
    IF NEW.`CreateDate` < DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Bạn không thể tạo GROUP có ngày tạo cách đây hơn 1 năm';
    END IF;
END $$
DELIMITER ;

-- TEST
INSERT INTO `Group`(GroupID, GroupName, CreateID, CreateDate)
VALUES(12, "Inter Milan", 11, "2020-07-04");

-- Hiểu theo ý thứ 2: Không cho em account join vào group có ngày tạo quá 1 năm trước
DROP TRIGGER IF EXISTS `Quesiton_1_b`;
DELIMITER $$
CREATE TRIGGER `Quesiton_1_b` BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
    DECLARE `CreateDate` DATE;
    
SELECT 
    t1.`CreateDate`
INTO `CreateDate` FROM
    `Group` t1
        JOIN
    `GroupAccount` t2 ON t1.`GroupID` = t2.`GroupID`
WHERE
    NEW.`AccountID` = t2.`AccountID`
        AND NEW.`GroupID` = t2.`GroupID`;
    
    IF `CreateDate` < DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Bạn không thể nhập vào GROUP có ngày tạo cách đây hơn 1 năm';
    END IF;
END $$
DELIMITER ;

-- TEST
INSERT INTO `Groupaccount`(GroupID, AccountID, JoinDate)
VALUES(12, 12, NOW());



/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
"Sale" cannot add more user" */

DROP TRIGGER IF EXISTS `Quesiton_2`;
DELIMITER $$
CREATE TRIGGER `Quesiton_2`
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
    IF NEW.`DepartmentID` = 4 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Bạn không thể nhập thêm USER vào phòng ban Sales';
    END IF;
END $$
DELIMITER ;

-- TEST 
INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES ("Hello1@gmail.com", "WhoAmI?", "IDoNotKnow", 4, 2, NOW());


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS `Quesiton_3`;
DELIMITER $$
CREATE TRIGGER `Quesiton_3`
BEFORE INSERT ON `groupaccount`
FOR EACH ROW
BEGIN
	
	DECLARE `Quanlity` TINYINT;

	SELECT COUNT(`AccountID`) INTO `Quanlity` FROM `Groupaccount`
    WHERE NEW.`GroupID` = `GroupID`
    GROUP BY `GroupID`;
    
    
   IF `Quanlity` >= 5 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Nhóm đã đầy thành viên ^^';
   END IF;
   
END $$
DELIMITER ;

-- Test 
INSERT INTO `GroupAccount`
VALUES(4, 15, NOW());

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS `Quesiton_4`;
DELIMITER $$
CREATE TRIGGER `Quesiton_4`
BEFORE INSERT ON `examquestion`
FOR EACH ROW
BEGIN
	DECLARE `Quanlity` TINYINT;
	SELECT COUNT(`QuestionID`) INTO `Quanlity`
    FROM `examquestion` 
    WHERE NEW.`ExamID` = `ExamID`
    GROUP BY `ExamId`;
   
	IF `Quanlity` >= 10 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Bài kiểm tra đã đủ 10 câu hỏi ^^';
   END IF;
END $$
DELIMITER ;

-- Test
INSERT INTO `examquestion`
VALUES (1,11);

/* Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó */

DROP TRIGGER IF EXISTS `Quesiton_5`;
DELIMITER $$
CREATE TRIGGER `Quesiton_5`
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	IF IF(LOCATE("admin@gmail.com", OLD.`email`) > 0, True, False) = True 
    THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Bạn không có quyền xóa tài khoản của Admin';
	END IF;
END $$
DELIMITER ;

-- Test
DELETE FROM `Account` WHERE `AccountID` = 18;

INSERT INTO `Account`(AccountID, Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES(18, "ngotuanhung.admin@gmail.com", "hungnt.0204", "Ngo Tuan Hung", 6, 3, NOW());



/* Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department" */
DROP TRIGGER IF EXISTS `Question_6`;
DELIMITER $$
CREATE TRIGGER `Question_6`
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF NEW.`DepartmentID` IS NULL 
        THEN SET NEW.`DepartmentID` = 11;
        END IF;
	END $$
DELIMITER ;

-- Test 
INSERT INTO `Account`(AccountID, Email, Username, FullName, PositionID, CreateDate)
VALUES(19, "ngotuanhung@gmail.com", "hungnt.0204", "Ngo Tuan Hung",  3, NOW());

DELETE FROM `Account` WHERE `AccountiD` = 19;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS `Question_7_Quanlity`;
DELIMITER $$
CREATE TRIGGER `Question_7_Quanlity`
BEFORE INSERT ON `Answer`
FOR EACH ROW
	BEGIN
		DECLARE `SoLuongCauTraLoi` TINYINT;
        
		SELECT COUNT(`Content`) INTO `SoLuongCauTraLoi`
		FROM `Answer`
		WHERE `AnswerID` = NEW.`AnswerID` AND `QuestionID` = NEW.`QuestionID`
		GROUP BY   `AnswerID`,`QuestionID`;
		
        IF `SoLuongCauTraLoi` >= 4 THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Bạn chỉ có thể trả lời tối đa 4 lần 1 câu hỏi';
		END IF;
        
    END $$
DELIMITER ;

DROP TRIGGER IF EXISTS `Question_7_isTrue`;
DELIMITER $$
CREATE TRIGGER `Question_7_isTrue` BEFORE INSERT ON `Answer`
FOR EACH ROW
BEGIN
    DECLARE `SoLuongCauDung` TINYINT;
    
   
        SELECT COUNT(`isCorrect`) INTO `SoLuongCauDung`
        FROM `Answer`
        WHERE `AnswerID` = NEW.`AnswerID` AND `QuestionID` = NEW.`QuestionID` AND `isCorrect` = 'True'
        GROUP BY `AnswerID`, `QuestionID`;
    
    
    IF `SoLuongCauDung` >= 2 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Bạn chỉ có thể trả lời True 2 tối đa 2 lần với 1 câu hỏi';
    END IF;
END $$
DELIMITER ;

-- Test
SELECT  *
FROM `Answer`
ORDER BY `AnswerID`;

INSERT INTO `answer` (AnswerID, Content, QuestionID, isCorrect)
VALUES (3, "Content1.d", 2, "True");

DELETE FROM `Answer` WHERE `AnswerID` = 3 AND `Content` = "Content1.d";
       




/* Question 8: Viết trigger sửa lại dữ liệu cho đúng:
Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
DROP TRIGGER IF EXISTS `Question_8`;
DELIMITER $$
CREATE TRIGGER `Question_8`
BEFORE INSERT ON `Account`
FOR EACH ROW
	BEGIN
		IF NEW.`Gender` = "Nam" THEN
			SET NEW.`Gender` = "M";
		ELSEIF NEW.`Gender` = "Nữ" THEN
			SET NEW.`Gender` = "F";
		ELSE
			SET NEW.`Gender` = "U";
    END IF;
END $$
DELIMITER ;


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS `Question_9`;
DELIMITER $$
CREATE TRIGGER `Question_9`
BEFORE DELETE ON `Exam`
FOR EACH ROW
	BEGIN
		IF OLD.`CreateDate` >= DATE_SUB(NOW(), INTERVAL 2 DAY)
        THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Bạn không thể xóa bài thi mới tạo chưa được 2 ngày';
		END IF;
	END $$
DELIMITER ;

-- TEST
DELETE FROM `exam` WHERE `ExamID` = 13;

INSERT INTO `exam` (ExamID, `Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES(13, 0013, "ChemistryExam", 2, 90,4,NOW());


-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS `Question_10_Delete`;
DELIMITER $$
CREATE TRIGGER `Question_10_Delete`
BEFORE DELETE ON `Question`
FOR EACH ROW
	BEGIN
    
		IF OLD.`QuestionID` IN (SELECT `QuestionID` FROM `examquestion`) 
        THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Bạn không thể xóa câu hỏi đã tồn tại trong bài thi';
		END IF;
	END $$
DELIMITER ;

DROP TRIGGER IF EXISTS `Question_10_Update`;
DELIMITER $$
CREATE TRIGGER `Question_10_Update`
BEFORE UPDATE ON `Question`
FOR EACH ROW
	BEGIN
    
		IF NEW.`QuestionID` IN (SELECT `QuestionID` FROM `examquestion`) 
        THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Bạn không thể update câu hỏi đã tồn tại trong bài thi';
		END IF;
	END $$
DELIMITER ;

-- Test
DELETE FROM `Question` WHERE `QuestionID` = 10;
DELETE FROM `Question` WHERE `QuestionID` = 11;

INSERT INTO `Question` (QuestionID, Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES ('11', 'Trong ngày Premier League 2023-2024 khởi tranh, họ sẽ mất đi một trong những tiền đạo xuất sắc nhất.', '2', '1', '4', '2023-08-14');



/* Question 12: Lấy ra thông tin exam trong đó:
Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time"*/

SELECT 
	`ExamId`, 
    `Title`,
    CASE
		WHEN `Duration` <= 30 THEN "Short time"
		WHEN 30 < `Duration` AND `Duration` <= 60 THEN "Medium time"
		WHEN `Duration` > 60 THEN "Long time"
    END AS `Duration`
FROM `Exam`;

/* Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
là the_number_user_amount và mang giá trị được quy định như sau:

Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher*/

SELECT 
	`GroupID`, 
	COUNT(`AccountID`) AS `Quanlity`, 
	CASE 
		WHEN COUNT(`AccountID`) <= 5 THEN "few"
		WHEN COUNT(`AccountID`) > 5 AND COUNT(`AccountID`) <= 20 THEN "normal"
		WHEN COUNT(`AccountID`) > 20 THEN "few"
    END AS `the_number_user_amount`
FROM `groupaccount`
GROUP BY `GroupID`
ORDER BY `GroupID`;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT 
	t1.*, 
    CASE
		WHEN COUNT(t2.`AccountID`)  = 0 THEN "Không có User"
        ELSE COUNT(t2.`AccountID`) 
	END AS `Quanlity`
FROM `Department` t1
LEFT JOIN `Account` t2 ON t1.`DepartmentId` = t2.`DepartmentId`
GROUP BY t1.`DepartmentID`;
