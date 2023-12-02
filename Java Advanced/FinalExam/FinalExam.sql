DROP DATABASE IF EXISTS `FinalExam`;
CREATE DATABASE IF NOT EXISTS `FinalExam`;
USE `FinalExam`;
DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account`(
		`id`					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		`username`				VARCHAR(50) NOT NULL UNIQUE KEY,
		`password` 				VARCHAR(800) NOT NULL,
		`first_name`			NVARCHAR(50) NOT NULL,
		`last_name`				NVARCHAR(50) NOT NULL,
		`role` 					ENUM('USER','ADMIN') NOT NULL DEFAULT 'USER',
		`created_date`      	DATETIME DEFAULT NOW()
);

/* Account: 
		- Search: Username, FirstName, LastName
		- AccountFillerForm:
				+ createDate
				+ minDate
                + maxDate
                + role (USER or ADMIN) 
                
		- AccountCreateForm:
				+ username
				+ password
                + firstname
                + lastname
                
                
		- AccountUpdateForm:
                + username
				+ password
                + firstname
                + lastname
                + role
                
                
	Lego: 
		- Search: name
		- LegoFillerForm:
        
			+ Type
            
            + minPieces
            + maxPieces
            
            + createDate
            + minDate
            + maxDate
            
            + minPrice
            + maxPrice
            
		- LegoCreateForm, LegoUpdateForm
			+ name
            + numberOfPieces
            + type
            + Price
		
*/


DROP TABLE IF EXISTS `Lego`;
CREATE TABLE IF NOT EXISTS `Lego`(
		`id`					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		`name` 					NVARCHAR(255) NOT NULL,
        `piece`					INT UNSIGNED NOT NULL,
		`type` 					ENUM('NINJAGO', 'CHIMA', 'CITY') NOT NULL,
        `price`					INT UNSIGNED NOT NULL,
		`created_date`			DATETIME DEFAULT NOW()
);      


INSERT INTO `Account`(	username		,						`password`									,	first_name	,	last_name		,		`role`		,		`created_date`				)
VALUES 				(	'dangblack'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Hai'	,	'Dang'		,		'USER'		,		'2018-12-04'			),
					(	'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Quang'	,	'Anh'		,		'ADMIN'		,		'2018-12-09'			),
                    (	'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran Van'		,	'Chien'		,		'USER'		,		'2018-10-04'			),
                    (	'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Co'		,	'Co'		,		'USER'		,		'2019-12-04'			),
                    (	'doccocaubai'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Doc'	,	'Co'		,		'USER'		,		'2018-12-04'			),
                    (	'khabanh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan Kha'		,	'Bang'		,		'USER'		,		'2020-04-04'			),
                    (	'huanhoahong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran Van'		,	'Huan'		,		'USER'		,		'2022-01-26'			),
                    (	'tungnui'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen Tung'	,	'Nui'		,		'USER'		,		'2016-06-04'			),
                    (	'duongghuu'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan Duong'	,	'Huu'		,		'USER'		,		'2023-10-04'			),
                    (	'vtiaccademy'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'			,	'Academy'	,		'ADMIN'		,		'2017-03-04'			),
					(	'thug24'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Ngo Tuan'		,	'Hung'		,		'ADMIN'		,		'2004-04-02'			);
               
               
             

INSERT INTO `Lego` 	(`name`								, `piece`			, `price` 	,`type`		, `created_date`) VALUES
					('Destiny Bounty'					, 1781				, 104		,'NINJAGO'	,	'2018-12-04'),
					('Fire Temple'						, 1174				, 711 		,'NINJAGO'	, '2016-06-04'	),
					('Police Station'					, 854				, 56		,'CITY'		, '2020-06-10'	),
					('The Lion Chi Temple'				, 1258				, 200		,'CHIMA'	, '2016-04-04'	),
					('Airport'							, 703				, 200		,'CITY'		, '2015-12-02'	),
					('Great Vehicles Pickup Tow Truck'	, 209				, 350		,'CITY'		, '2015-11-04'	),
					('Battle For Ninjago City'			, 1223				, 1000		,'NINJAGO' 	, '2014-01-02'	)






