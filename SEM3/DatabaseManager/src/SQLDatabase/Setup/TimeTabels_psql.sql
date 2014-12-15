-- @author Rasmus
DROP TABLE TimeTable CASCADE;

--Table of departure times. Note that the second station name is the destination 
-- stop name, not the arrival stop name.

CREATE TABLE TimeTable(
   ID SERIAL UNIQUE PRIMARY KEY, 
   TransportationType VARCHAR(5) NOT NULL,
   Line VARCHAR(10) NOT NULL,
   Station VARCHAR(30) NOT NULL,
   Destination VARCHAR(30) NOT NULL,
   Departure TIME, 
   NextArrival TIME
   --PRIMARY KEY (ID)
);

INSERT INTO TimeTable (TransportationType,Line,Station,Destination,Departure,NextArrival) VALUES 

 --Train B to Malmparken                              (travel time)
('Train','B','Herlev','Malmparken','12:00','12:18'), --18m
('Train','B','Herlev','Malmparken','13:00','13:18'),
('Train','B','Herlev','Malmparken','14:00','14:18'),
('Train','B','Herlev','Malmparken','15:00','15:18'),
('Train','B','Herlev','Malmparken','16:00','16:18'),
('Train','B','Herlev','Malmparken','17:00','17:18'),
('Train','B','Herlev','Malmparken','18:00','18:18'),

('Train','B','Ballerup','Malmparken','12:18','12:30'), -- 12m
('Train','B','Ballerup','Malmparken','13:18','13:30'),
('Train','B','Ballerup','Malmparken','14:18','14:30'),
('Train','B','Ballerup','Malmparken','15:18','15:30'),
('Train','B','Ballerup','Malmparken','16:18','16:30'),
('Train','B','Ballerup','Malmparken','17:18','17:30'),
('Train','B','Ballerup','Malmparken','18:18','18:30'),

 --Train B to Herlev
('Train','B','Malmparken','Herlev','12:01','12:13'), -- 12m
('Train','B','Malmparken','Herlev','13:01','13:13'),
('Train','B','Malmparken','Herlev','14:01','14:13'),
('Train','B','Malmparken','Herlev','15:01','15:13'),
('Train','B','Malmparken','Herlev','16:01','16:13'),
('Train','B','Malmparken','Herlev','17:01','17:13'),
('Train','B','Malmparken','Herlev','18:01','18:13'),

('Train','B','Ballerup','Herlev','12:13','12:31'),  -- 18m
('Train','B','Ballerup','Herlev','13:13','13:31'), 
('Train','B','Ballerup','Herlev','14:13','14:31'), 
('Train','B','Ballerup','Herlev','15:13','15:31'), 
('Train','B','Ballerup','Herlev','16:13','16:31'), 
('Train','B','Ballerup','Herlev','17:13','17:31'), 
('Train','B','Ballerup','Herlev','18:13','18:31'), 

 --Train C to Vesterport
('Train','C','Herlev','Vesterport','12:03','12:17'), -- 14m
('Train','C','Herlev','Vesterport','13:03','13:17'),
('Train','C','Herlev','Vesterport','14:03','14:17'),
('Train','C','Herlev','Vesterport','15:03','15:17'),
('Train','C','Herlev','Vesterport','16:03','16:17'),
('Train','C','Herlev','Vesterport','17:03','17:17'),
('Train','C','Herlev','Vesterport','18:03','18:17'),

('Train','C','Husum','Vesterport','12:17','12:25'), -- 8m
('Train','C','Husum','Vesterport','13:17','13:25'), 
('Train','C','Husum','Vesterport','14:17','14:25'), 
('Train','C','Husum','Vesterport','15:17','15:25'), 
('Train','C','Husum','Vesterport','16:17','16:25'), 
('Train','C','Husum','Vesterport','17:17','17:25'), 
('Train','C','Husum','Vesterport','18:17','18:25'), 

('Train','C','Malmparken','Vesterport','12:25','12:35'), -- 10m
('Train','C','Malmparken','Vesterport','13:25','13:35'),
('Train','C','Malmparken','Vesterport','14:25','14:35'),
('Train','C','Malmparken','Vesterport','15:25','15:35'),
('Train','C','Malmparken','Vesterport','16:25','16:35'),
('Train','C','Malmparken','Vesterport','17:25','17:35'),
('Train','C','Malmparken','Vesterport','18:25','18:35'),

('Train','C','Flintholm','Vesterport','12:35','12:50'), -- 15m
('Train','C','Flintholm','Vesterport','13:35','13:50'),
('Train','C','Flintholm','Vesterport','14:35','14:50'),
('Train','C','Flintholm','Vesterport','15:35','15:50'),
('Train','C','Flintholm','Vesterport','16:35','16:50'),
('Train','C','Flintholm','Vesterport','17:35','17:50'),
('Train','C','Flintholm','Vesterport','18:35','18:50'),


 --Train C to Herlev
('Train','C','Vesterport','Herlev','12:05','12:20'), -- 15m
('Train','C','Vesterport','Herlev','13:05','13:20'),
('Train','C','Vesterport','Herlev','14:05','14:20'),
('Train','C','Vesterport','Herlev','15:05','15:20'),
('Train','C','Vesterport','Herlev','16:05','16:20'),
('Train','C','Vesterport','Herlev','17:05','17:20'),
('Train','C','Vesterport','Herlev','18:05','18:20'),

('Train','C','Flintholm','Herlev','12:20','12:30'), -- 10m
('Train','C','Flintholm','Herlev','13:20','13:30'),
('Train','C','Flintholm','Herlev','14:20','14:30'),
('Train','C','Flintholm','Herlev','15:20','15:30'),
('Train','C','Flintholm','Herlev','16:20','16:30'),
('Train','C','Flintholm','Herlev','17:20','17:30'),
('Train','C','Flintholm','Herlev','18:20','18:30'),

('Train','C','Malmparken','Herlev','12:30','12:38'),-- 8m
('Train','C','Malmparken','Herlev','13:30','13:38'),
('Train','C','Malmparken','Herlev','14:30','14:38'),
('Train','C','Malmparken','Herlev','15:30','15:38'),
('Train','C','Malmparken','Herlev','16:30','16:38'),
('Train','C','Malmparken','Herlev','17:30','17:38'),
('Train','C','Malmparken','Herlev','18:30','18:38'),

('Train','C','Husum','Herlev','12:38','12:52'),  -- 14m
('Train','C','Husum','Herlev','13:38','13:52'), 
('Train','C','Husum','Herlev','14:38','14:52'), 
('Train','C','Husum','Herlev','15:38','15:52'), 
('Train','C','Husum','Herlev','16:38','16:52'), 
('Train','C','Husum','Herlev','17:38','17:52'), 
('Train','C','Husum','Herlev','18:38','18:52'), 

--Bus 1 to Malmparken
('Bus','1','Herlev','Malmparken','12:06','12:46'), -- 40m
('Bus','1','Herlev','Malmparken','13:06','13:46'),
('Bus','1','Herlev','Malmparken','14:06','14:46'),
('Bus','1','Herlev','Malmparken','15:06','15:46'),
('Bus','1','Herlev','Malmparken','16:06','16:46'),
('Bus','1','Herlev','Malmparken','17:06','17:46'),
('Bus','1','Herlev','Malmparken','18:06','18:46'),

--Bus 1 to Herlev
('Bus','1','Malmparken','Herlev','12:10','12:50'), -- 40m
('Bus','1','Malmparken','Herlev','13:10','13:50'),
('Bus','1','Malmparken','Herlev','14:10','14:50'),
('Bus','1','Malmparken','Herlev','15:10','15:50'),
('Bus','1','Malmparken','Herlev','16:10','16:50'),
('Bus','1','Malmparken','Herlev','17:10','17:50'),
('Bus','1','Malmparken','Herlev','18:10','18:50'),

--Bus 2 to Skovlunde
('Bus','2','Flintholm','Skovlunde','12:10','12:30'), -- 20
('Bus','2','Flintholm','Skovlunde','13:10','13:30'),
('Bus','2','Flintholm','Skovlunde','14:10','14:30'),
('Bus','2','Flintholm','Skovlunde','15:10','15:30'),
('Bus','2','Flintholm','Skovlunde','16:10','16:30'),
('Bus','2','Flintholm','Skovlunde','17:10','17:30'),
('Bus','2','Flintholm','Skovlunde','18:10','18:30'),
--Bus 2 to Flintholm
('Bus','2','Skovlunde','Flintholm','12:15','12:35'), -- 20
('Bus','2','Skovlunde','Flintholm','13:15','13:35'),
('Bus','2','Skovlunde','Flintholm','14:15','14:35'),
('Bus','2','Skovlunde','Flintholm','15:15','15:35'),
('Bus','2','Skovlunde','Flintholm','16:15','16:35'),
('Bus','2','Skovlunde','Flintholm','17:15','17:35'),
('Bus','2','Skovlunde','Flintholm','18:15','18:35'),

--Bus 3 to Valby
('Bus','3','Vesterport','Valby','12:00','12:15'), -- 15
('Bus','3','Vesterport','Valby','13:00','13:15'),
('Bus','3','Vesterport','Valby','14:00','14:15'),
('Bus','3','Vesterport','Valby','15:00','15:15'),
('Bus','3','Vesterport','Valby','16:00','16:15'),
('Bus','3','Vesterport','Valby','17:00','17:15'),
('Bus','3','Vesterport','Valby','18:00','18:15'),

('Bus','3','Enghave','Valby','12:05','12:18'), -- 13
('Bus','3','Enghave','Valby','13:05','13:18'),
('Bus','3','Enghave','Valby','14:05','14:18'),
('Bus','3','Enghave','Valby','15:05','15:18'),
('Bus','3','Enghave','Valby','16:05','16:18'),
('Bus','3','Enghave','Valby','17:05','17:18'),
('Bus','3','Enghave','Valby','18:05','18:18'),

--Bus 3 to Vesterport
('Bus','3','Valby','Vesterport','12:02','12:15'), -- 13
('Bus','3','Valby','Vesterport','13:02','13:15'),
('Bus','3','Valby','Vesterport','14:02','14:15'),
('Bus','3','Valby','Vesterport','15:02','15:15'),
('Bus','3','Valby','Vesterport','16:02','16:15'),
('Bus','3','Valby','Vesterport','17:02','17:15'),
('Bus','3','Valby','Vesterport','18:02','18:15'),

('Bus','3','Enghave','Vesterport','12:15','12:30'), -- 15
('Bus','3','Enghave','Vesterport','13:15','13:30'),
('Bus','3','Enghave','Vesterport','14:15','14:30'),
('Bus','3','Enghave','Vesterport','15:15','15:30'),
('Bus','3','Enghave','Vesterport','16:15','16:30'),
('Bus','3','Enghave','Vesterport','17:15','17:30'),
('Bus','3','Enghave','Vesterport','18:15','18:30'),
--Bus 4 to Valby
('Bus','4','Skovlunde','Valby','12:02','12:14'), -- 12
('Bus','4','Skovlunde','Valby','13:02','13:14'),
('Bus','4','Skovlunde','Valby','14:02','14:14'),
('Bus','4','Skovlunde','Valby','15:02','15:14'),
('Bus','4','Skovlunde','Valby','16:02','16:14'),
('Bus','4','Skovlunde','Valby','17:02','17:14'),
('Bus','4','Skovlunde','Valby','18:02','18:14'),

('Bus','4','Islev','Valby','12:14','12:28'), -- 14
('Bus','4','Islev','Valby','13:14','13:28'),
('Bus','4','Islev','Valby','14:14','14:28'),
('Bus','4','Islev','Valby','15:14','15:28'),
('Bus','4','Islev','Valby','16:14','16:28'),
('Bus','4','Islev','Valby','17:14','17:28'),
('Bus','4','Islev','Valby','18:14','18:28'),

--Bus 4 to Skovlunde
('Bus','4','Valby','Skovlunde','12:10','12:24'), -- 14
('Bus','4','Valby','Skovlunde','13:10','13:24'),
('Bus','4','Valby','Skovlunde','14:10','14:24'),
('Bus','4','Valby','Skovlunde','15:10','15:24'),
('Bus','4','Valby','Skovlunde','16:10','16:24'),
('Bus','4','Valby','Skovlunde','17:10','17:24'),
('Bus','4','Valby','Skovlunde','18:10','18:24'),

('Bus','4','Islev','Skovlunde','12:24','12:36'), -- 12
('Bus','4','Islev','Skovlunde','13:24','13:36'),
('Bus','4','Islev','Skovlunde','14:24','14:36'),
('Bus','4','Islev','Skovlunde','15:24','15:36'),
('Bus','4','Islev','Skovlunde','16:24','16:36'),
('Bus','4','Islev','Skovlunde','17:24','17:36'),
('Bus','4','Islev','Skovlunde','18:24','18:36')
;