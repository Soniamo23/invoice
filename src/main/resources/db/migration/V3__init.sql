CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(200) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    locked BOOLEAN,
    disabled BOOLEAN
    );

CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    roles VARCHAR(25) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);