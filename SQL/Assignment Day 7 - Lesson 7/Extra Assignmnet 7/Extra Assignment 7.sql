USE `Extra_Assignment_6`;

/* 
Exercise 1: Tiếp tục với Database ở buổi 6
Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp
lệ
(Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)
*/
DROP TRIGGER IF EXISTS `Question_1`;
DELIMITER $$
CREATE TRIGGER `Question_1`
BEFORE INSERT ON `ProjectModules`
FOR EACH ROW
	BEGIN 
		
        DECLARE `out_ProjectStartDate` DATE;
		DECLARE `out_ProjectCompletedOn` DATE;
        
		SELECT t2.`ProjectStartDate`, t2.`ProjectCompletedOn` INTO  `out_ProjectStartDate`, `out_ProjectCompletedOn`
        FROM `ProjectModules` t1 JOIN `Projects` t2 ON t1.`ProjectID` = t2.`ProjectID`
        WHERE  t2.`ProjectID` = NEW.`ProjectID`
        LIMIT 1;
	
    
		IF NEW.`ProjectModuleDate` < `out_ProjectStartDate` THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Ngày bắt đầu không được đặt trước thời gian bắt đầu của Project';
		ELSEIF NEW.`ProjectModuleCompletedOn` > `out_ProjectCompletedOn` THEN
			SIGNAL SQLSTATE '45001'
			SET MESSAGE_TEXT = 'Ngày kết thúc không được đặt sau thời gian kết thúc của Project';
		END IF;
    END $$
DELIMITER ;


INSERT INTO `projectmodules`(ModuleID, ProjectID, EmployeeID, ProjectModuleDate, ProjectModuleDescription, ProjectModuleCompletedOn)
VALUES (11, 2, 4, "2022-04-02", "Test1", "2024-02-04");


DELETE FROM `ProjectModules`
WHERE `ModuleID` = 11;



