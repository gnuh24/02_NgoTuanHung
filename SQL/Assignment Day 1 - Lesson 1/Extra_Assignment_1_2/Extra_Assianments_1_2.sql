DROP DATABASE IF EXISTS  `Trainee`;
CREATE DATABASE IF NOT EXISTS `Trainee`;
USE `Trainee`;

-- Exercise 1
DROP TABLE IF EXISTS `Trainee`;
CREATE TABLE IF NOT EXISTS `Trainee` (
    `TraineeID` TINYINT UNSIGNED AUTO_INCREMENT,
    `Full_Name` NVARCHAR(50) NOT NULL,
    `Birth_Date` DATE,
    `Gender` ENUM('Male', 'Female', 'Unknown') NOT NULL,
    `ET_IQ` TINYINT CHECK (ET_IQ >= 0 AND ET_IQ <= 20) NOT NULL,
    `ET_Gmath` TINYINT CHECK (ET_Gmath >= 0 AND ET_Gmath <= 20) NOT NULL,
    `ET_English` TINYINT CHECK (ET_English >= 0 AND ET_English <= 50) NOT NULL,
    `Training_Class` CHAR(6) NOT NULL,
    `Evaluation_Notes` NVARCHAR(255) NOT NULL,
    PRIMARY KEY (TraineeID)
);

ALTER TABLE `Trainee`
ADD COLUMN `VTI_Account` VARCHAR(255) NOT NULL UNIQUE KEY;

-- Exercise 2
DROP TABLE IF EXISTS `Exercise_2`;
CREATE TABLE IF NOT EXISTS `Exercise_2` (
    `ID` TINYINT UNSIGNED AUTO_INCREMENT,
    `Name` NVARCHAR(50),
    `Code` CHAR(5),
    `ModifiedDate` DATETIME DEFAULT NOW(),
    PRIMARY KEY (ID)
);

-- Exercise 3
DROP TABLE IF EXISTS  `Exercise_3`;
CREATE TABLE IF NOT EXISTS `Exercise_3` (
    `ID` TINYINT UNSIGNED AUTO_INCREMENT,
    `Name`NVARCHAR(50),
    `BirthDate` DATE,
    `Gender` ENUM("0","1","2"),
    `IsDeletedFlag` ENUM("0","1"),
    PRIMARY KEY (ID)
);


