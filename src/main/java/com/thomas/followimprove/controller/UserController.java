package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {


        if (user.getFirstName() == null || user.getLastName() == null || user.getLogin() == null
                || user.getPassword() == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

            try {
                // Convertir la date de naissance en LocalDate
                LocalDate dateOfBirthday = LocalDate.parse(user.getDateOfBirthday(), formatter);
                LocalDate currentDate = LocalDate.now();
                // Calculer l'âge de l'utilisateur
                Period age = Period.between(dateOfBirthday, currentDate);

                if (age.getYears() >= 16) {
                    return ResponseEntity.ok(userService.create(user));
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
                }
            } catch (DateTimeParseException e) {
                // Gère l'erreur d'analyse de la date ici
                return ResponseEntity.badRequest().body(null);
            }
        }
    }
}
