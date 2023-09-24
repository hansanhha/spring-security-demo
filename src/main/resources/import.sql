INSERT INTO Users (user_id, username, password, algorithm) VALUES ('1', 'test1', '$2a$10$voZhZUJU2lA7cGg4Ibqqquj3vXoPiJeLJJuUyz5PcFnpxdkVIyDBq', 'BCRYPT');
INSERT INTO Users (user_id, username, password, algorithm) VALUES ('2', 'test2', '$2a$10$voZhZUJU2lA7cGg4Ibqqquj3vXoPiJeLJJuUyz5PcFnpxdkVIyDBq', 'BCRYPT');
INSERT INTO Users (user_id, username, password, algorithm) VALUES ('3', 'test3', '$2a$10$voZhZUJU2lA7cGg4Ibqqquj3vXoPiJeLJJuUyz5PcFnpxdkVIyDBq', 'BCRYPT');

INSERT INTO authority (authority_id, name, user_id) VALUES ('1', 'ADMIN', '1');
INSERT INTO authority (authority_id, name, user_id) VALUES ('2', 'ADMIN', '2');
INSERT INTO authority (authority_id, name, user_id) VALUES ('3', 'MANAGER', '3');

INSERT INTO product (product_id, name, price, currency) VALUES ('1', 'Chocolate', '10', 'USD');