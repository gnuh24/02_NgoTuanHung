DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE IF NOT EXISTS Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

DROP TABLE IF EXISTS `Department`;
CREATE TABLE `Department`(
	DepartmentID 	INT PRIMARY KEY AUTO_INCREMENT,
    DepartmentName 	VARCHAR(20)
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
	PositionID 		INT PRIMARY KEY AUTO_INCREMENT,
    PositionName 	ENUM("Dev", "Test", "Scrum Master", "PM")
); 

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID 		INT PRIMARY KEY AUTO_INCREMENT,
    Email			VARCHAR(50),
    Username		VARCHAR(50),
    FullName		VARCHAR(50),
    DepartmentID	INT,
    PositionID		INT,
    CreateDate 		DATE
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 	INT PRIMARY KEY AUTO_INCREMENT,
    GroupName 	VARCHAR(50),
    CreateID 	INT,
    CreateDate 	DATE
);

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount`(
	GroupID 	INT,
    AccountID 	INT,
    JoinDate 	DATE
);

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQUestion` (
	TypeID 		INT PRIMARY KEY AUTO_INCREMENT,
    TypeName 	ENUM("Essay", "Multiple-Choice")
);

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion`(
	CategoryID 		INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName 	VARCHAR(50)
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
	QuestionID 	INT PRIMARY KEY AUTO_INCREMENT,
    Content 	VARCHAR(500),
    CategoryID 	INT,
    TypeID 		INT,
    CreatorID 	INT,
    CreateDate 	DATE
);

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
	AnswerID	INT PRIMARY KEY AUTO_INCREMENT,
    Content		VARCHAR(500),
    QUestionID	INT,
    isCorrect	ENUM("True", "False")
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam` (
	ExamID		INT PRIMARY KEY AUTO_INCREMENT,
    Code		INT,
    Title		VARCHAR(50),
    CategoryID	INT,
	Duration	INT,
    CreatorID	INT,
    CreateDate	DATE
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion` (
	ExamID 		INT,
    QuestionID 	INT
);