CREATE TABLE books
(
    id                          INT UNSIGNED NOT NULL,
    name                        VARCHAR(50) NOT NULL,
    price                       INT NOT NULL,
    author                      VARCHAR(50),
    Genre_id                    int(10),
    created_at                  TIMESTAMP(0),
    updated_at                  TIMESTAMP(0),
    CONSTRAINT PRIMARY KEY (id)
);
