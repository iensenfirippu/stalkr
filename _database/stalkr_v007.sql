# #################### #
# Drop old tables      #
# #################### #

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS userdescription;
DROP TABLE IF EXISTS description;
DROP TABLE IF EXISTS report;

# #################### #
# Create new tables    #
# #################### #

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
# first user object    #
# #################### #

INSERT INTO user
(
	u_id,
	email,username,password,
	firstname,lastname,birthday,
	loc_lat,loc_lon,loc_tim
)
VALUES
(
	"edea3e9a-da70-4a52-b1be-68df86b1afda",
	"johndoe@jubiipost.dk","JohnDoe69","1234",
	"John","Doe",000000123,
	10.5,5.10,123456789
);

INSERT INTO userdescription
(
	u_id,
	d_id
)
VALUES
(
	"edea3e9a-da70-4a52-b1be-68df86b1afda",
	"57008f04-b8e3-464b-8253-1fa44fcea113"
);

INSERT INTO description
(
	d_id,timestamp,title,
	age,age_max,gender,
	sexuality,country,region,
	city,smoking,drinking
)
VALUES
(
	"edea3e9a-da70-4a52-b1be-68df86b1afda",123456789,"Description",
	25,0,"01000",
	"0100","0","01000",
	"0","100","10"
);

INSERT INTO description
(
	d_id,timestamp,title,
	age,age_max,gender,
	sexuality,country,region,
	city,smoking,drinking
)
VALUES
(
	"57008f04-b8e3-464b-8253-1fa44fcea113",123456789,"Default",
	20,30,"01000",
	"0100","0","01000",
	"0","100","10"
);

# #################### #
# Second user object   #
# #################### #

INSERT INTO user
(
	u_id,
	email,username,password,
	firstname,lastname,birthday,
	loc_lat,loc_lon,loc_tim
)
VALUES
(
	"1A6747B2-931C-11E2-AE68-D7146188709B",
	"phandazee@gmail.com","Jonazzy","9876",
	"Jonaz","van der Zee",716016155,
	3.12,7.14,123456789
);

INSERT INTO userdescription
(
	u_id,
	d_id
)
VALUES
(
	"1A6747B2-931C-11E2-AE68-D7146188709B",
	"8b9e9d44-4411-434f-b5cc-5b803a3dc4f6"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"1A6747B2-931C-11E2-AE68-D7146188709B",123456789,"0",
	"00100","0",67,
	98,"01000","010",
	"01","0010","Description"
);	

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"8b9e9d44-4411-434f-b5cc-5b803a3dc4f6",123456789,"0",
	"00001","0",45,
	60,"01000","000",
	"00","0010","TEST"
);

# #################### #
# Third user object    #
# #################### #

INSERT INTO user
(
	u_id,
	email,username,password,
	firstname,lastname,birthday,
	loc_lat,loc_lon,loc_tim
)
VALUES
(
	"2AED9276-931C-11E2-9857-DC146188709B",
	"jamesjohnson@jubiipost.dk","JamesJohnson43","3456",
	"James","Johnson",378022125,
	12.4,2.2,1361366653
);

INSERT INTO userdescription
(
	u_id,
	d_id
)
VALUES
(
	"2AED9276-931C-11E2-9857-DC146188709B",
	"722BFD5E-931B-11E2-9A5C-54146188709B"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
    	"2AED9276-931C-11E2-9857-DC146188709B",123456789,"0",
	"01000","0",20,
	30,"00000","000",
	"00","0100","Description"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"722BFD5E-931B-11E2-9A5C-54146188709B",123456789,"0",
	"00010","0",22,
	33,"01000","010",
	"01","0100","HERE GOES EVERYTHING"
);

# #################### #
# Fourth user object   #
# #################### #

INSERT INTO user
(
	u_id,
	email,username,password,
	firstname,lastname,birthday,
	loc_lat,loc_lon,loc_tim
)
VALUES
(
	"406A84D8-931C-11E2-9C5D-E0146188709B",
	"martinhansen@jubiipost.dk","Martin6","5678",
	"Martin","Hansen",469465670,
	42.2,3.4,1359713436
);

INSERT INTO userdescription
(
	u_id,
	d_id
)
VALUES
(
	"406A84D8-931C-11E2-9C5D-E0146188709B",
	"918446D4-931B-11E2-A016-67146188709B"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"406A84D8-931C-11E2-9C5D-E0146188709B",123456789,"0",
	"00001","0",47,
	69,"01000","010",
	"01","0001","Description"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"918446D4-931B-11E2-A016-67146188709B",123456789,"0",
	"00100","0",22,
	45,"01000","000",
	"01","0010","A title"
);

# #################### #
# Fifth user object    #
# #################### #

INSERT INTO user
(
	u_id,
	email,username,password,
	firstname,lastname,birthday,
	loc_lat,loc_lon,loc_tim
)
VALUES
(
	"453B6888-9597-11E2-8012-90CA6088709B",
	"bertamus@jubiipost.dk","Bertamus","4567",
	"Berta","Larsen",1362708354,
	13.12,14.2,1361366653
);

INSERT INTO userdescription
(
	u_id,
	d_id
)
VALUES
(
	"453B6888-9597-11E2-8012-90CA6088709B",
	"538A40BC-9597-11E2-81CD-96CA6088709B"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"453B6888-9597-11E2-8012-90CA6088709B",123456789,"0",
	"00100","0",43,
	55,"01000","010",
	"01","0010","Description"
);

INSERT INTO description
(
	d_id,timestamp,country,
	region,city,age,
	age_max,gender,smoking,
	drinking,sexuality,title
)
VALUES
(
	"538A40BC-9597-11E2-81CD-96CA6088709B",123456789,"0",
	"00001","0",77,
	98,"00000","000",
	"00","0010","Preference"
);

# #################### #
# Report object        #
# #################### #

INSERT INTO report
(
	r_id,timestamp,reporter,reportee,description
)
VALUES
(
	"1b05a678-593f-4929-9c4b-7bb3a1c259fd",123456789,"1","1","Blah blah blah"
);