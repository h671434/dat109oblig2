drop schema if exists dat109_oblig2 cascade;
create schema dat109_oblig2;

set search_path to dat109_oblig2;



create table car(
                    registrationNr varchar(8) primary key,
                    brand varchar(30),
                    model varchar(30),
                    color varchar(30),
                    groupCar varchar(30),
                    availibe boolean

);