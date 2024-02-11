-- Drop schema if exists and create schema
DROP SCHEMA IF EXISTS dat109_oblig2 CASCADE;
CREATE SCHEMA dat109_oblig2;

-- Set search path to the new schema
SET search_path TO dat109_oblig2;

-- Create the Address table
CREATE TABLE address (
    streetAddress VARCHAR(55) PRIMARY KEY,
    postcode CHAR(4),
    postalArea VARCHAR(55)
);

-- Create the Costumer table
CREATE TABLE costumer (
    firstName VARCHAR(55),
    lastName VARCHAR(55),
    address VARCHAR(55) REFERENCES address(streetAddress),
    phone CHAR(8) PRIMARY KEY
);

-- Create the RentalCompany table
CREATE TABLE rentalCompany (
    name VARCHAR(55) PRIMARY KEY,
    phone VARCHAR(9),
    companyAddress VARCHAR(55) REFERENCES address(streetAddress)
);

-- Create the RentalOffice table
CREATE TABLE rentalOffice (
    address VARCHAR(55) REFERENCES address(streetAddress),
    phone CHAR(8) PRIMARY KEY,
    rentalCompany VARCHAR(55) REFERENCES rentalCompany(name)
);

-- Create the Car table
CREATE TABLE car (
    registrationNr VARCHAR(8) PRIMARY KEY,
    brand VARCHAR(30),
    model VARCHAR(30),
    color VARCHAR(30),
    groupCar VARCHAR(30),
    available BOOLEAN,
    rentalOffice CHAR(8) REFERENCES rentalOffice(phone)
);

-- Create the RentalOrder table
CREATE TABLE activeOrder (
    orderId serial primary key,
    costumerPhone VARCHAR(9), -- should be changed to payment
    carRegistrationNr VARCHAR(8),
    pickupTime DATE,
    expectedReturnTime DATE
);

-- Add foreign key constraints for RentalOrder table
ALTER TABLE activeOrder
    ADD CONSTRAINT fk_costumer
    FOREIGN KEY (costumerPhone) REFERENCES costumer(phone);

ALTER TABLE activeOrder
    ADD CONSTRAINT fk_car
    FOREIGN KEY (carRegistrationNr) REFERENCES car(registrationNr);

-- Create the RentalOrderHistory table
CREATE TABLE finishedOrder (
    -- Define columns as needed
    orderId SERIAL PRIMARY KEY,
    costumerPhone VARCHAR(9) references costumer(phone),
    carRegistrationNr VARCHAR(8) references car(registrationNr),
    pickupTime DATE,
    expectedReturnTime DATE,
    returnTime date,
    returnMilageInKm integer,
    price integer
);


-- Add other constraints or indexes as needed


