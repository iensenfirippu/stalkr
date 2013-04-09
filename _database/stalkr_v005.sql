DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `description`;
DROP TABLE IF EXISTS `report`;

CREATE TABLE IF NOT EXISTS `user` (
	`guid` VARCHAR(50) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`displayname` VARCHAR(50) NOT NULL,
	`firstname` VARCHAR(50) NULL,
	`lastname` VARCHAR(50) NULL,
	`password` VARCHAR(255) NOT NULL,
	`birthday` INT(11) NULL,
	`location_latitude` FLOAT(11) NOT NULL,
	`location_longitude` FLOAT(11) NOT NULL,
	`location_timestamp` INT(11) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`info_description` VARCHAR(50) NOT NULL,
	`pref_description` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`guid`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE IF NOT EXISTS `description` (
	`guid` VARCHAR(50) NOT NULL,
	`timestamp` INT(11) NOT NULL,
	`country` VARCHAR(255) NULL,
	`region` VARCHAR(255) NULL,
	`city` VARCHAR(255) NULL,
	`age` INT(11) NULL,
	`age_max` INT(11) NULL,
	`gender` VARCHAR(255) NULL,
	`smoking` VARCHAR(255) NULL,
	`drinking` VARCHAR(255) NULL,
	`orientation` VARCHAR(255) NULL,
	PRIMARY KEY (`guid`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE IF NOT EXISTS `report` (
	`guid` VARCHAR(50) NOT NULL,
	`timestamp` INT(11) NOT NULL,
	`reporter` INT(11) NOT NULL,
	`reportee` INT(11) NOT NULL,
	`description` BLOB NOT NULL,
	PRIMARY KEY (`guid`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

INSERT INTO `user` (
	`guid`,`username`,`displayname`,
	`firstname`,`lastname`,`password`,
	`birthday`,`location_latitude`,`location_longitude`,
	`location_timestamp`,`email`,`info_description`,
	`pref_description`
) VALUES (
	'edea3e9a-da70-4a52-b1be-68df86b1afda','JohnDoe69','John',
	'John','Doe','1234',
	'000000123','10.5','5.10',
	'123456789','johndoe@jubiipost.dk','8b9e9d44-4411-434f-b5cc-5b803a3dc4f6',
	'57008f04-b8e3-464b-8253-1fa44fcea113'
);

INSERT INTO `user` (
	`guid`,`username`,`displayname`,
	`firstname`,`lastname`,`password`,
	`birthday`,`location_latitude`,`location_longitude`,
	`location_timestamp`,`email`,`info_description`,
	`pref_description`
) VALUES (
	'1A6747B2-931C-11E2-AE68-D7146188709B','Jonazzy','Jonaz',
	'Jonaz','van der Zee','9876',
	'716016155','3.12','7.14',
	'1363372404','phandazee@gmail.com','57008f04-b8e3-464b-8253-1fa44fcea113',
	'8b9e9d44-4411-434f-b5cc-5b803a3dc4f6'
);

INSERT INTO `user` (
	`guid`,`username`,`displayname`,
	`firstname`,`lastname`,`password`,
	`birthday`,`location_latitude`,`location_longitude`,
	`location_timestamp`,`email`,`info_description`,
	`pref_description`
) VALUES (
	'23CD373A-931C-11E2-9415-DB146188709B','JamesJohnson43','James',
	'James','Johnson','3456',
	'378022125','12.4','2.2',
	'1361366653','jamesjohnson@jubiipost.dk','46A67624-922F-11E2-BCE5-CCDF6088709B',
	'BC31A932-922E-11E2-8807-10DF6088709B'
);

INSERT INTO `user` (
	`guid`,`username`,`displayname`,
	`firstname`,`lastname`,`password`,
	`birthday`,`location_latitude`,`location_longitude`,
	`location_timestamp`,`email`,`info_description`,
	`pref_description`
) VALUES (
	'2AED9276-931C-11E2-9857-DC146188709B','Bertamus','Berta',
	'Berta','Larsen','4567',
	'16182966','13.12','14.2',
	'1362708354','bertamus@jubiipost.dk','BC31A932-922E-11E2-8807-10DF6088709B',
	'722BFD5E-931B-11E2-9A5C-54146188709B'
);

INSERT INTO `user` (
	`guid`,`username`,`displayname`,
	`firstname`,`lastname`,`password`,
	`birthday`,`location_latitude`,`location_longitude`,
	`location_timestamp`,`email`,`info_description`,
	`pref_description`
) VALUES (
	'406A84D8-931C-11E2-9C5D-E0146188709B','Martin6','Martin',
	'Martin','Hansen','5678',
	'469465670','42.2','3.4',
	'1359713436','martinhansen@jubiipost.dk','88D264EE-931B-11E2-9ECD-5E146188709B',
	'918446D4-931B-11E2-A016-67146188709B'
);

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
	'8b9e9d44-4411-434f-b5cc-5b803a3dc4f6','123456789','1',
	'1','1','25',
	'30','0','0',
	'0','1'
);

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
	'57008f04-b8e3-464b-8253-1fa44fcea113','123456789','1',
	'1','1','20',
	'24','1','0',
	'0','0'
);

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    'BC31A932-922E-11E2-8807-10DF6088709B', '123456789', '1',
	'1','1','20',
	'30','0','0',
	'0','1'
);	

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '46A67624-922F-11E2-BCE5-CCDF6088709B', '123456789', '1',
	'2','4','67',
	'98','1','1',
	'1','2'
);	

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '7B8A365A-922F-11E2-817C-F5DF6088709B', '123456789', '1',
	'4','3','45',
	'60','1','0',
	'0','2'
);

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '722BFD5E-931B-11E2-9A5C-54146188709B', '123456789', '1',
	'3','3','22',
	'33','1','1',
	'1','1'
);

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '7AC0328C-931B-11E2-B398-56146188709B', '123456789', '1',
	'4','2','47',
	'69','1','1',
	'1','3'
);

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '839DA2C2-931B-11E2-B015-5D146188709B', '123456789', '1',
	'2','1','22',
	'45','1','0',
	'1','2'
);

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '88D264EE-931B-11E2-9ECD-5E146188709B', '123456789', '1',
	'2','5','43',
	'55','1','1',
	'1','2'
);

	INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '918446D4-931B-11E2-A016-67146188709B', '123456789', '1',
	'4','3','77',
	'98','0','0',
	'0','2'
);


INSERT INTO `report` (
	`guid`,`timestamp`,`reporter`,`reportee`,`description`
) VALUES (
	'1b05a678-593f-4929-9c4b-7bb3a1c259fd','123456789','1','1','Blah blah blah'
);