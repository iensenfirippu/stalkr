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
	`info_description` INT(11) NOT NULL,
	`pref_description` INT(11) NOT NULL,
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
#	`ethnicity` VARCHAR(255) NULL,
#	`nationality` VARCHAR(255) NULL,
#	`religion` VARCHAR(255) NULL,
#	`zodiac` VARCHAR(255) NULL,
#	`chi_zodiac` VARCHAR(255) NULL,
#	`bloodtype` VARCHAR(255) NULL,
#	`bodytype` VARCHAR(255) NULL,
#	`height` INT(11) NULL,
#	`height_max` INT(11) NULL,
#	`weight` INT(11) NULL,
#	`weight_max` INT(11) NULL,
#	`haircolor` VARCHAR(255) NULL,
#	`eyecolor` VARCHAR(255) NULL,
#	`skincolor` VARCHAR(255) NULL,
#	`tattoo` VARCHAR(255) NULL,
#	`piercing` VARCHAR(255) NULL,

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
	'UniqueID','JohnDoe69','John',
	'John','Doe','1234',
	'000000123','10.5','5.10',
	'123456789','johndoe@jubiipost.dk','1',
	'2'
);

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
	'uniquekey1','123456789','1',
	'1','1','25',
	'0','1','0',
	'0','1'
);
#	,`ethnicity,`nationality`,`religion`,
#	`zodiac`,`chi_zodiac`,`bloodtype`,
#	`bodytype`,`height`,`height_max`,
#	`weight`,`weight_max`,`haircolor`,
#	`eyecolor`,`skincolor`,`tattoo`,
#	`piercing`
#	,'1','1','1',
#	'1','1','1',
#	'1','1','1',
#	'1','180','0'
#	,'70','0','1',
#	'1','1','1',
#	'1'

INSERT INTO `description` (
	`guid`,`timestamp`,`country`,
	`region`,`city`,`age`,
	`age_max`,`gender`,`smoking`,
	`drinking`,`orientation`
) VALUES (
	'uniquekey2','123456789','1',
	'1','1','20',
	'30','1','0',
	'0','1'
);
#	,`ethnicity,`nationality`,`religion`,
#	`zodiac`,`chi_zodiac`,`bloodtype`,
#	`bodytype`,`height`,`height_max`,
#	`weight`,`weight_max`,`haircolor`,
#	`eyecolor`,`skincolor`,`tattoo`,
#	`piercing`
#	,'1','1','1',
#	'1','1','1',
#	'1','1','1',
#	'1','160','200'
#	,'50','80','1',
#	'1','1','1',
#	'1'

INSERT INTO `report` (
	`guid`,`timestamp`,`reporter`,`reportee`,`description`
) VALUES (
	'NotUUID','123456789','1','1','Blah blah blah'
);