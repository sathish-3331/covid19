CREATE TABLE AdminLogin( 
    user_Id         number(4)primary Key ,
    user_name       VARCHAR(20),
    user_mail_id    VARCHAR(20),
    user_password   VARCHAR(20),
    mobile_number   VARCHAR(10),
    address         VARCHAR(30)
);
insert into  AdminLogin(user_Id,user_name,user_mail_id,user_password,mobile_number,address)values(3331,'Indira','Indira12@gmail.com','indira@123',9345464822,'Kallakurichi');
CREATE TABLE medicalStaff (  
    user_Id         NUMBER(4) GENERATED by DEFAULT on NULL As IDENTITY Start with 2001 PRIMARY KEY,
    user_name       VARCHAR(20),
    user_mail_id    VARCHAR(20),
    user_password   VARCHAR(20),
    mobile_number   VARCHAR(10),
    address         VARCHAR(30)
);
commit;
select*from medicalstaff;
SELECT user_password FROM medicalStaff where user_Id=2072;
DESCRIBE medicalstaff;
insert into medicalStaff(user_name,user_mail_id,user_password,mobile_number,address)values('sathish','Sathish2gmail.com','Sathish@123',9345464826,'chennai');
select AADHARNUMBER from Appointment_Data where appoinmentrequireddate<sysdate-7;
UPDATE Positive_Datas SET testresult ='Positive' WHERE addharno in (select addharno from Positive_Datas where caseoccureddate>sysdate-7);
create table POSITIVE_DATAS(
POSITIVEID       number(4) generated by default on null as identity start with 4047,   
ADDHARNO          number(12)unique not null,   
PATIENTNAME               VARCHAR2(10),
GENDER                    VARCHAR2(10),
PATIENTAGE                NUMBER(4),    
MOBILENO                  NUMBER(10)unique not null,   
ZONENAME                  VARCHAR2(20), 
MUNICIPALITYID            NUMBER(6),    
MUNICIPALITYNAME          VARCHAR2(50), 
STATENAME                 VARCHAR2(15),
COUNTRYNAME               VARCHAR2(20), 
CASEOCCUREDDATE           DATE,         
TESTRESULT                VARCHAR2(20), 
CONFIRMEDCASE             NUMBER(10),
MessageStatus varchar(10));


Alter table POSITIVE_DATAS MODIFY STATENAME varchar(20); 
Commit;
Select * from POSITIVE_DATAS;
Insert into POSITIVE_DATAS(ADDHARNO,PATIENTNAME,GENDER,PATIENTAGE,
MOBILENO,ZONENAME,MUNICIPALITYID,MUNICIPALITYNAME,
STATENAME,COUNTRYNAME,CASEOCCUREDDATE,TESTRESULT,
CONFIRMEDCASE,MESSAGESTATUS
) values(5534323223121,'Navas','Male',22,8576933413,'TELANGANA',3030,'SALEMMUNICIPALCORPORATION','TELANGANA','INDIA','20-11-2023','Positive',5880,'Pending');
SELECT * FROM admintable;
SELECT * FROM Appointment_Data;
select  Count(AADHARNUMBER) from APPOINTMENT_DATA where AADHARNUMBER=436457677457;
UPDATE Appointment_Data
SET OTHER_ISSUE='Cold'
Where APPOINTREGID=1472;
commit;
Commit;
DESCRIBE Appointment_Data;

SELECT *from Death_Datas;
create table Death_Datas(
DeathId number(4) GENERATED BY DEFAULT ON NULL AS IDENTITY START WITH 3001,
ADDHARNO number(12),
PATIENTNAME varchar(200),
GENDER varchar(10),
PATIENTAGE number(3),
MOBILENO number(10),
ZONENAME varchar(200),
MUNICIPALITYID number(6),
STATENAME varchar(100),
COUNTRYNAME varchar(100),
CASEOCCUREDDATE TIMESTAMP WITH TIME ZONE,
TESTRESULT varchar(20),
RESON_For_Death varchar(100),
CONFIRMEDCASE number(20));
select * from Death_Datas;
commit;


























































































































_Data Add UNIQUE (AADHARNUMBER);
--SELECT * FROM NEGATIVE_DATAS;
DESCRIBE NEGATIVE_DATAS;
commit;
Select * from NEGATIVE_DATAS;
select POSITIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from Positive_Datas where MESSAGESTATUS='Pending'  Union select NEGATIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from NEGATIVE_DATAS where MESSAGESTATUS='Pending';
UPDATE APPOINTMENT_DATA
SET APPOINTMENSTATUS ='Pending'
WHERE APPOINTREGID=1282;
UPDATE NEGATIVE_DATAS
SET PATIENTNAME='SATHISH'
WHERE MOBILENO=6384690617;
SELECT *FROM medicalStaff;
DESCRIBE medicalStaff;
SELECT* FROM APPOINTMENT_DATA;
Select appointregid,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,SYMPTOMS1,SYMPTOMS2,SYMPTOMS3,SYMPTOMS4,SYMPTOMS5,OTHER_ISSUE from Appointment_Data where not OTHER_ISSUE='none';
DESCRIBE APPOINTMENT_DATA;
commit;
Select appointregid,AADHARNUMBER,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,SYMPTOMS1,SYMPTOMS2,SYMPTOMS3,SYMPTOMS4,SYMPTOMS5,OTHER_ISSUE,STATENAME from Appointment_Data where not OTHER_ISSUE='none';
Select appointregid,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,OTHER_ISSUE from Appointment_Data where not OTHER_ISSUE='none';
--
Select appointregid,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,appointmenstatus from Appointment_Data where appointmenstatus='Pending';
SELECT* FROM negative_datas;
DESCRIBE negative_datas;
create table negative_datas(
POSITIVEID       number(4) generated by default on null as identity start with 2029,   
ADDHARNO          number(12)unique not null,   
PATIENTNAME               VARCHAR2(10),
GENDER                    VARCHAR2(10),
PATIENTAGE                NUMBER(4),    
MOBILENO                  NUMBER(10)unique not null,   
ZONENAME                  VARCHAR2(20), 
MUNICIPALITYID            NUMBER(6),    
MUNICIPALITYNAME          VARCHAR2(50), 
STATENAME                 VARCHAR2(15),
COUNTRYNAME               VARCHAR2(20), 
CASEOCCUREDDATE           DATE,         
TESTRESULT                VARCHAR2(20), 
CONFIRMEDCASE             NUMBER(10));
SELECT * FROM NEGATIVE_DATAS;
Alter table NEGATIVE_DATAS MODIFY STATENAME varchar(20); 
insert into NEGATIVE_DATAS 
(ADDHARNO,PATIENTNAME,GENDER,PATIENTAGE,
MOBILENO,ZONENAME,MUNICIPALITYID,MUNICIPALITYNAME,
STATENAME,COUNTRYNAME,CASEOCCUREDDATE,TESTRESULT,
CONFIRMEDCASE,MESSAGESTATUS
) values(889454326572,'Appu','Male',22,8989819826,'TELANGANA',3030,'KALLAKURICHIMUNICIPALCOPPORATION','TELANGANA','INDIA','20-11-2023','Negative',7845,'Pending');
DESCRIBE NEGATIVE_DATAS;
commit;
--
automatic update  on RecoveredTable;
select addharno from Positive_Datas where caseoccureddate<sysdate-7;
UPDATE Positive_Datas SET testresult ='Recovered' WHERE addharno in (select addharno from Positive_Datas where caseoccureddate<sysdate-7);
--
create table Death_Datas(
DeathId       number(4) generated by default on null as identity start with 2029,   
ADDHARNO          number(12)unique not null,   
PATIENTNAME               VARCHAR2(10),
GENDER                    VARCHAR2(10),
PATIENTAGE                NUMBER(4),    
MOBILENO                  NUMBER(10)unique not null,   
ZONENAME                  VARCHAR2(20), 
MUNICIPALITYID            NUMBER(6),    
STATENAME                 VARCHAR2(15),
COUNTRYNAME               VARCHAR2(20), 
CASEOCCUREDDATE           TIMESTAMP WITH LOCAL TIME ZONE,         
TESTRESULT                VARCHAR2(20),
RESON_For_Death           varchar(600),
CONFIRMEDCASE             NUMBER(10));
SELECT*FROM Death_Datas;
drop table Death_Datas;
commit;
create table StateIndiaFind(
MUNICIPALITY_ID   NOT NULL NUMBER(4)    
MUNICIPALITY_NAME          VARCHAR2(60) 
STATE_ID                   NUMBER(5)    
STATE_NAME                 VARCHAR2(20) 
COUNTRY_NAME               VARCHAR2(20));
SELECT*FROM StateIndiaFind;
DESCRIBE StateIndiaFind; 
--
create table APPOINTMENT_DATA(
APPOINTREGID                    number(4) generated by default on null as identity start with 2029,   
AADHARNUMBER                    NUMBER(15)    
USERNAME                        VARCHAR2(20)  
AGE                             NUMBER(3)     
MOBILENUMBER                    NUMBER(10)unique not null,    
GENDER                          VARCHAR2(20)  
MAILID                          VARCHAR2(50)  
PASSWORD                        VARCHAR2(20)  
ZONEAREANAME                    VARCHAR2(500) 
POSTCODE                        NUMBER(6)     
APPOINMENTREQUIREDDATE          DATE          
SYMPTOMS1                       VARCHAR2(20)  
SYMPTOMS2                       VARCHAR2(20)  
SYMPTOMS3                       VARCHAR2(20)  
SYMPTOMS4                       VARCHAR2(20)  
SYMPTOMS5                       VARCHAR2(20)  
APPOINTMENSTATUS                VARCHAR2(20));
DESCRIBE APPOINTMENT_DATA;
Select*from APPOINTMENT_DATA;
commit;
select SUM(ConfirmedCase)as total_Cases from Positive_Datas where TestResult='Recovered';
Select*from Positive_Datas;
select SUM(confirmedcase)as total_Cases from Positive_Datas  where StateName='TAMILNADU' AND TestResult='Recovered';
select SUM(confirmedcase)as total_Cases from Positive_Datas  where TestResult='Recovered' AND  StateName='TAMILNADU';
commit;
insert into Appointment_Data(aadharNumber,username,age,mobilenumber,Gender,mailid,password,zoneareaname,postcode,appoinmentrequireddate,symptoms1,Symptoms2,Symptoms3,Symptoms4,Symptoms5,appointmenstatus)values(3233322222,'Vicky',23,9974647522,'Male','Vicky@gmail.com','Sathish@123','chennai',809811,'10-11-23','yes','yes','yes','yes','yes','Pending');
select* from Appointment_Data;
Select*from NEGATIVE_DATAS;
select  POSITIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from Positive_Datas Union select NEGATIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from NEGATIVE_DATAS ;
select POSITIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from Positive_Datas Union select NEGATIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from NEGATIVE_DATAS;

select user_name from medicalstaff max count (*)(user_name);