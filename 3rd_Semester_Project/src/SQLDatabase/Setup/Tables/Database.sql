----------------------------------
--    Disconnect tables:       --
----------------------------------
alter table Ticket drop constraint fkey_Ticket;
alter table JourneyHistory drop constraint fkey_JourneyHistory;
----------------------------------
--         Drop tables:         --
----------------------------------
DROP TABLE    Customer;
DROP TABLE    Ticket;
DROP TABLE    JourneyHistory;
----------------------------------
--       Create tables:         --
----------------------------------

-- Customer: --
CREATE TABLE Customer (
CustomerNumber INT NOT NULL GENERATED ALWAYS AS IDENTITY,
FirstName      VARCHAR (32),
LastName       VARCHAR (32),
-- status         VARCHAR (16),        -- Logged in, Valid Customer, Active/Disabled e.t.c
eMail          VARCHAR (32),
Password       VARCHAR  (32),
PRIMARY KEY (CustomerNumber)
);


-- Ticket: --
CREATE TABLE Ticket(
TicketNumber  INT NOT NULL GENERATED ALWAYS AS IDENTITY,
DateTimeStamp TIMESTAMP DEFAULT current_timestamp,
Ticketprice   INT NOT NULL,
StartZone     INT NOT NULL, 
Customer      INT,
constraint fkey_Ticket FOREIGN KEY (Customer) REFERENCES Customer(CustomerNumber)ON DELETE NO ACTION ON UPDATE NO ACTION,
PRIMARY KEY (TicketNumber)
);

-- JourneyHistory: --
CREATE TABLE JourneyHistory(
TicketNumber  INT,
DateTimeStamp TIMESTAMP,
Ticketprice   INT,
StartZone     INT, 
Customer      INT,
constraint fkey_JourneyHistory FOREIGN KEY(Customer) REFERENCES Customer(CustomerNumber) ON DELETE NO ACTION ON UPDATE NO ACTION
);


-- -- Customer: --
-- CREATE TABLE Customer (
-- CustomerNumber INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
-- firstname      VARCHAR (32),
-- lastname       VARCHAR (32),
-- -- status         VARCHAR (16),        -- Logged in, Valid Customer, Active/Disabled e.t.c
-- email          VARCHAR (32)
-- );