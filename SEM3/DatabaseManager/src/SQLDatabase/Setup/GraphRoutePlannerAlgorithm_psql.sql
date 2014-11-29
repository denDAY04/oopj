-- @author Rasmus
DROP TABLE speedbound;

CREATE TABLE speedbound(
   speedbound INT NOT NULL,
   PRIMARY KEY (speedbound)
);

INSERT INTO speedbound (speedbound) VALUES (100);

DROP TABLE stops;
CREATE TABLE stops(
   ID SERIAL UNIQUE PRIMARY KEY,
   stopname VARCHAR(10) NOT NULL,
   zoneNumber INT NOT NULL,
   longitude INT NOT NULL,
   latitude INT NOT NULL
   --PRIMARY KEY (ID)
 );
INSERT INTO stops (stopname,zoneNumber,longitude,latitude) VALUES 

('Ballerup',1,5,35),
('Malmparken',2,20,25),
('Skovlunde',3,10,55),
('Herlev',1,5,10),
('Husum',2,25,15),
('Islev',4,25,55),
('Flintholm',3,30,35),
('Valby',4,40,50),
('Enghave',4,45,35),
('Vesterport',4,45,20)
;

DROP TABLE stoplinks;
CREATE TABLE stoplinks(
   ID SERIAL UNIQUE PRIMARY KEY,
   vehicle VARCHAR(10) NOT NULL,
   line VARCHAR(5) NOT NULL,
   fromstop INT NOT NULL,
   tostop INT NOT NULL,
   towards INT NOT NULL
   --PRIMARY KEY (ID)
 );
INSERT INTO stoplinks (vehicle,line,fromstop,tostop,towards) VALUES 
('Train','B',4,1,2),
('Train','B',1,4,4),
('Train','B',1,2,2),
('Train','B',2,1,4),
('Train','C',4,5,10),
('Train','C',5,4,4),
('Train','C',2,5,4),
('Train','C',5,2,10),
('Train','C',7,2,4),
('Train','C',2,7,10),
('Train','C',7,10,10),
('Train','C',10,7,4),
('Bus','1',4,2,2),
('Bus','1',2,4,4),
('Bus','2',3,7,7),
('Bus','2',7,3,3),
('Bus','3',8,9,10),
('Bus','3',9,8,8),
('Bus','3',9,10,10),
('Bus','3',10,9,8),
('Bus','4',3,6,8),
('Bus','4',6,3,3),
('Bus','4',6,8,8),
('Bus','4',8,6,3)
;