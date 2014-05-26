
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
   AccountStatus varchar (6) NOT NULL, --- PENAPP - PENACT (card sent) - DISABL - ACTIVE
   UseStatus varchar (4), --CHAR - IDLE
   PRIMARY KEY (CustomerNumb)
);

CREATE TABLE Terminals (
   HardwareNumb  INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   Road varchar (100) NOT NULL,
   ZipCode varchar (4) NOT NULL,
   IPAddress varchar (15) NOT NULL,
   InstallStatus varchar (6) NOT NULL, -- ENABLE - DISABL - PENDEP
   ChargingStatus varchar (4) NOT NULL,-- IDLE - CHAR
   OfflineSince varchar (25) DEFAULT 'ONLINE',
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
   BillingWH  INT NOT NULL,
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
   ('1337','password','9bfa0ee8','Hans','Hansen','vej 4','2730','hans@hansen.dk','25302308',10000,'ACTIVE','IDLE'), -- CARD 1
   ('1235','password','cba6a213','Hans','Jensen','vej 8','5530','hansemand@hotmail.com','44592271',0,'ACTIVE','IDLE'),   
   ('1234','password1','cba60ce8','Jens','Jensen','vej 5','4530','jens@hotmail.com','44596871',0,'PENAPP','IDLE'),    
   ('1338','mor','0003','Niels','Nielsen','vej 6','3310','funkytown@gmail.com','88888888',50000,'PENACT','CHAR'),
   ('9999','andreas','0004','Anders','Andersen','vej 7','2400','anders@tdc.dk','33108891',60000,'DISABL','IDLE'),
   ('1234','123456','abcdefg','James','Smith','Someroad 1','1234','james@smith.com','12345678',20000,'PENAPP','IDLE');


INSERT INTO Terminals (Road ,ZipCode,IPAddress,InstallStatus,ChargingStatus)
VALUES
   ('vejen 4','2750','12','ENABLE','CHAR'),
   ('vejen 5','2200','13','DISABL','IDLE'),
   ('vejen 6','1234','14','PENDEP','IDLE');

INSERT INTO Deposits (CustomerNumb,DepositAmount,NewBalanceDeposit,ExternalRefNumb,last4CardNumb )
VALUES
   (1,100,100,0015698,4587),
   (2,200,300,0015699,4588),
   (3,300,500,0015700,4589),
   (1,100,200,0015701,4587),
   (6,100,200,0015702,4551);
   

INSERT INTO Billing (CustomerNumb,HardwareNumb,StartCharge,EndCharge,BillingAmount,BillingRate,BillingWH,NewBalanceBilling)
VALUES
   (1,2,'2014-03-24 13:10:02','2014-03-24 16:10:02',10000,1050,7530,5040),
   (1,2,'2014-03-24 13:10:02','2014-03-24 16:10:02',10000,1050,7530,5040),
   (2,3,'2014-03-25 13:10:02','2014-03-25 17:10:02',20010,1060,8040,7580),
   (3,1,'2014-03-26 13:10:02','2014-03-26 18:10:02',50230,1080,1730,3970),
   (6,2,'2014-03-24 13:10:02','2014-03-24 16:10:02',10000,1050,7530,5040);

INSERT INTO Rate (CurrentRate)
VALUES
   (500);

