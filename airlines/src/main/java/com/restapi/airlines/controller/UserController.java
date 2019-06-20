package com.restapi.airlines.controller;

import com.restapi.airlines.exception.UserNotFoundException;
import com.restapi.airlines.model.request.UserDetailsRequestModel;
import com.restapi.airlines.model.response.UserResponseModel;
import com.restapi.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{idUser}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getUser(@PathVariable String idUser){
        UserResponseModel getUserValue = userService.getUser(idUser);
        if (getUserValue != null) {
            return new ResponseEntity<>(getUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllUser(){
        Collection getAllUserValue = userService.getAllUser();
        return new ResponseEntity<>(getAllUserValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponseModel createUserValue = userService.createUser(userDetails);
        return new ResponseEntity<>(createUserValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{idUser}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserResponseModel> updatePhoneNumUser(@PathVariable String idUser, @Valid @RequestBody UserDetailsRequestModel userDetails){
        UserResponseModel updatePhoneNumUserValue = userService.updatePhoneNumUser(idUser, userDetails);
        if (updatePhoneNumUserValue != null) {
            return new ResponseEntity<>(updatePhoneNumUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Update Failed, User Not Found");
        }
    }

    @DeleteMapping(path = "/{idUser}")
    public ResponseEntity deleteUser(@PathVariable String idUser){
        UserResponseModel deleteUserValue = userService.deleteUser(idUser);
        if (deleteUserValue != null) {
            return new ResponseEntity<>(deleteUserValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Delete Failed, User Not Found");
        }
    }
}