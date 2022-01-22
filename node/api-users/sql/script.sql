CREATE EXISTENSION IF NOT EXIST "uuid_ossp";
CREATE EXISTENSION IF NOT EXIST "pgcrypto";

CREATE TABLE IF NOT EXISTS application_user(
    id uuid default uuid_generate_v4(),
    username VARCHAR,
    password VARCHAR,
    PRIMARY KEY(id));

INSERT INTO application_user(username, password) VALUES('raquel', crypt('87654321', 'my_salt'));



