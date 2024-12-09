CREATE DATABASE popcorn_db;

--table'genres'
CREATE TABLE genres (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- table 'series'
CREATE TABLE series (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    poster VARCHAR(255)
);

-- table 'serie_genres'
CREATE TABLE serie_genres (
    serie_id UUID NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (serie_id, genre_id),
    FOREIGN KEY (serie_id) REFERENCES series(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);
