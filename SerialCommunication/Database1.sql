
alter table Deposits drop constraint fk_CustomerNumb;

alter table Billing drop constraint fk_CustomerNumb2;
alter table Billing drop constraint fk_HardwareNumb;

DROP TABLE Billing;
DROP TABLE Deposits;
DROP TABLE Customer;
DROP TABLE Terminals;


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
   Balance double NOT NULL,
   AccountStatus varchar (18) NOT NULL, --- PenApp - PenAct (card sent) - Disabl - Active
   UseStatus varchar (10), --Char - Idle
   PRIMARY KEY (CustomerNumb)
);

CREATE TABLE Terminals (
   HardwareNumb  INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   Road varchar (100) NOT NULL,
   ZipCode varchar (4) NOT NULL,
   IPAddress varchar (15) NOT NULL,
   InstallStatus varchar (18) NOT NULL, -- Enable - Disabl - Pendep
   ChargingStatus varchar (18) NOT NULL,-- Waitin - Charge
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
   BillingAmount double NOT NULL,
   BillingRate double NOT NULL,
   BillingKWH  double NOT NULL,
   NewBalanceBilling double NOT NULL,
   constraint fk_CustomerNumb2 FOREIGN KEY (CustomerNumb) REFERENCES Customer (CustomerNumb),
   constraint fk_HardwareNumb FOREIGN KEY (HardwareNumb) REFERENCES Terminals (HardwareNumb),
   PRIMARY KEY (TransactionNumb)
);



INSERT INTO Customer (Pin,Password,CardNumb,FirstName,LastName,Road,ZipCode,Email,PhoneNumb,Balance,AccountStatus,UseStatus)
VALUES 
   ('1337','password','0001','Hans','Hansen','vej 4','2730','hans@hansen.dk','25302308',100.0,'active','charging'),
   ('1234','password1','0002','Jens','Jensen','vej 5','4530','Jens@hotmail.com','44596871',0.0,'pending approval','Idle'), 
   ('1338','mor','0003','Niels','Nielsen','vej 6','3310','FunkyTown@gmail.com','88888888',500.0,'pending activation','Idle'),
   ('9999','andreas','0004','Anders','Andersen','vej 7','2400','Anders@tdc.dk','33108891',600.0,'disabled','Idle');


INSERT INTO Terminals (Road ,ZipCode,IPAddress,InstallStatus,ChargingStatus)
VALUES
   ('vejen 4','2750','111.111.111.111','enabled','charging'),
   ('vejen 5','2200','111.111.111.112','disabled','idle'),
   ('vejen 6','1234','111.111.111.113','pending deployment','idle');

INSERT INTO Deposits (CustomerNumb,DepositAmount,NewBalanceDeposit,ExternalRefNumb,last4CardNumb )
VALUES
   (1,100,100,0015698,4587),
   (2,200,300,0015699,4588),
   (3,300,500,0015700,4589),
   (1,100,200,0015701,4587);
   

INSERT INTO Billing (CustomerNumb,HardwareNumb,StartCharge,EndCharge,BillingAmount,BillingRate,BillingKWH,NewBalanceBilling)
VALUES
   (1,2,'2014-03-24 13:10:02.047','2014-03-24 16:10:02.047',100.0,10.5,75.3,50.4),
   (2,3,'2014-03-25 13:10:02.047','2014-03-25 17:10:02.047',200.1,10.6,80.4,75.8),
   (3,1,'2014-03-26 13:10:02.047','2014-03-26 18:10:02.047',502.3,10.8,17.3,39.7);

--select * from Customer
--select * from Terminals
--select * from Deposits
--select * from Billing



-- update Terminals set OfflineSince = CURRENT_TIMESTAMP where HardwareNumb = 1;