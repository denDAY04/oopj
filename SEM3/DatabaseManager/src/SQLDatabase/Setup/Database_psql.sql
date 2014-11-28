----------------------------------
--         Drop tables:         --
----------------------------------
DROP TABLE    Customer        CASCADE;
DROP TABLE    Ticket          CASCADE;
DROP TABLE    JourneyHistory  CASCADE;
DROP TABLE    Price           CASCADE;
----------------------------------
--       Create tables:         --
----------------------------------

-- Customer: --
CREATE TABLE Customer (
CustomerNumber BIGSERIAL PRIMARY KEY,  
FirstName      VARCHAR (32),
LastName       VARCHAR (32),
-- status         VARCHAR (16),        -- Logged in, Valid Customer, Active/Disabled e.t.c
eMail          VARCHAR (32),
Password       VARCHAR  (32)   
);


-- Ticket: --
CREATE TABLE Ticket(
TicketNumber  BIGSERIAL PRIMARY KEY, 
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


CREATE TABLE Price(
Index INT PRIMARY KEY,
TicketPriceAdultOneZone INT NOT NULL
);