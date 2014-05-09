
alter table Deposits drop constraint fk_CustomerNumb;

alter table Billing drop constraint fk_CustomerNumb2;
alter table Billing drop constraint fk_HardwareNumb;

DROP TABLE Billing;
DROP TABLE Deposits;
DROP TABLE Customer;
DROP TABLE Terminals;
DROP TABLE Rate;

CREATE TABLE Customer (
   CustomerNumb INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   Pin varchar (4), 
   Password varchar (30) NOT NULL,
   CardNumb varchar (30),
   FirstName varchar (100) NOT NULL,
   LastName varchar (20) NOT NULL,
   Road varchar (100) NOT NULL,
   ZipCode varchar (4) NOT NULL,
   Email varchar (100) NOT NULL,
   PhoneNumb varchar (10) NOT NULL,
   Balance INT NOT NULL,
   AccountStatus varchar (6) NOT NULL, --- PenApp - PenAct (card sent) - Disabl - Active
   UseStatus varchar (4), --Char - Idle
   PRIMARY KEY (CustomerNumb)
);

CREATE TABLE Terminals (
   HardwareNumb  INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   Road varchar (100) NOT NULL,
   ZipCode varchar (4) NOT NULL,
   IPAddress varchar (15) NOT NULL,
   InstallStatus varchar (6) NOT NULL, -- Enable - Disabl - Pendep
   ChargingStatus varchar (4) NOT NULL,-- Idle - Char
   OfflineSince varchar (25) DEFAULT 'Online',
   PRIMARY KEY (HardwareNumb)
);

CREATE TABLE Deposits (
   DepositsNumb  INT GENERATED ALWAYS AS IDENTITY,
   CustomerNumb INT,
   DepositsDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
   DepositAmount INT NOT NULL,
   NewBalanceDeposit INT NOT NULL,
   ExternalRefNumb INT NOT NULL,
   last4CardNumb INT NOT NULL,
   constraint fk_CustomerNumb FOREIGN KEY (CustomerNumb) REFERENCES Customer (CustomerNumb), 
   PRIMARY KEY (DepositsNumb)
);

CREATE TABLE Billing (
   TransactionNumb  INT GENERATED ALWAYS AS IDENTITY,
   CustomerNumb INT,
   HardwareNumb  INT,
   StartCharge  varchar (25) NOT NULL, --2007-04-30 13:10:02.047
   EndCharge  varchar (25) NOT NULL, --2007-04-30 13:10:02.047
   Recieved TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   BillingAmount INT NOT NULL,
   BillingRate INT NOT NULL,
   BillingKWH  INT NOT NULL,
   NewBalanceBilling INT NOT NULL,
   constraint fk_CustomerNumb2 FOREIGN KEY (CustomerNumb) REFERENCES Customer (CustomerNumb),
   constraint fk_HardwareNumb FOREIGN KEY (HardwareNumb) REFERENCES Terminals (HardwareNumb),
   PRIMARY KEY (TransactionNumb)
);

CREATE TABLE Rate (
   CurrentRate INT NOT NULL,
   PRIMARY KEY (CurrentRate)
);

INSERT INTO Customer (Pin,Password,CardNumb,FirstName,LastName,Road,ZipCode,Email,PhoneNumb,Balance,AccountStatus,UseStatus)
VALUES 
   ('1337','password','9bfa0ee8','Hans','Hansen','vej 4','2730','hans@hansen.dk','25302308',10000,'Active','Idle'), -- CARD 1
   ('1235','password','cba6a213','Hans','Jensen','vej 8','5530','hansemand@hotmail.com','44592271',0,'Active','Idle'),   
   ('1234','password1','cba60ce8','Jens','Jensen','vej 5','4530','Jens@hotmail.com','44596871',0,'PenApp','Idle'),    
   ('1338','mor','0003','Niels','Nielsen','vej 6','3310','FunkyTown@gmail.com','88888888',50000,'PenAct','Char'),
   ('9999','andreas','0004','Anders','Andersen','vej 7','2400','Anders@tdc.dk','33108891',60000,'Disabl','Idle');


INSERT INTO Terminals (Road ,ZipCode,IPAddress,InstallStatus,ChargingStatus)
VALUES
   ('vejen 4','2750','12','enable','char'),
   ('vejen 5','2200','13','disabl','idle'),
   ('vejen 6','1234','14','pendep','idle');

INSERT INTO Deposits (CustomerNumb,DepositAmount,NewBalanceDeposit,ExternalRefNumb,last4CardNumb )
VALUES
   (1,100,100,0015698,4587),
   (2,200,300,0015699,4588),
   (3,300,500,0015700,4589),
   (1,100,200,0015701,4587);
   

INSERT INTO Billing (CustomerNumb,HardwareNumb,StartCharge,EndCharge,BillingAmount,BillingRate,BillingKWH,NewBalanceBilling)
VALUES
   (1,2,'2014-03-24 13:10:02.047','2014-03-24 16:10:02.047',10000,1050,7530,5040),
   (1,2,'2014-03-24 13:10:02.047','2014-03-24 16:10:02.047',10000,1050,7530,5040),
   (2,3,'2014-03-25 13:10:02.047','2014-03-25 17:10:02.047',20010,1060,8040,7580),
   (3,1,'2014-03-26 13:10:02.047','2014-03-26 18:10:02.047',50230,1080,1730,3970);

INSERT INTO Rate (CurrentRate)
VALUES
   (500);

--select * from Customer
--select * from Terminals
--select * from Deposits
--select * from Billing



 --update Terminals set OfflineSince = CURRENT_TIMESTAMP where HardwareNumb = 1;

--UPDATE Terminals SET OfflineSince = CASE WHEN OfflineSince='Online' THEN CURRENT_TIMESTAMP END WHERE HardwareNumb = 1;