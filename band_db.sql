CREATE DATABASE band_db;
 
USE band_db;
 
CREATE TABLE bands(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120),
    release_year INT,
    status VARCHAR(10)
);

INSERT INTO bands (id, name, release_year, status) VALUES
(DEFAULT, "AC/DC", 1973, "active"),
(DEFAULT, "The Beatles", 1974, "deactivate"),
(DEFAULT, "Guns N' Roses", 1985, "active"),
(DEFAULT, "Pink Floyd", 1965, "deactivate"),
(DEFAULT, "Nirvana", 1987, "deactivate"),
(DEFAULT, "Red Hot Chili Peppers", 1983, "active"),
(DEFAULT, "Iron Maiden", 1975, "deactivate"),
(DEFAULT, "The Rolling Stones", 1962, "active"),
(DEFAULT, "Linkin Park", 1996, "deactivate"),
(DEFAULT, "KISS", 1973, "active"),
(DEFAULT, "Aerosmith", 1970, "active"),
(DEFAULT, "Metalica", 1981, "active");


SELECT * FROM bands;


