DROP DATABASE IF EXISTS CONSTRUCTCO;
CREATE DATABASE CONSTRUCTCO;
USE CONSTRUCTCO;



/* -- */
CREATE TABLE JOB (
  JOB_CODE        VARCHAR(3),
  JOB_DESCRIPTION VARCHAR(25),
  JOB_CHG_HOUR    DECIMAL(8,2),
  JOB_LAST_UPDATE DATETIME,
  PRIMARY KEY(JOB_CODE)
);
INSERT INTO JOB VALUES('500','Programmer',           '35.75','2021-11-20');
INSERT INTO JOB VALUES('501','Systems Analyst',      '96.75','2021-11-20');
INSERT INTO JOB VALUES('502','Database Designer',    '125',  '2022-3-24');
INSERT INTO JOB VALUES('503','Electrical Engineer',  '84.5', '2021-11-20');
INSERT INTO JOB VALUES('504','Mechanical Engineer',  '67.9', '2021-11-20');
INSERT INTO JOB VALUES('505','Civil Engineer',       '55.78','2021-11-20');
INSERT INTO JOB VALUES('506','Clerical Support',     '26.87','2021-11-20');
INSERT INTO JOB VALUES('507','DSS Analyst',          '45.95','2021-11-20');
INSERT INTO JOB VALUES('508','Applications Designer','48.1', '2022-3-24');
INSERT INTO JOB VALUES('509','Bio Technician',       '34.55','2021-11-20');
INSERT INTO JOB VALUES('510','General Support',      '18.36','2021-11-20');


/* -- */

CREATE TABLE EMPLOYEE (
  EMP_NUM       VARCHAR(3),
  EMP_LNAME     VARCHAR(15),
  EMP_FNAME     VARCHAR(15),
  EMP_INITIAL   VARCHAR(1),
  EMP_HIREDATE  DATETIME,
  JOB_CODE      VARCHAR(3),
  EMP_YEARS     INT(3),
  PRIMARY KEY(EMP_NUM),
  FOREIGN KEY (JOB_CODE) REFERENCES JOB(JOB_CODE)
);
INSERT INTO EMPLOYEE VALUES('101','News','John','G','2004-11-8','502','4');
INSERT INTO EMPLOYEE VALUES('102','Senior','David','H','1993-7-12','501','15');
INSERT INTO EMPLOYEE VALUES('103','Arbough','June','E','2000-12-1','500','8');
INSERT INTO EMPLOYEE VALUES('104','Ramoras','Anne','K','1991-11-15','501','17');
INSERT INTO EMPLOYEE VALUES('105','Johnson','Alice','K','1997-2-1','502','12');
INSERT INTO EMPLOYEE VALUES('106','Smithfield','William',NULL,'2008-6-22','500','0');
INSERT INTO EMPLOYEE VALUES('107','Alonzo','Maria','D','1997-10-10','500','11');
INSERT INTO EMPLOYEE VALUES('108','Washington','Ralph','B','1995-8-22','501','13');
INSERT INTO EMPLOYEE VALUES('109','Smith','Larry','W','2001-7-18','501','7');
INSERT INTO EMPLOYEE VALUES('110','Olenko','Gerald','A','1999-12-11','505','9');
INSERT INTO EMPLOYEE VALUES('111','Wabash','Geoff','B','1995-4-4','506','14');
INSERT INTO EMPLOYEE VALUES('112','Smithson','Darlene','M','1998-10-23','507','10');
INSERT INTO EMPLOYEE VALUES('113','Joenbrood','Delbert','K','2000-11-15','508','8');
INSERT INTO EMPLOYEE VALUES('114','Jones','Annelise',NULL,'1997-8-20','508','11');
INSERT INTO EMPLOYEE VALUES('115','Bawangi','Travis','B','1996-1-25','501','13');
INSERT INTO EMPLOYEE VALUES('116','Pratt','Gerald','L','2001-3-5','510','8');
INSERT INTO EMPLOYEE VALUES('117','Williamson','Angie','H','2000-6-19','509','8');
INSERT INTO EMPLOYEE VALUES('118','Frommer','James','J','2009-1-4','510','0');

/* -- */

CREATE TABLE PROJECT (
  PROJ_NUM      VARCHAR(3),
  PROJ_NAME     VARCHAR(25),
  PROJ_VALUE    DECIMAL(10,2),
  PROJ_BALANCE  DECIMAL(10,2),
  EMP_NUM       VARCHAR(3),
  PRIMARY KEY(PROJ_NUM),
  FOREIGN KEY(EMP_NUM) REFERENCES EMPLOYEE(EMP_NUM)
);
INSERT INTO PROJECT VALUES('15','Evergreen','1453500','1002350','103');
INSERT INTO PROJECT VALUES('18','Amber Wave','3500500','2110346','108');
INSERT INTO PROJECT VALUES('22','Rolling Tide','805000','500345.2','102');
INSERT INTO PROJECT VALUES('25','Starflight','2650500','2309880','107');

/* -- */
CREATE TABLE ASSIGNMENT (
  ASSIGN_NUM      INT(5),
  ASSIGN_DATE     DATETIME,
  PROJ_NUM        VARCHAR(3),
  EMP_NUM         VARCHAR(3),
  ASSIGN_JOB      VARCHAR(3),
  ASSIGN_CHG_HR   DECIMAL(8,2),
  ASSIGN_HOURS    DECIMAL(8,2),
  ASSIGN_CHARGE   DECIMAL(8,2),
  PRIMARY KEY (ASSIGN_NUM),
  FOREIGN KEY (PROJ_NUM) REFERENCES PROJECT(PROJ_NUM),
  FOREIGN KEY (EMP_NUM) REFERENCES EMPLOYEE(EMP_NUM)
);
INSERT INTO ASSIGNMENT VALUES('1001','2022-3-22','18','103','503','84.5','3.5','295.75');
INSERT INTO ASSIGNMENT VALUES('1002','2022-3-22','22','117','509','34.55','4.2','145.11');
INSERT INTO ASSIGNMENT VALUES('1003','2022-3-22','18','117','509','34.55','2','69.10');
INSERT INTO ASSIGNMENT VALUES('1004','2022-3-22','18','103','503','84.5','5.9','498.55');
INSERT INTO ASSIGNMENT VALUES('1005','2022-3-22','25','108','501','96.75','2.2','212.85');
INSERT INTO ASSIGNMENT VALUES('1006','2022-3-22','22','104','501','96.75','4.2','406.35');
INSERT INTO ASSIGNMENT VALUES('1007','2022-3-22','25','113','508','50.75','3.8','192.85');
INSERT INTO ASSIGNMENT VALUES('1008','2022-3-22','18','103','503','84.5','0.9','76.05');
INSERT INTO ASSIGNMENT VALUES('1009','2022-3-23','15','115','501','96.75','5.6','541.80');
INSERT INTO ASSIGNMENT VALUES('1010','2022-3-23','15','117','509','34.55','2.4','82.92');
INSERT INTO ASSIGNMENT VALUES('1011','2022-3-23','25','105','502','105','4.3','451.5');
INSERT INTO ASSIGNMENT VALUES('1012','2022-3-23','18','108','501','96.75','3.4','328.95');
INSERT INTO ASSIGNMENT VALUES('1013','2022-3-23','25','115','501','96.75','2','193.5');
INSERT INTO ASSIGNMENT VALUES('1014','2022-3-23','22','104','501','96.75','2.8','270.9');
INSERT INTO ASSIGNMENT VALUES('1015','2022-3-23','15','103','503','84.5','6.1','515.45');
INSERT INTO ASSIGNMENT VALUES('1016','2022-3-23','22','105','502','105','4.7','493.5');
INSERT INTO ASSIGNMENT VALUES('1017','2022-3-23','18','117','509','34.55','3.8','131.29');
INSERT INTO ASSIGNMENT VALUES('1018','2022-3-23','25','117','509','34.55','2.2','76.01');
INSERT INTO ASSIGNMENT VALUES('1019','2022-3-24','25','104','501','110.5','4.9','541.45');
INSERT INTO ASSIGNMENT VALUES('1020','2022-3-24','15','101','502','125','3.1','387.5');
INSERT INTO ASSIGNMENT VALUES('1021','2022-3-24','22','108','501','110.5','2.7','298.35');
INSERT INTO ASSIGNMENT VALUES('1022','2022-3-24','22','115','501','110.5','4.9','541.45');
INSERT INTO ASSIGNMENT VALUES('1023','2022-3-24','22','105','502','125','3.5','437.5');
INSERT INTO ASSIGNMENT VALUES('1024','2022-3-24','15','103','503','84.5','3.3','278.85');
INSERT INTO ASSIGNMENT VALUES('1025','2022-3-24','18','117','509','34.55','4.2','145.11');
