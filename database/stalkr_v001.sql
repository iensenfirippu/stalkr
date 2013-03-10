DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `description`;
DROP TABLE IF EXISTS `report`;

CREATE TABLE IF NOT EXISTS `user` (
	`id` INT(11) NOT NULL auto_increment,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`firstname` VARCHAR(50) NULL,
	`lastname` VARCHAR(50) NULL,
	`location_latitude` FLOAT(11) NOT NULL,
	`location_longitude` FLOAT(11) NOT NULL,
	`location_timestamp` INT(11) NOT NULL,
	`info_description` INT(11) NOT NULL,
	`pref_description` INT(11) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE IF NOT EXISTS `description` (
	`id` INT(11) NOT NULL auto_increment,
	`timestamp` INT(11) NOT NULL,
	`age` INT(11) NULL,
	`age_max` INT(11) NULL,
	`gender` VARCHAR(255) NULL,
	`birthday` INT(11) NULL,
	`smoking` VARCHAR(255) NULL,
	`drinking` VARCHAR(255) NULL,
	`orientation` VARCHAR(255) NULL,
	`ethnicity` VARCHAR(255) NULL,
	`nationality` VARCHAR(255) NULL,
	`religion` VARCHAR(255) NULL,
	`zodiac` VARCHAR(255) NULL,
	`chi_zodiac` VARCHAR(255) NULL,
	`bloodtype` VARCHAR(255) NULL,
	`country` VARCHAR(255) NULL,
	`region` VARCHAR(255) NULL,
	`city` VARCHAR(255) NULL,
	`bodytype` VARCHAR(255) NULL,
	`height` INT(11) NULL,
	`height_max` INT(11) NULL,
	`weight` INT(11) NULL,
	`weight_max` INT(11) NULL,
	`haircolor` VARCHAR(255) NULL,
	`eyecolor` VARCHAR(255) NULL,
	`skincolor` VARCHAR(255) NULL,
	`tattoo` VARCHAR(255) NULL,
	`piercing` VARCHAR(255) NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE IF NOT EXISTS `report` (
	`id` INT(11) NOT NULL auto_increment,
	`timestamp` INT(11) NOT NULL,
	`reporter` INT(11) NOT NULL,
	`reportee` INT(11) NOT NULL,
	`description` BLOB NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

INSERT INTO `user` (
	`id`,`username`,`password`,`firstname`,`lastname`,`location_latitude`,
	`location_longitude`,`location_timestamp`,
	`info_description`,`pref_description`
) VALUES (
	NULL,'JohnDoe69','1234','John','Doe','10.5','5.10',
	'123456789', '1', '2'
);

INSERT INTO `description` (
	`id`,`timestamp`,`age`,
	`age_max`,`gender`,`birthday`,`smoking`,
	`drinking`,`orientation`,`ethnicity`,
	`nationality`,`religion`,`zodiac`,`chi_zodiac`,
	`bloodtype`,`country`,`region`,`city`,`bodytype`,
	`height`,`height_max`,`weight`,`weight_max`,
	`haircolor`,`eyecolor`,`skincolor`,`tattoo`,
	`piercing`
) VALUES (
	NULL,'123456789','25','0','1',
	'000000123','1','1','1','1','1','1','1','1','1',
	'1','1','1','1','180','0','70','0','1','1','1',
	'1', '1'
);

INSERT INTO `description` (
	`id`,`timestamp`,`age`,
	`age_max`,`gender`,`birthday`,`smoking`,
	`drinking`,`orientation`,`ethnicity`,
	`nationality`,`religion`,`zodiac`,`chi_zodiac`,
	`bloodtype`,`country`,`region`,`city`,`bodytype`,
	`height`,`height_max`,`weight`,`weight_max`,
	`haircolor`,`eyecolor`,`skincolor`,`tattoo`,
	`piercing`
) VALUES (
	NULL,'123456789','20','30','2',
	NULL,'1','1','1','1','1','1','1','1','1',
	'1','1','1','1','160','200','50','80','1','1','1',
	'1', '1'
);

INSERT INTO `report` (
	`id`,`timestamp`,`reporter`,`reportee`,`description`
) VALUES (
	NULL,'123456789','1','1','Blah blah blah'
);