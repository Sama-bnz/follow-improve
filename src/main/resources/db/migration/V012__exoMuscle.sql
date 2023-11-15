Create table exo_muscle
(
    exercice_id int NOT NULL,
    muscle_id int NOT NULL,
    FOREIGN KEY (exercice_id) REFERENCES exercises(id),
    FOREIGN KEY (muscle_id) REFERENCES muscles(id)
);