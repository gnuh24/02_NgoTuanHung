 USE `testing_system_assignment_1`;

-- Question 1: Thêm ít nhất 10 record vào mỗi table -> Đã làm ở Assignment 2
-- Question 2: lấy ra tất cả các phòng ban 

SELECT * FROM  `department`;


-- Question 3: lấy ra id của phòng ban "Sales"

SELECT DepartmentID FROM `department` WHERE DepartmentName = "Sales";

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * FROM `account`
WHERE CHAR_LENGTH(FullName) = (
	SELECT MAX(CHAR_LENGTH(FullName)) FROM `account`
);


-- Question 5 !!!: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3

/*
Code 1: SAI 
- Vì subQuery bên trong sẽ tìm ra được record có full name dài nhất thuộc ID = 3 NHƯNG nó sẽ chỉ trả về độ dài ra ngoài (giả sử = 8)
. Rồi sau đó outer query sẽ tìm tất cả bảng ghi co full name = 8 mà in ra mà không xét điều kiện ID = 3

 */

SELECT *
FROM `account`
WHERE  CHAR_LENGTH(FullName) = (
    SELECT MAX(CHAR_LENGTH(FullName))
    FROM `account`
    WHERE DepartmentID = 3
) ;


/*
Code 2: SAI 
- Vì subQuery bên trong sẽ tìm record có fullname dài nhất và trả về ra bên ngoài (VD: độ dài = 12). 
Sau đó outer Query sẽ tìm các record có cùng độ dài = 12 VÀ DepartmentID = 3
-> Nếu hên thì subQuery đưa ra được record có fullName dài nhất và DepartmentID = 3 -> Code đúng
-> Xui thì subQuery đưa ra được record có fullName dài nhất và DepartmentID != 3 -> Code sai
 */
SELECT *
FROM `account`
WHERE  CHAR_LENGTH(FullName) = (
    SELECT MAX(CHAR_LENGTH(FullName))
    FROM `account`
) AND DepartmentID = 3;


/*
Code 3: ĐÚNG
 */
SELECT *
FROM `account`
WHERE  CHAR_LENGTH(FullName) = (
    SELECT MAX(CHAR_LENGTH(FullName))
    FROM `account`
    WHERE DepartmentID = 3
) AND DepartmentID = 3;


-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName FROM `group` WHERE `CreateDate` < "2019-12-20";



-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID, COUNT(QuestionID) FROM `answer`
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= 4
ORDER BY QuestionID;



-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT * FROM `exam` 
WHERE `CreateDate` < "2019/12/20" AND `Duration` > 60;



-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT 
    *
FROM
    `group`
ORDER BY CreateDate DESC
LIMIT 5;



-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(*)
FROM `account` 
WHERE `DepartmentID` = 2;



-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `account` WHERE FullName LIKE "D%" AND "%o";



-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM `exam` WHERE `CreateDate` < "2019-12-20";



-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- Lúc tạo bản để Content là Varchar nên chúng ta dùng "cau hoi" thay vì "câu hỏi"
DELETE FROM `question` WHERE `Content` LIKE "cau hoi";




-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `account`
SET FullName = "Nguyen Ba Loc",
	Email = "loc.nguyenba@vti.com.vn"
WHERE `AccountID` = 5;



-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `groupaccount` 
SET 
    GroupID = 4
WHERE
    `AccountID` = 5;

