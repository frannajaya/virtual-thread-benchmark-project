-- Create database if it does not exist
CREATE DATABASE IF NOT EXISTS containerize_java_spring;

-- Use the database
USE containerize_java_spring;

-- Create the table if it does not exist
CREATE TABLE IF NOT EXISTS person (
    `id`   BIGINT         NOT NULL AUTO_INCREMENT comment 'id identifier for this table',
    `name` VARCHAR(255)   NOT NULL comment 'the person name',
    `age`  INT            NOT NULL comment 'the person age',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Create a new user and grant privileges
-- Replace 'myuser' and 'mypassword' with your desired username and password
CREATE USER IF NOT EXISTS 'test_user'@'%' IDENTIFIED BY 'test_user_password';

-- Grant all privileges on the database to the new user
GRANT ALL PRIVILEGES ON containerize_java_spring.* TO 'test_user'@'%';

-- Apply the changes
FLUSH PRIVILEGES;