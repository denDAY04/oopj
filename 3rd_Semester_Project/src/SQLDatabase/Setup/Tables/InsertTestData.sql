----------------------------------------
-- Run this to generate test data :   --
----------------------------------------

-- Customer: --

-- INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES (?,?,?,?)
INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES ('Citizen', 'Kane', 'kane@citizen.com', 'rosebud');
INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES ('Albert', 'Einstein', 'albert@einstein.com', 'E=mc2');
INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES ('Arnold', 'Swarzenegger', 'arnold@swarzenegger.com', 'illbeback');
INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES ('Chuck', 'Norris', 'chuck@norris.com', 'CarlosRay');
INSERT INTO Customer (FirstName, LastName, eMail, Password) VALUES ('Bruce', 'lee', 'bruce@lee.com', 'EnterTheDragon');


-- Ticket: --
-- INSERT INTO Ticket () VALUES ();

-- JourneyHistory: --
-- INSERT INTO JourneyHistory () VALUES ();






----------------------------------
--          Load data           --
-- Copy data from CSV to table: --
----------------------------------
-- \COPY Person FROM '~/public_html/person.txt' DELIMITER ',' CSV HEADER;
-- \COPY Person FROM '~/public_html/person.txt' DELIMITER ',' CSV;





-- select * from public.person where public.person.fornavn = 'James';



-- CREATE TABLE birthdays (
-- firstname varchar(80),
-- surname varchar(80),
-- dob date
-- );
-- INSERT INTO birthdays (firstname, surname, dob) VALUES ('Fred', 'Smith', '1989-05-02');




-- INT NOT NULL GENERATED ALWAYS AS IDENTITY





-- dump a database, as SQL, into a text file. 
-- PostgreSQL has a similar command called pg_dump. 
-- Like the MySQL equivalent, it takes a database name as the first parameter 
-- (otherwise the username is assumed as the database name), 
-- but to dump a certain table you must use the -t parameter:
