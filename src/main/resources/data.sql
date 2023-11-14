INSERT INTO stoixhwoman.match (id, description, match_date, match_time, team_a, team_b, sport)
VALUES (1, 'LAMIA-LEVADIAKOS', '2023-11-14', '18:00:00', 'LAMIA', 'LEVADIAKOS', 0),
       (2, 'VOLOS-KIFISIA', '2023-11-19', '21:30:00', 'VOLOS', 'KIFISIA', 0),
       (3, 'LAVRIO-PERISTERI', '2023-11-17', '20:00:00', 'LAVRIO', 'PERISTERI', 1);

INSERT INTO stoixhwoman.match_odds (id, match_id, specifier, odd)
VALUES (7, 1, '1', 1.2),
       (8, 1, '2', 3),
       (9, 1, 'X', 6),
       (10, 2, '1', 1.8),
       (11, 2, '2', 2.5),
       (12, 2, 'X', 4),
       (13, 3, '1', 1.6),
       (14, 3, '2', 2.6);