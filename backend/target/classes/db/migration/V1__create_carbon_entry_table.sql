CREATE TABLE carbon_entry (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    activity VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    carbon_kg DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    status VARCHAR(50) NOT NULL
);
