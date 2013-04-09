--DROP DATABASE IF EXISTS stalkr;
--SELECT DATABASE stalkr;

CREATE TABLE 'user' (
  'id' int(11) NOT NULL auto_increment,
  'username' varchar(50) NOT NULL,
  'password' varchar(255) NOT NULL,
  'location_latitude' float(11) NOT NULL,
  'location_longitude' float(11) NOT NULL,
  'location_timestamp' int(11) NOT NULL,
  'info_description' int(11) NOT NULL,
  'pref_description' int(11) NOT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB  DEFAULT CHARSET=utf8_bin AUTO_INCREMENT=3;

-- CREATE TABLE 'preference' (
--   'user' int(11) NOT NULL auto_increment,
--   'description' int(11) NOT NULL,
--   PRIMARY KEY ('id')
-- ) ENGINE=InnoDB  DEFAULT CHARSET=utf8_bin AUTO_INCREMENT=3;

CREATE TABLE 'desciption' (
  'id' int(11) NOT NULL auto_increment,
  'timestamp' int(11) NOT NULL,

  'firstname' varchar(50) NOT NULL,
  'lastname' varchar(50) NOT NULL,
  'age' int(11) NOT NULL,
  'age_max' int(11) NOT NULL,
  'gender' varchar(255) NOT NULL,
  'birthday' int(11) NOT NULL,
  'smoking' varchar(255) NOT NULL,
  'drinking' varchar(255) NOT NULL,
  'orientation' varchar(255) NOT NULL,
  'ethnicity' varchar(255) NOT NULL,
  'nationality' varchar(255) NOT NULL,
  'religion' varchar(255) NOT NULL,
  'zodiac' varchar(255) NOT NULL,
  'chi_zodiac' varchar(255) NOT NULL,
  'bloodtype' varchar(255) NOT NULL,

  'country' int(11) NOT NULL,
  'region' int(11) NOT NULL,
  'city' int(11) NOT NULL,

  'bodytype' varchar(255) NOT NULL,
  'height' int(11) NOT NULL,
  'height_max' int(11) NOT NULL,
  'weight' int(11) NOT NULL,
  'weight_max' int(11) NOT NULL,
  'haircolor' varchar(255) NOT NULL,
  'eyecolor' varchar(255) NOT NULL,
  'skincolor' varchar(255) NOT NULL,
  'tattoo' varchar(255) NOT NULL,
  'piercing' varchar(255) NOT NULL,

  PRIMARY KEY  ('id')
) ENGINE=InnoDB  DEFAULT CHARSET=utf8_bin AUTO_INCREMENT=3;

CREATE TABLE 'report' (
  'id' int(11) NOT NULL auto_increment,
  'timestamp' int(11) NOT NULL,
  'reporter' int(11) NOT NULL,
  'reportee' int(11) NOT NULL,
  'description' blob NOT NULL,
  PRIMARY KEY  ('id')
) ENGINE=InnoDB  DEFAULT CHARSET=utf8_bin AUTO_INCREMENT=3;
