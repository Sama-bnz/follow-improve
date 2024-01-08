CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    roles_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
)