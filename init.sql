CREATE DATABASE IF NOT EXISTS tyy;

CREATE TABLE IF NOT EXISTS tyy.medicine (
    id int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    price double NOT NULL,
    PRIMARY KEY (id)
);
