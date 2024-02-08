drop schema if exists dat109_oblig2 cascade;
create schema dat109_oblig2;

set search_path to dat109_oblig2;

create table address(
    streetAddress varchar(55) primary key,
    postcode char(4),
    postalArea varchar(55)
);

create table car(
    registrationNr varchar(8) primary key,
    brand varchar(30),
    model varchar(30),
    color varchar(30),
    groupCar varchar(30),
    available boolean

);

create table costumer(
    firstName varchar(55),
    lastName varchar(55),
    address varchar(55) references address(streetAddress),
    phone char(8) primary key
);

create table rentalCompany(
    name varchar(55) ,
    phone varchar(9),
    companyAddress varchar(55) references address(streetAddress)
);

create table rentalOffice(
    address varchar(55) references address(streetAddress)
    phone char(8),
    rentalCompany varchar(55) references rentalCompany(name)
);

create table rentalOrder(

);





