USE `trainee`;


-- Question 1 Import 50 record vào bảng
INSERT INTO `trainee` (TraineeID, Full_Name,  Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes, VTI_Account)
VALUES 
	(130, "NgoTuanHung1", "2004-04-02", "Male", 20, 20, 50, "DKP130", "Good", "ROCKET38-02"),
    (131, "NgoTuanHung2", "2002-03-10", "Female", 16, 18, 45, "DKP131", "Average", "ROCKET38-13"),
    (132, "NgoTuanHung3", "2001-07-22", "Male", 15, 17, 43, "DKP132", "Excellent", "ROCKET38-14"),
    (133, "NgoTuanHung4", "2003-12-05", "Female", 17, 16, 49, "DKP133", "Good", "ROCKET38-15"),
    (134, "NgoTuanHung5", "2002-06-30", "Male", 19, 15, 48, "DKP134", "Average", "ROCKET38-16"),
    (135, "NgoTuanHung6", "2001-10-18", "Female", 16, 18, 45, "DKP135", "Excellent", "ROCKET38-17"),
    (136, "NgoTuanHung7", "2000-08-12", "Male", 17, 19, 47, "DKP136", "Good", "ROCKET38-18"),
    (137, "NgoTuanHung8", "2003-02-25", "Female", 15, 17, 43, "DKP137", "Average", "ROCKET38-19"),
    (138, "NgoTuanHung9", "2004-05-08", "Male", 18, 16, 49, "DKP138", "Excellent", "ROCKET38-20"),
	(139, "NgoTuanHung10", "2000-01-15", "Male", 18, 19, 47, "DKP139", "Good", "ROCKET38-12"),
    
    (140, "NgoTuanHung11", "2002-09-18", "Male", 12, 13, 35, "DKP140", "Good", "ROCKET38-21"),
    (141, "NgoTuanHung12", "2003-04-25", "Female", 14, 15, 40, "DKP141", "Average", "ROCKET38-22"),
    (142, "NgoTuanHung13", "2001-11-30", "Male", 16, 17, 43, "DKP142", "Excellent", "ROCKET38-23"),
    (143, "NgoTuanHung14", "2000-07-12", "Female", 18, 19, 46, "DKP143", "Bad", "ROCKET38-24"),
    (144, "NgoTuanHung15", "2004-03-02", "Male", 20, 20, 50, "DKP144", "Good", "ROCKET38-25"),
    (145, "NgoTuanHung16", "2003-06-08", "Female", 19, 18, 48, "DKP145", "Average", "ROCKET38-26"),
    (146, "NgoTuanHung17", "2002-10-14", "Male", 18, 17, 46, "DKP146", "Excellent", "ROCKET38-27"),
    (147, "NgoTuanHung18", "2001-08-20", "Female", 17, 16, 44, "DKP147", "Bad", "ROCKET38-28"),
    (148, "NgoTuanHung19", "2000-12-26", "Male", 16, 15, 42, "DKP148", "Good", "ROCKET38-29"),
    (149, "NgoTuanHung20", "2004-02-07", "Male", 15, 14, 40, "DKP149", "Average", "ROCKET38-30"),
    
    (150, "NgoTuanHung21", "2003-09-10", "Female", 14, 13, 38, "DKP150", "Excellent", "ROCKET38-31"),
    (151, "NgoTuanHung22", "2002-04-15", "Male", 13, 12, 36, "DKP151", "Bad", "ROCKET38-32"),
    (152, "NgoTuanHung23", "2001-11-20", "Male", 12, 11, 34, "DKP152", "Good", "ROCKET38-33"),
    (153, "NgoTuanHung24", "2000-06-25", "Female", 11, 10, 32, "DKP153", "Average", "ROCKET38-34"),
    (154, "NgoTuanHung25", "2004-03-01", "Male", 10, 9, 30, "DKP154", "Excellent", "ROCKET38-35"),
    (155, "NgoTuanHung26", "2003-08-06", "Female", 9, 8, 28, "DKP155", "Bad", "ROCKET38-36"),
    (156, "NgoTuanHung27", "2002-01-11", "Male", 8, 7, 26, "DKP156", "Good", "ROCKET38-37"),
    (157, "NgoTuanHung28", "2001-10-16", "Female", 7, 6, 24, "DKP157", "Average", "ROCKET38-38"),
    (158, "NgoTuanHung29", "2000-05-21", "Male", 6, 5, 22, "DKP158", "Excellent", "ROCKET38-39"),
    (159, "NgoTuanHung30", "2004-02-26", "Male", 5, 4, 20, "DKP159", "Bad", "ROCKET38-40"),
	

	(160, "NgoTuanHung31", "2003-09-18", "Male", 14, 15, 40, "DKP160", "Good", "ROCKET38-41"),
    (161, "NgoTuanHung32", "2002-04-25", "Female", 12, 13, 35, "DKP161", "Average", "ROCKET38-42"),
    (162, "NgoTuanHung33", "2001-11-30", "Male", 10, 11, 30, "DKP162", "Excellent", "ROCKET38-43"),
    (163, "NgoTuanHung34", "2000-07-12", "Female", 8, 9, 25, "DKP163", "Bad", "ROCKET38-44"),
    (164, "NgoTuanHung35", "2004-03-02", "Male", 6, 7, 20, "DKP164", "Good", "ROCKET38-45"),
    (165, "NgoTuanHung36", "2003-08-08", "Female", 4, 5, 15, "DKP165", "Average", "ROCKET38-46"),
    (166, "NgoTuanHung37", "2002-01-15", "Male", 2, 3, 10, "DKP166", "Excellent", "ROCKET38-47"),
    (167, "NgoTuanHung38", "2001-10-22", "Female", 18, 19, 46, "DKP167", "Bad", "ROCKET38-48"),
    (168, "NgoTuanHung39", "2000-06-30", "Male", 16, 17, 44, "DKP168", "Good", "ROCKET38-49"),
    (169, "NgoTuanHung40", "2004-03-01", "Male", 14, 15, 42, "DKP169", "Average", "ROCKET38-50"),
    
    (170, "NgoTuanHung41", "2003-08-08", "Female", 12, 13, 40, "DKP170", "Excellent", "ROCKET38-51"),
    (171, "NgoTuanHung42", "2002-01-15", "Male", 10, 11, 38, "DKP171", "Bad", "ROCKET38-52"),
    (172, "NgoTuanHung43", "2001-10-22", "Male", 8, 9, 36, "DKP172", "Good", "ROCKET38-53"),
    (173, "NgoTuanHung44", "2000-06-30", "Female", 6, 7, 34, "DKP173", "Average", "ROCKET38-54"),
    (174, "NgoTuanHung45", "2004-03-01", "Male", 4, 5, 32, "DKP174", "Excellent", "ROCKET38-55"),
    (175, "NgoTuanHung46", "2003-08-08", "Female", 2, 3, 30, "DKP175", "Bad", "ROCKET38-56"),
    (176, "NgoTuanHung47", "2002-01-15", "Male", 20, 20, 50, "DKP176", "Good", "ROCKET38-57"),
    (177, "NgoTuanHung48", "2001-10-22", "Female", 18, 18, 48, "DKP177", "Average", "ROCKET38-58"),
    (178, "NgoTuanHung49", "2000-06-30", "Male", 16, 16, 46, "DKP178", "Excellent", "ROCKET38-59"),
    (179, "NgoTuanHung50", "2004-03-01", "Male", 14, 14, 44, "DKP179", "Bad", "ROCKET38-60");
    
    
-- Question 2 Ở đây chúng ta sẽ xem như là tất cả các dữ liệu được nhập vào bảng đã vượt qua bài test đầu vào vì đề không cho rõ điều kiện.
SELECT MONTH(Birth_Date), COUNT(MONTH(Birth_Date)) FROM `trainee`
GROUP BY MONTH(Birth_Date)
ORDER BY MONTH(Birth_Date);    

-- Question 3 Lấy ra thực tập sinh có tên dài nhất

-- Cách 1: Dùng Subquery
SELECT 
    *
FROM
    `trainee`
WHERE
    (Full_Name = (SELECT 
            Full_Name
        FROM
            `trainee`
        GROUP BY Full_Name
        HAVING MAX(CHAR_LENGTH(Full_Name))
        LIMIT 1));

-- Cách 2 non-Subquery
    
-- Question 4 Lấy ra tất cả các thực tập sinh ET đã vượt qua bài test đầu vào và đạt được điểm như bên dưới 
SELECT * 
FROM `trainee`
WHERE ET_IQ + ET_Gmath >= 20 AND ET_IQ >= 8 AND ET_Gmath >= 8 AND ET_English>=18;



-- Question 5 Xóa thực tập sinh có trainee ID = 3

-- INSERT Thực tập sinh có trainee ID = 3 vào rồi xóa (Nếu chưa có thực tập sinh nào có ID = 3)
INSERT INTO `trainee`
VALUES (3, "NgoTuanHung00", "2004-03-01", "Male", 14, 14, 44, "DKP000", "Bad", "ROCKET38-00");

DELETE FROM `trainee` WHERE TraineeID = 3;



-- Question 6 Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
INSERT INTO `trainee`
VALUES (5, "NgoTuanHung999", "2004-03-01", "Male", 14, 14, 44, "DKP999", "Bad", "ROCKET38-999");

UPDATE `trainee`
SET 
	Training_Class = "DKP005"
;