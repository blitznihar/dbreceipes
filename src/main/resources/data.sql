DROP TABLE IF EXISTS Address;

CREATE TABLE Address(
AddressId INT AUTO_INCREMENT  PRIMARY KEY,
Street VARCHAR(255) NOT NULL,
Building VARCHAR(255) NOT NULL,
ZipCode VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS Restaurant;

CREATE TABLE Restaurant(
RestaurantId INT AUTO_INCREMENT  PRIMARY KEY,
Name VARCHAR(255) NOT NULL,
Cuisine VARCHAR(255) NOT NULL,
Borough VARCHAR(255) NOT NULL,
AddressId int NOT NULL
);

INSERT INTO Address(Street, Building, ZipCode) VALUES
('Church Street','107','10007'),
('Flatbush Avenue','469','11225'),
('20 Avenue','129-08','11356');

INSERT INTO Restaurant( Name, Cuisine, Borough, AddressId) VALUES
('Downtown Deli','American','Manhattan',1),
('Wendys','Hamburgers','Brooklyn',2),
('Riviera Caterer','American','Brooklyn',3);