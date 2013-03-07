CREATE TABLE `user` (
  `id` INT(11) NOT NULL auto_increment,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `location_latitude` FLOAT(11) NOT NULL,
  `location_longitude` FLOAT(11) NOT NULL,
  `location_timestamp` INT(11) NOT NULL,
  `info_description` INT(11) NOT NULL,
  `pref_description` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE `desciption` (
  `id` INT(11) NOT NULL auto_increment,
  `timestamp INT(11) NOT NULL,

  `firstname` VARCHAR(50) NOT NULL,
  `lastname` VARCHAR(50) NOT NULL,
  `age` INT(11) NOT NULL,
  `age_max` INT(11) NOT NULL,
  `gender` VARCHAR(255) NOT NULL,
  `birthday` INT(11) NOT NULL,
  `smoking` VARCHAR(255) NOT NULL,
  `drinking` VARCHAR(255) NOT NULL,
  `orientation` VARCHAR(255) NOT NULL,
  `ethnicity` VARCHAR(255) NOT NULL,
  `nationality` VARCHAR(255) NOT NULL,
  `religion` VARCHAR(255) NOT NULL,
  `zodiac` VARCHAR(255) NOT NULL,
  `chi_zodiac` VARCHAR(255) NOT NULL,
  `bloodtype` VARCHAR(255) NOT NULL,

  `country` INT(11) NOT NULL,
  `region` INT(11) NOT NULL,
  `city` INT(11) NOT NULL,

  `bodytype` VARCHAR(255) NOT NULL,
  `height` INT(11) NOT NULL,
  `height_max` INT(11) NOT NULL,
  `weight` INT(11) NOT NULL,
  `weight_max` INT(11) NOT NULL,
  `haircolor` VARCHAR(255) NOT NULL,
  `eyecolor` VARCHAR(255) NOT NULL,
  `skincolor` VARCHAR(255) NOT NULL,
  `tattoo` VARCHAR(255) NOT NULL,
  `piercing` VARCHAR(255) NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;

CREATE TABLE report (
  `id` INT(11) NOT NULL auto_increment,
  `timestamp` INT(11) NOT NULL,
  `reporter` INT(11) NOT NULL,
  `reportee` INT(11) NOT NULL,
  `description` BLOB NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARSET=`utf8`;