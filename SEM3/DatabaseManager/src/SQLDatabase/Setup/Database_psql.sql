----------------------------------
--         Drop tables:         --
----------------------------------
DROP TABLE    Customer        CASCADE;
DROP TABLE    Ticket          CASCADE;
DROP TABLE    JourneyHistory  CASCADE;
----------------------------------
--       Create tables:         --
----------------------------------

-- Customer: --
CREATE TABLE Customer (
CustomerNumber SERIAL PRIMARY KEY,  --   serial is 4 bytes autoincrementing integer (Range: 1 to 2147483647)
FirstName      VARCHAR (32),
LastName       VARCHAR (32),
eMail          VARCHAR (32),
Password       VARCHAR  (32)   
);

-- Ticket: --
CREATE TABLE Ticket(
TicketNumber  SERIAL PRIMARY KEY, 
DateTimeStamp TIMESTAMP DEFAULT current_timestamp,
Ticketprice   INT NOT NULL,
StartZone     INT NOT NULL,
ZoneCount     INT NOT NULL,
Customer      INT REFERENCES Customer(CustomerNumber)
);

-- JourneyHistory: --
CREATE TABLE JourneyHistory(
TicketNumber  INT,
DateTimeStamp VARCHAR(32),
Ticketprice   INT,
StartZone     INT, 
ZoneCount     INT,
Customer      INT REFERENCES Customer(CustomerNumber)
);