#DROP DATABASE IF EXISTS FlightDB;
#CREATE DATABASE FlightDB;
CREATE DATABASE IF NOT EXISTS FlightDB;
USE FlightDB;

-- Create User table
CREATE TABLE IF NOT EXISTS User (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FName VARCHAR(255),
    LName VARCHAR(255),
    email VARCHAR(255),
    registered_user BOOLEAN,
    companion_voucher BOOLEAN
);

-- Create Aircraft table
CREATE TABLE IF NOT EXISTS Aircraft (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Model VARCHAR(255)
);

-- Create Pilots table
CREATE TABLE IF NOT EXISTS Pilots (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FName VARCHAR(255),
    LName VARCHAR(255)
);

-- Create CabinCrew table
CREATE TABLE IF NOT EXISTS CabinCrew (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FName VARCHAR(255),
    LName VARCHAR(255)
);

-- Create Flight table
CREATE TABLE IF NOT EXISTS Flight (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Departure_Airport VARCHAR(255),
    Arrival_Airport VARCHAR(255),
    Departure_Time DATETIME,
    Arrival_Time DATETIME,
    AircraftID INT,
    PilotID INT,
    CabinCrew1ID INT,
    CabinCrew2ID INT,
    CabinCrew3ID INT,
    FOREIGN KEY (AircraftID) REFERENCES Aircraft(ID),
    FOREIGN KEY (PilotID) REFERENCES Pilots(ID),
    FOREIGN KEY (CabinCrew1ID) REFERENCES CabinCrew(ID),
    FOREIGN KEY (CabinCrew2ID) REFERENCES CabinCrew(ID),
    FOREIGN KEY (CabinCrew3ID) REFERENCES CabinCrew(ID)
);


-- Create Bookings table
CREATE TABLE IF NOT EXISTS Bookings (
    UserID INT,
    FlightID INT,
    Seat VARCHAR(10),
    Insurance BOOLEAN,
    PRIMARY KEY (UserID, FlightID),
    FOREIGN KEY (UserID) REFERENCES User(ID),
    FOREIGN KEY (FlightID) REFERENCES Flight(ID)
);

-- Insert users into User table
INSERT INTO User (FName, LName, email, registered_user, companion_voucher)
VALUES
    ('John', 'Doe', 'john.doe@email.com', true, false),
    ('Jane', 'Smith', 'jane.smith@email.com', true, true),
    ('Alice', 'Johnson', 'alice.johnson@email.com', false, false),
    ('Bob', 'Anderson', 'bob.anderson@email.com', true, false),
    ('Emily', 'Taylor', 'emily.taylor@email.com', true, true),
    ('David', 'Williams', 'david.williams@email.com', false, false),
    ('Olivia', 'Brown', 'olivia.brown@email.com', true, false),
    ('Michael', 'Jones', 'michael.jones@email.com', true, true),
    ('Sophia', 'Miller', 'sophia.miller@email.com', false, false),
    ('Daniel', 'Davis', 'daniel.davis@email.com', true, false),
    ('Emma', 'Wilson', 'emma.wilson@email.com', true, true),
    ('James', 'Smith', 'james.smith@email.com', false, false),
    ('Ava', 'Brown', 'ava.brown@email.com', true, false),
    ('Ethan', 'Miller', 'ethan.miller@email.com', false, false),
    ('Mia', 'Davis', 'mia.davis@email.com', true, true),
    ('Liam', 'Johnson', 'liam.johnson@email.com', true, false),
    ('Isabella', 'Anderson', 'isabella.anderson@email.com', false, false),
    ('Noah', 'Taylor', 'noah.taylor@email.com', true, true),
    ('Sophie', 'Moore', 'sophie.moore@email.com', true, false),
    ('Jackson', 'Clark', 'jackson.clark@email.com', false, false),
	('Grace', 'Harris', 'grace.harris@email.com', false, false),
    ('Logan', 'Anderson', 'logan.anderson@email.com', true, false),
    ('Chloe', 'Walker', 'chloe.walker@email.com', false, false),
    ('Lucas', 'Thomas', 'lucas.thomas@email.com', true, true),
    ('Avery', 'White', 'avery.white@email.com', true, false),
    ('Ella', 'Jones', 'ella.jones@email.com', false, false),
    ('Carter', 'Martin', 'carter.martin@email.com', true, false),
    ('Lily', 'Robinson', 'lily.robinson@email.com', true, true),
    ('Owen', 'Wright', 'owen.wright@email.com', false, false),
    ('Abigail', 'Baker', 'abigail.baker@email.com', true, false);
    
INSERT INTO Aircraft (Model)
VALUES 
	('Boeing 747'),
	('Boeing 737'),
	('Boeing 777');

-- Insert pilots into the Pilots table
INSERT INTO Pilots (FName, LName)
VALUES
    ('John', 'Doe'),
    ('Jane', 'Smith'),
    ('Mike', 'Johnson'),
    ('Emily', 'Williams'),
    ('David', 'Brown'),
    ('Olivia', 'Miller'),
    ('Michael', 'Jones'),
    ('Sophia', 'Moore'),
    ('Daniel', 'Davis'),
    ('Emma', 'Wilson');

-- Insert cabin crew members into the CabinCrew table
INSERT INTO CabinCrew (FName, LName)
VALUES
    ('Sara', 'Johnson'),
    ('Tom', 'Williams'),
    ('Ava', 'Jones'),
    ('Ethan', 'Moore'),
    ('Mia', 'Davis'),
    ('Liam', 'Wilson'),
    ('Isabella', 'Brown'),
    ('Noah', 'Miller'),
    ('Sophie', 'Smith'),
    ('Jackson', 'Anderson'),
    ('Chloe', 'Thomas'),
    ('Logan', 'Clark'),
    ('Avery', 'Taylor'),
    ('Grace', 'Martin'),
    ('Ella', 'Wright'),
    ('Lucas', 'Baker'),
    ('Lily', 'Robinson'),
    ('Owen', 'Harris'),
    ('Abigail', 'White'),
    ('Elijah', 'Walker');

-- Insert 20 flights into the Flight table with limited pilot and cabin crew IDs
INSERT INTO Flight (Departure_Airport, Arrival_Airport, Departure_Time, Arrival_Time, AircraftID, PilotID, CabinCrew1ID, CabinCrew2ID, CabinCrew3ID)
VALUES
    ('YYC', 'YVR', '2023-12-01 08:00:00', '2023-12-01 10:00:00', 1, 1, 2, 3, 4),
    ('YEG', 'YYC', '2023-12-02 12:00:00', '2023-12-02 14:00:00', 2, 2, 5, 6, 7),
    ('YYC', 'YYZ', '2023-12-03 16:00:00', '2023-12-03 18:00:00', 3, 3, 8, 9, 10),
    ('YYC', 'YUL', '2023-12-04 10:00:00', '2023-12-04 12:00:00', 1, 4, 11, 12, 13),
    ('YOW', 'YYC', '2023-12-05 14:00:00', '2023-12-05 16:00:00', 2, 5, 14, 15, 16),
    ('YYC', 'YVR', '2023-12-06 08:00:00', '2023-12-06 10:00:00', 3, 6, 17, 18, 19),
    ('YEG', 'YYC', '2023-12-07 12:00:00', '2023-12-07 14:00:00', 1, 7, 20, 1, 2),
    ('YYC', 'YYZ', '2023-12-08 16:00:00', '2023-12-08 18:00:00', 2, 8, 3, 4, 5),
    ('YYC', 'YUL', '2023-12-09 10:00:00', '2023-12-09 12:00:00', 3, 9, 6, 7, 8),
    ('YOW', 'YYC', '2023-12-10 14:00:00', '2023-12-10 16:00:00', 1, 10, 9, 10, 11),
    ('YYC', 'YVR', '2023-12-11 08:00:00', '2023-12-11 10:00:00', 2, 1, 12, 13, 14),
    ('YEG', 'YYC', '2023-12-12 12:00:00', '2023-12-12 14:00:00', 3, 2, 15, 16, 17),
    ('YYC', 'YYZ', '2023-12-13 16:00:00', '2023-12-13 18:00:00', 1, 3, 18, 19, 20),
    ('YYC', 'YUL', '2023-12-14 10:00:00', '2023-12-14 12:00:00', 2, 4, 1, 2, 3),
    ('YOW', 'YYC', '2023-12-15 14:00:00', '2023-12-15 16:00:00', 3, 5, 4, 5, 6),
    ('YYC', 'YVR', '2023-12-16 08:00:00', '2023-12-16 10:00:00', 1, 6, 7, 8, 9),
    ('YEG', 'YYC', '2023-12-17 12:00:00', '2023-12-17 14:00:00', 2, 7, 10, 11, 12),
    ('YYC', 'YYZ', '2023-12-18 16:00:00', '2023-12-18 18:00:00', 3, 8, 13, 14, 15),
    ('YYC', 'YUL', '2023-12-19 10:00:00', '2023-12-19 12:00:00', 1, 9, 16, 17, 18),
    ('YOW', 'YYC', '2023-12-20 14:00:00', '2023-12-20 16:00:00', 2, 10, 19, 20, 1);

INSERT INTO Bookings (UserID, FlightID, Seat, Insurance)
VALUES
    (1, 21, '1A', true),
    (2, 22, '1B', false),
    (3, 23, '1C', true),
    (4, 24, '1D', false),
    (5, 25, '1E', true),
    (6, 26, '1F', false),
    (7, 27, '2A', true),
    (8, 28, '2B', false),
    (9, 29, '2C', true),
    (10, 30, '2D', false),
    (11, 31, '2E', true),
    (12, 32, '2F', false),
    (13, 33, '3A', true),
    (14, 34, '3B', false),
    (15, 35, '3C', true),
    (16, 36, '3D', false),
    (17, 37, '3E', true),
    (18, 38, '3F', false),
    (19, 39, '4A', true),
    (20, 40, '4B', false),
    (21, 41, '4C', true),
    (22, 42, '4D', false),
    (23, 43, '4E', true),
    (24, 44, '4F', false),
    (25, 45, '5A', true),
    (26, 46, '5B', false),
    (27, 47, '5C', true),
    (28, 48, '5D', false),
    (29, 49, '5E', true),
    (30, 50, '5F', false);
