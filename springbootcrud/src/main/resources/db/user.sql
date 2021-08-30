DROP vehicle_center;
CREATE DATABASE vehicle_center;
USE vehicle_center;

CREATE TABLE role(
       rId VARCHAR(10) NOT NULL,
       rName VARCHAR(30),
       CONSTRAINT PRIMARY KEY(id)
);
INSERT INTO role(r_id, r_name) VALUES ('R001','Admin');
INSERT INTO role(r_id, r_name) VALUES ('R003','Customer');
INSERT INTO role(r_id, r_name) VALUES ('R002','Dealer');



