INSERT INTO stoixhwoman.match (id, description, match_date, match_time, team_a, team_b, sport)
VALUES (4, 'LAMIA-LEVADIAKOS', '2023-11-14', '2023-11-14 18:14:27.583000', 'LAMIA', 'LEVADIAKOS', 0),
       (5, 'VOLOS-KIFISIA', '2023-11-19', '2023-11-19 21:30:00.583000', 'VOLOS', 'KIFISIA', 0),
       (6, 'LAVRIO-PERISTERI', '2023-11-17', '2023-11-17 20:00:00.583000', 'LAVRIO', 'PERISTERI', 1);

INSERT INTO stoixhwoman.match_odds (id, match_id, specifier, odd)
VALUES (7, 4, '1', 1.2),
       (8, 4, '2', 3),
       (9, 4, 'X', 6),
       (10, 5, '1', 1.8),
       (11, 5, '2', 2.5),
       (12, 5, 'X', 4),
       (13, 6, '1', 1.6),
       (14, 6, '2', 2.6);