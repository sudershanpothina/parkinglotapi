DROP TABLE IF EXISTS parking_lots;

CREATE TABLE parking_lots (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              zip_code VARCHAR(10) NOT NULL,
                              name VARCHAR(25) NOT NULL,
                              description VARCHAR(250) NOT NULL,
);

INSERT INTO parking_lots (zip_code, name, description) VALUES
('53714','Badgers West','West side parking lot for badger games'),
('53704','Packers West','West side parking lot for Packer games'),
('53713','Brewers West','West side parking lot for Brewers games'),
('53711','Capitols West','West side parking lot for Capitols games'),
('53709','Hildale West','West side parking lot for Hildale games'),
('53705','West Town Mall','West side parking lot for Packer games');