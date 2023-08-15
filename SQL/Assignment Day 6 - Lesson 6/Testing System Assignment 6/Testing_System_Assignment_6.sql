USE `testing_system_assignemnt_1`;

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



/* Question 6: 
Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào 
hoặc trả về user có username chứa chuỗi của người dùng nhập vào */





Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
trong store sẽ tự động gán:

username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ

Sau đó in ra kết quả tạo thành công
Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi
removing
Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc
Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
nay

2

Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
tháng")
