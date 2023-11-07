ALTER TABLE user
    DROP COLUMN firstName,
    DROP COLUMN lastName;

ALTER TABLE user
    ADD first_name VARCHAR(255),
    ADD last_name VARCHAR(255);