DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`(
	DepartmentID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    DepartmentName 	VARCHAR(20)
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
	PositionID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    PositionName 	ENUM("Dev", "Test", "Scrum Master", "PM")
); 

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Email			VARCHAR(50),
    Username		VARCHAR(50),
    FullName		VARCHAR(50),
    DepartmentID	TINYINT UNSIGNED,
    PositionID		TINYINT UNSIGNED,
    CreateDate 		DATE,
	FOREIGN KEY (DepartmentID) REFERENCES `Department`(DepartmentID) ON DELETE CASCADE ,
	FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    GroupName 	VARCHAR(50),
    CreateID 	TINYINT UNSIGNED,
    CreateDate 	DATE
);

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount`(
	GroupID 	TINYINT UNSIGNED,
    AccountID 	TINYINT UNSIGNED,
    JoinDate 	DATE,
FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE ,
FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE 

);

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQUestion` (
	TypeID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    TypeName 	ENUM("Essay", "Multiple-Choice")
);

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion`(
	CategoryID 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    CategoryName 	VARCHAR(50)
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
	QuestionID 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content 	VARCHAR(500),
    CategoryID 	TINYINT UNSIGNED,
    TypeID 		TINYINT UNSIGNED,
    CreatorID 	TINYINT UNSIGNED,
    CreateDate 	DATE,
FOREIGN KEY (TypeID) REFERENCES `TypeQuestion`(TypeID) ON DELETE CASCADE ,
FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID) ON DELETE CASCADE 

);

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
	AnswerID	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Content		VARCHAR(500),
    QuestionID	TINYINT UNSIGNED,
    isCorrect	ENUM("True", "False"),
	FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID) ON DELETE CASCADE 

);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam` (
	ExamID		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Code`		TINYINT UNSIGNED,
    Title		VARCHAR(50),
    CategoryID	TINYINT UNSIGNED,
	Duration	TINYINT UNSIGNED,
    CreatorID	TINYINT UNSIGNED,
    CreateDate	DATE,
	FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID) ON DELETE CASCADE 

);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion` (
	ExamID 		TINYINT UNSIGNED,
    QuestionID 	TINYINT UNSIGNED,
    FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID) ON DELETE CASCADE ,
	FOREIGN KEY (ExamID) REFERENCES `Exam`(ExamID) ON DELETE CASCADE 
);