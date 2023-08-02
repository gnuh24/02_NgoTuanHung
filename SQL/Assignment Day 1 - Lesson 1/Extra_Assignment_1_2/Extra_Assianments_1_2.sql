DROP DATABASE IF EXISTS  `Trainee`;
CREATE DATABASE IF NOT EXISTS `Trainee`;
USE `Trainee`;

-- Exercise 1
DROP TABLE IF EXISTS `Trainee`;
CREATE TABLE IF NOT EXISTS `Trainee` (
    TraineeID INT AUTO_INCREMENT,
    Full_Name VARCHAR(255),
    Birth_Data DATE,
    Gender ENUM('Male', 'Female', 'Unknown'),
    ET_IQ TINYINT CHECK (ET_IQ >= 0 AND ET_IQ <= 20),
    ET_Gmath TINYINT CHECK (ET_Gmath >= 0 AND ET_Gmath <= 20),
    ET_English TINYINT CHECK (ET_English >= 0 AND ET_English <= 50),
    Training_Class INT,
    Evaluation_Notes VARCHAR(255),
    PRIMARY KEY (TraineeID)
);

ALTER TABLE `Trainee`
ADD COLUMN `VTI_Account` VARCHAR(255) NOT NULL UNIQUE KEY;

-- Exercise 2
DROP TABLE IF EXISTS `Exercise_2`;
CREATE TABLE IF NOT EXISTS `Exercise_2` (
    ID INT AUTO_INCREMENT,
    Name VARCHAR(255),
    Code CHAR(5),
    ModifiedDate DATETIME,
    PRIMARY KEY (ID)
);

-- Exercise 3
DROP TABLE IF EXISTS  `Exercise_3`;
CREATE TABLE IF NOT EXISTS `Exercise_3` (
    ID INT AUTO_INCREMENT,
    Name VARCHAR(255),
    BirthDate DATE,
    Gender TINYINT CHECK (Gender = 0 OR Gender = 1
        OR Gender = NULL),
    IsDeletedFlag TINYINT CHECK (IsDeletedFlag = 0 OR IsDeletedFlag = 1),
    PRIMARY KEY (ID)
);


