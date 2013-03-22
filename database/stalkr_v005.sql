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

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
	'8b9e9d44-4411-434f-b5cc-5b803a3dc4f6','123456789','1',
	'1','1','25',
	'30','1','0',
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
	'35','1','0',
	'0','1'
);

INSERT INTO ´description´ (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    'BC31A932-922E-11E2-8807-10DF6088709B', '123456789', '1',
	'1','1','20',
	'30','1','0',
	'0','1'
	
	INSERT INTO ´description´ (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '46A67624-922F-11E2-BCE5-CCDF6088709B', '123456789', '1',
	'2','4','67',
	'98','1','1',
	'1','2'
	
	INSERT INTO ´description´ (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
    '7B8A365A-922F-11E2-817C-F5DF6088709B', '123456789', '1',
	'4','3','45',
	'60','1','0',
	'0','2'


INSERT INTO `report` (
	`guid`,`timestamp`,`reporter`,`reportee`,`description`
) VALUES (
	'1b05a678-593f-4929-9c4b-7bb3a1c259fd','123456789','1','1','Blah blah blah'
);