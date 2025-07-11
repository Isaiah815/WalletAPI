CREATE TABLE  IF NOT EXISTS login(
     username varchar(200) unique,
     password varchar(100),
     created_by varchar(200),
     created_on timestamp,
     modified_by varchar(200),
     modified_on timestamp default CURRENT_TIMESTAMP
);