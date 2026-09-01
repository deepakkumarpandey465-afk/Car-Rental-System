CREATE DATABASE IF NOT EXISTS car_rental_db;

USE car_rental_db;

-- Cars table
CREATE TABLE IF NOT EXISTS cars (
    car_id INT NOT NULL,
    company VARCHAR(50) DEFAULT NULL,
    model VARCHAR(50) DEFAULT NULL,
    price_per_day DOUBLE DEFAULT NULL,
    available TINYINT(1) DEFAULT NULL,
    PRIMARY KEY (car_id)
);

-- Rentals table
CREATE TABLE IF NOT EXISTS rentals (
    rental_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) DEFAULT NULL,
    phone VARCHAR(20) DEFAULT NULL,
    id_number VARCHAR(50) DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
    license_number VARCHAR(50) DEFAULT NULL,
    car_id INT DEFAULT NULL,
    company VARCHAR(50) DEFAULT NULL,
    model VARCHAR(50) DEFAULT NULL,
    days INT DEFAULT NULL,
    price_per_day DOUBLE DEFAULT NULL,
    total_amount DOUBLE DEFAULT NULL,
    rental_date DATE DEFAULT NULL,
    status VARCHAR(20) DEFAULT 'RENTED',
    PRIMARY KEY (rental_id)
);

-- Cars data
INSERT INTO cars (car_id, company, model, price_per_day, available) VALUES
(1, 'Maruti', 'Swift', 1500, TRUE),
(2, 'Hyundai', 'Creta', 2500, TRUE),
(3, 'Tata', 'Nexon', 2000, TRUE),
(4, 'Toyota', 'Fortuner', 5000, TRUE),
(5, 'Mahindra', 'Thar', 3000, TRUE),
(6, 'Honda', 'City', 2200, TRUE),
(7, 'Kia', 'Seltos', 2400, TRUE),
(8, 'BMW', 'X1', 6000, TRUE),
(9, 'Audi', 'A4', 7000, TRUE),
(10, 'Mercedes', 'C-class', 8000, TRUE);