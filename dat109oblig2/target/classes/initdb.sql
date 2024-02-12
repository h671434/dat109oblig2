-- Drop schema if exists and create schema
DROP SCHEMA IF EXISTS dat109_oblig2 CASCADE;
CREATE SCHEMA dat109_oblig2;

-- Set search path to the new schema
SET search_path TO dat109_oblig2;

-- Create the Address table
CREATE TABLE address (
    streetAddress VARCHAR(55) PRIMARY KEY,
    postcode CHAR(5),
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
    milageInKm Integer,
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


-- Insert data into the Address table
INSERT INTO address (streetAddress, postcode, postalArea) VALUES
    ('Street1', '1234', 'City1'),
    ('Street2', '5678', 'City2'),
    ('Street3', '91011', 'City3');

-- Insert data into the Costumer table
INSERT INTO costumer (firstName, lastName, address, phone) VALUES
    ('John', 'Doe', 'Street1', '12345678'),
    ('Jane', 'Doe', 'Street2', '23456789'),
    ('Bob', 'Smith', 'Street3', '34567890');

-- Insert data into the RentalCompany table
INSERT INTO rentalCompany (name, phone, companyAddress) VALUES
    ('Company1', '123456789', 'Street1'),
    ('Company2', '987654321', 'Street2'),
    ('Company3', '111223344', 'Street3');

-- Insert data into the RentalOffice table
INSERT INTO rentalOffice (address, phone, rentalCompany) VALUES
    ('Street1', '12345678', 'Company1'),
    ('Street2', '23456789', 'Company2'),
    ('Street3', '34567890', 'Company3');

-- Insert data into the Car table
INSERT INTO car (registrationNr, brand, model, color, groupCar, available, rentalOffice) VALUES
    ('ABC123', 'Toyota', 'Corolla', 'Blue', 'GroupA', true, '12345678'),
    ('XYZ789', 'Honda', 'Civic', 'Red', 'GroupB', true, '23456789'),
    ('DEF456', 'Ford', 'Focus', 'Green', 'GroupC', true, '34567890');

-- Insert data into the activeOrder table
INSERT INTO activeOrder (costumerPhone, carRegistrationNr, pickupTime, expectedReturnTime) VALUES
    ('12345678', 'ABC123', '2024-02-09', '2024-02-10'),
    ('23456789', 'XYZ789', '2024-02-10', '2024-02-11'),
    ('34567890', 'DEF456', '2024-02-11', '2024-02-12');

-- Insert data into the finishedOrder table
INSERT INTO finishedOrder (costumerPhone, carRegistrationNr, pickupTime, expectedReturnTime, returnTime, returnMilageInKm, price) VALUES
    ('12345678', 'ABC123', '2024-02-09', '2024-02-10', '2024-02-10', 100, 200),
    ('23456789', 'XYZ789', '2024-02-10', '2024-02-11', '2024-02-11', 150, 250),
    ('34567890', 'DEF456', '2024-02-11', '2024-02-12', '2024-02-12', 200, 300);