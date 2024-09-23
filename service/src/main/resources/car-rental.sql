-- Table: brands
CREATE DATABASE car_rental;

-- Table: cars
CREATE TABLE cars
(
    car_id        SERIAL PRIMARY KEY,
    name          VARCHAR(128)   NOT NULL,
    brand         VARCHAR(128)   NOT NULL,
    quality_class VARCHAR(128)   NOT NULL,
    rental_cost   NUMERIC(10, 2) NOT NULL,
    description   TEXT
);

-- Table: clients
CREATE TABLE clients
(
    client_id     SERIAL PRIMARY KEY,
    first_name    VARCHAR(64) NOT NULL,
    second_name   VARCHAR(64) NOT NULL,
    passport_info VARCHAR(64) NOT NULL,
    contact_info  VARCHAR(64)
);

-- Table: rentals
CREATE TABLE rentals
(
    rental_id         SERIAL PRIMARY KEY,
    rental_start_date DATE        NOT NULL,
    rental_end_date   DATE        NOT NULL,
    with_driver       BOOLEAN     NOT NULL,
    order_status      VARCHAR(20) NOT NULL NOT NULL DEFAULT 'pending',
    rejection_reason  TEXT,
    created_at        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    client_id         INTEGER     NOT NULL REFERENCES clients (client_id),
    car_id            INTEGER     NOT NULL REFERENCES cars (car_id)
);

-- Table: invoices
CREATE TABLE invoices
(
    invoice_id   SERIAL PRIMARY KEY,
    amount       NUMERIC(10, 2) NOT NULL,
    issue_date   DATE           NOT NULL DEFAULT CURRENT_DATE,
    paid         BOOLEAN        NOT NULL DEFAULT FALSE,
    invoice_type VARCHAR(20)    NOT NULL,
    rental_id    INTEGER REFERENCES rentals (rental_id)
);

-- Table: returns
CREATE TABLE returns
(
    return_id         SERIAL PRIMARY KEY,
    return_date       DATE    NOT NULL DEFAULT CURRENT_DATE,
    damage_report     TEXT,
    damage_fee        NUMERIC(10, 2),
    repair_invoice_id INTEGER REFERENCES invoices (invoice_id),
    rental_id         INTEGER NOT NULL REFERENCES rentals (rental_id)
);

