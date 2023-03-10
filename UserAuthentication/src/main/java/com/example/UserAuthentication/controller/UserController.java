package com.example.UserAuthentication.controller;
import com.example.UserAuthentication.entity.User;
import com.example.UserAuthentication.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserAuthentication.service.UserServices;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    //Create new User
    @PostMapping("/create")
    public ResponseEntity<User>CreateUser(@RequestBody User user)  {
            userServices.createUser(user);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Update User Details
    @PutMapping("/update/{username}")

    public ResponseEntity<User>ChangeUserDetails(@PathVariable("username") String username, @RequestBody User user)  {
      User Currntuser=  userServices.changeUserDetails(username,user);
          return new ResponseEntity<User>(Currntuser,HttpStatus.OK);
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleAlreadyExistsException(AlreadyExistsException exception) {
        return exception.getMessage();
    }
}
