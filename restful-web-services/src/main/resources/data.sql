INSERT INTO user_details(id, birth_date, name)
VALUES (10001, current_date(), 'Muromi');
INSERT INTO user_details(id, birth_date, name)
VALUES (10002, current_date(), 'Shinji');
INSERT INTO user_details(id, birth_date, name)
VALUES (10003, current_date(), 'Rei');

INSERT INTO post(id, description, user_id)
VALUES (20001, 'Hello World', 10001);
INSERT INTO post(id, description, user_id)
VALUES (20002, 'Hello World2', 10001);
INSERT INTO post(id, description, user_id)
VALUES (20003, 'Hello World3', 10002);
INSERT INTO post(id, description, user_id)
VALUES (20004, 'Hello World4', 10003);