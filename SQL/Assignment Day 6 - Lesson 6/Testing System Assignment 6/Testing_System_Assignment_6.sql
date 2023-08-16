USE `testing_system_assignemnt_1`; -- Còn câu 10 11 7 chưa xong
 
-- ______________________________________________________________________________QUERY_________________________________________________________________________________________
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS `Question_1`;
DELIMITER $$
CREATE PROCEDURE `Question_1` (IN `p_dept_name` VARCHAR(50) )
	BEGIN
		SELECT t1.*, t2.`DepartmentName` FROM `account` t1 JOIN `department` t2 ON t1.`DepartmentID` = t2.`DepartmentID`
        WHERE t2.`DepartmentName` = `p_dept_name` ;
    END $$
DELIMITER ;

CALL `Question_1`("IT");


-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS `Question_2`;
DELIMITER $$
CREATE  PROCEDURE `Question_2`()
	BEGIN 
		SELECT t1.*, COUNT(t2.`AccountID`) AS `Quanlity`
		FROM `group` t1 LEFT JOIN `groupaccount` t2 ON t1.`GroupID` = t2.`GroupID`
		GROUP BY t1.`GroupID`
        ORDER BY t1.`GroupID`;
	END $$
DELIMITER ;
CALL `Question_2`;

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DROP PROCEDURE IF EXISTS `Question_3`;
DELIMITER $$
CREATE PROCEDURE `Question_3`()
	BEGIN 
		SELECT t1.*, COUNT(t2.`QuestionID`) AS `Quanlity`
		FROM `typequestion` t1 LEFT JOIN `question` t2 ON t1.`TypeID` = t2.`TypeID`
		WHERE MONTH(t2.`CreateDate`) = MONTH(NOW()) AND YEAR(t2.`CreateDate`) = YEAR(NOW())
		GROUP BY t1.`TypeID`
		ORDER BY t1.`TypeID`;
    END $$
DELIMITER ;
CALL `Question_3`;

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS `Question_4`;
DELIMITER $$

CREATE PROCEDURE `Question_4`(OUT `p_out_typeid` INT, OUT `p_out_typename` VARCHAR(50))
    BEGIN
		WITH 
		`CountQuestion` 
        AS (
			SELECT COUNT(t2.`QuestionID`) AS `Quanlity` FROM `typequestion` t1 LEFT JOIN `question` t2 ON t1.`TypeID` = t2.`TypeID` 
			GROUP BY t1.`TypeID`
		)
		SELECT t1.`TypeID`, t1.`TypeName` INTO `p_out_typeid`, `p_out_typename` FROM `typequestion` t1 LEFT JOIN `question` t2 ON t1.`TypeID` = t2.`TypeID` 
		GROUP BY t1.`TypeID`
		HAVING  COUNT(t2.`QuestionID`) = ( SELECT MAX(`Quanlity`) FROM `CountQuestion` )
		ORDER BY t1.`TypeID`;
    END $$
DELIMITER ;

SET @testVarQuestion4_ID = 0, @testVarQuestion4_Name = "";
CALL `Question_4`(@testVarQuestion4_ID, @testVarQuestion4_Name);
SELECT @testVarQuestion4_ID  AS `Top_1_TypeID`, @testVarQuestion4_Name AS `Top_1_TypeName`;

SELECT `GroupName` AS `Result` FROM `group` 
			WHERE LOCATE("Bayern", `GroupName`)
			UNION
			SELECT `FullName` FROM `account` 
			WHERE LOCATE("Ngo", `FullName`);

/* Question 6: 
Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào 
hoặc trả về user có username chứa chuỗi của người dùng nhập vào */
DROP PROCEDURE IF EXISTS `Question_6`;
DELIMITER $$
CREATE PROCEDURE `Question_6`(IN  `p_in_Name` VARCHAR(50), OUT `p_out_Name` VARCHAR(50) )
	BEGIN 
			SELECT `Result` INTO `p_out_Name` FROM 
				(SELECT `GroupName` AS `Result` FROM `group` 
				WHERE LOCATE(`p_in_Name`, `GroupName`)
				UNION
				SELECT `FullName` FROM `account` 
				WHERE LOCATE(`p_in_Name`, `FullName`) )AS `ResultTable`
			LIMIT 1; -- LIMIT 1 để có thể output ra 1 record chứ không phải 1 table 
    END $$
DELIMITER ;

SET @testVarQuestion_6 = "";
CALL `Question_6`("Ngo", @testVarQuestion_6);
SELECT @testVarQuestion_6;

/*
Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
Sau đó in ra kết quả tạo thành công
*/
DROP PROCEDURE IF EXISTS `Question_7`;
DELIMITER $$
	CREATE PROCEDURE `Question_7`(IN `p_in_FullName` VARCHAR(50), IN `p_in_Email` VARCHAR(50))
    BEIGN
		SELECT * FROM `account`;
    END$$
DELIMITER ;


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS `Question_8`;
DELIMITER $$
CREATE PROCEDURE `Question_8`(IN `p_in_FullName` ENUM("Essay", "Multiple-Choice"))
BEGIN
    SELECT t1.`TypeName`, t2.`Content`, CHAR_LENGTH(t2.`Content`) AS `Length`
    FROM `typequestion` t1
    JOIN `question` t2 ON t1.`TypeID` = t2.`TypeID`
    WHERE t1.`TypeName` = `p_in_FullName`
    GROUP BY t1.`TypeName`, t2.`Content`, `Length`
    HAVING `Length` = (
        SELECT MAX(`LENGTH`)
        FROM (
            SELECT CHAR_LENGTH(`content`) AS `LENGTH`
            FROM `typequestion` t3 
            JOIN `question` t4 ON t3.`TypeID` = t4.`TypeID`
            WHERE t3.`TypeName` = `p_in_FullName`
        ) AS `LengthTable`
    );
END $$
DELIMITER ;
CALL `Question_8`("Essay");

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

INSERT INTO `exam` 
(
	`ExamID`,
    `Code`,
    `Title`,
    `CategoryID`,
    `Duration`,
    `CreatorID`,
    `CreateDate`
)
VALUES (11, 11, "Calculus-2 Exam", 2, 90, 2, "2023-8-16");

DROP PROCEDURE IF EXISTS `Question_9`;
DELIMITER $$
CREATE PROCEDURE `Question_9`(IN `p_in_id` INT)
	BEGIN 
		DELETE FROM `exam`
        WHERE `ExamID` = `p_in_id`;
    END $$
DELIMITER ;
CALL `Question_9`(11);

SELECT * FROM `exam`;

/*
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
Sau đó in số lượng record đã remove từ các table liên quan trong khi removing */

SELECT * FROM `exam` 
WHERE YEAR(NOW()) - YEAR(`CreateDate`)  > 3;





/* Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc*/

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS `Question_12`;
DELIMITER $$
	CREATE PROCEDURE `Question_12`()
		BEGIN
			SELECT MONTH(`CreateDate`) AS `Month` , COUNT(`QuestionID`) AS `Quanlity` FROM `Question`
			WHERE YEAR(`CreateDate`) = YEAR(NOW())
			GROUP BY MONTH(`CreateDate`);
        END $$
DELIMITER ;
CALL `Question_12`;


SELECT * FROM `Question`;
UPDATE `Question`
SET 
	`CreateDate` = "2023-05-02"
WHERE `QuestionID` = 5;
/* Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng") */

DROP PROCEDURE IF EXISTS `Question_13`;
DELIMITER $$
	CREATE PROCEDURE `Question_13`()
		BEGIN
			SELECT t1.`Month`,t2.`Year`, IFNULL(t2.`Quanlity`, "Không tìm thấy câu hỏi") AS `Quanlity`
            FROM (
				SELECT MONTH(DATE_SUB(NOW(), INTERVAL i MONTH)) AS `Month`
				 FROM (SELECT 6 AS i UNION SELECT 5 UNION SELECT 4 UNION SELECT 3 UNION SELECT 2 UNION SELECT 1 UNION SELECT 0) AS `month_intervals`
            ) t1
			LEFT JOIN (
				SELECT 
					MONTH(`CreateDate`) AS `Month` ,
					YEAR(`CreateDate`) AS `Year`, 
					COUNT(`QuestionID`)  AS `Quanlity`
				FROM `Question`
				WHERE 
					`CreateDate` >= DATE_SUB(NOW(), INTERVAL 6 MONTH) 
					/* Tồn tại 1 nhược điểm -> Nếu hiện tại là 16/8/2023 -> 12/2023 vẫn được hiển thị 
					CreateDate (ngày tạo) có giá trị lớn hơn hoặc bằng ngày hiện tại trừ đi 6 tháng. */
				GROUP BY `Month`, `Year`) t2  ON t1.`Month` = t2.`Month`
            ;
        END $$
DELIMITER ;
CALL `Question_13`;