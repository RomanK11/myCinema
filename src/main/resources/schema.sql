CREATE TABLE users (
    id IDENTITY NOT NULL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    activated BOOLEAN
);

CREATE TABLE IF NOT EXISTS categories(
    id  IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS films(
    id  IDENTITY NOT NULL PRIMARY KEY,
    title VARCHAR NOT NULL,
    link VARCHAR,
    rate INTEGER,
    category_id  BIGINT NOT NULL,

    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS libraries (
    id IDENTITY NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    film_id BIGINT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (film_id) REFERENCES films(id) ON DELETE CASCADE
);