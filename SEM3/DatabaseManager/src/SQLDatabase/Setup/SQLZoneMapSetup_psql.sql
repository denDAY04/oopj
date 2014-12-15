drop table ZoneMap;

-- THe Zonemap sets up the adjecency of zones. Defaulted to 4 maximum.
create table ZoneMap (
    zoneNum int,
    adjacent1 int,
    adjacent2 int,
    adjecent3 int,
    adjecent4 int
);

insert into ZoneMap values(1,2,3,0,0);
insert into ZoneMap values(2,1,3,4,0);
insert into ZoneMap values(3,1,2,4,5);
insert into ZoneMap values(4,2,3,5,0);
insert into ZoneMap values(5,3,4,0,0);