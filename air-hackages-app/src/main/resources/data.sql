INSERT INTO AIRCRAFTS (code, description) VALUES
  ('AH123', 'Boeing 767'),
  ('AH241', 'Airbus A380'),
  ('AH125', 'Boeing 777'),
  ('AH404', 'Airbus A360');

INSERT INTO FLIGHTS (type, origin, destination, departure_date, arrival_date, aircraft_id) VALUES
  ('Medium-Haull', 'Paris', 'Amsterdam', '2020-11-12 12:08:17.320053-03', '2020-11-12 13:08:17.320053-03', 1),
  ('Medium-Haull', 'Amsterdam', 'Paris', '2020-11-12 14:08:17.320053-03', '2020-11-12 15:08:17.320053-03', 1),
  ('Medium-Haull', 'Paris', 'Amsterdam', '2020-11-12 16:08:17.320053-03', '2020-11-12 17:08:17.320053-03', 2),
  ('Medium-Haull', 'Amsterdam', 'Paris', '2020-11-12 16:08:17.320053-03', '2020-11-12 17:08:17.320053-03', 2),
   ('Long-Haull', 'Brussels', 'New-York', '2020-11-12 19:08:17.320053-03', '2020-11-13 01:08:17.320053-03', 4);