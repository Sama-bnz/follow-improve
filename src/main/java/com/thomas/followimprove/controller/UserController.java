package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.entities.dto.UserCreateDto;
import com.thomas.followimprove.entities.dto.UserGetDto;
import com.thomas.followimprove.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserGetDto> create(@RequestBody UserCreateDto userCreateDto) {


        if (userCreateDto.getFirstName() == null || userCreateDto.getLastName() == null || userCreateDto.getLogin() == null
                || userCreateDto.getPassword() == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

            try {
                // Convertir la date de naissance en LocalDate
                LocalDate dateOfBirthday = LocalDate.parse(userCreateDto.getDateOfBirthday(), formatter);
                LocalDate currentDate = LocalDate.now();
                // Calculer l'âge de l'utilisateur
                Period age = Period.between(dateOfBirthday, currentDate);

                if (age.getYears() >= 16) {
                    return ResponseEntity.ok(userService.create(userCreateDto));
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
                }
            } catch (DateTimeParseException e) {
                // Gère l'erreur d'analyse de la date ici
                return ResponseEntity.badRequest().body(null);
            }
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.findUserById(id);
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
