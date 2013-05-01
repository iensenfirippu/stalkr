# #################### #
# Drop old tables      #
# #################### #

DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS userdescription;
DROP TABLE IF EXISTS description;
DROP TABLE IF EXISTS report;

# #################### #
# Create new tables    #
# #################### #

CREATE TABLE IF NOT EXISTS admin
(
	username VARCHAR(16) NOT NULL,
	password VARCHAR(255) NOT NULL,
	permission VARCHAR(6) NOT NULL DEFAULT "111111",
	PRIMARY KEY (username)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user
(
	u_id VARCHAR(36) NOT NULL,
	email VARCHAR(255) NOT NULL,
	username VARCHAR(16) NOT NULL,
	password VARCHAR(255) NOT NULL,
	firstname VARCHAR(32) NOT NULL,
	lastname VARCHAR(32) NOT NULL,
	birthday INT(11) NOT NULL,
	loc_lat FLOAT(11) NOT NULL,
	loc_lon FLOAT(11) NOT NULL,
	loc_tim INT(11) NOT NULL,
	PRIMARY KEY (u_id),
	UNIQUE (email,username)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS userdescription
(
	u_id VARCHAR(36) NOT NULL,
	d_id VARCHAR(36) NOT NULL
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS description
(
	d_id VARCHAR(36) NOT NULL,
	timestamp INT(11) NOT NULL,
	title VARCHAR(16) NULL,
	age INT(11) NOT NULL,
	age_max INT(11) NOT NULL,
	gender VARCHAR(5) NOT NULL DEFAULT "00000",
	sexuality VARCHAR(4) NOT NULL DEFAULT "0000",
	country VARCHAR(1) NOT NULL DEFAULT "0",
	region VARCHAR(5) NOT NULL DEFAULT "00000",
	city VARCHAR(1) NOT NULL DEFAULT "0",
	smoking VARCHAR(3) NOT NULL DEFAULT "000",
	drinking VARCHAR(2) NOT NULL DEFAULT "00",
	PRIMARY KEY (d_id)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS report
(
	r_id VARCHAR(36) NOT NULL,
	timestamp INT(11) NOT NULL,
	reporter VARCHAR(36) NOT NULL,
	reportee VARCHAR(36) NOT NULL,
	description BLOB NOT NULL,
	PRIMARY KEY (r_id)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8;

# #################### #
# Default data         #
# #################### #

INSERT INTO admin
(
	username,password,permission
)
VALUES
(
	"SIGNUPSCRIPT","BecuzFukU2","000100"
);