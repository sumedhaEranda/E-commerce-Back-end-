package com.example.UserAuthentication.controller;
import com.example.UserAuthentication.Dto.UserLoginRequest;
import com.example.UserAuthentication.entity.User;
import com.example.UserAuthentication.exception.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserAuthentication.service.UserServices;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserServices userServices;

    //Create new User
    @PostMapping("/create")
    public ResponseEntity<User>CreateUser(@RequestBody User user)  {
        User createdUser= userServices.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    //Update User Details
    @PutMapping("/update/{email}")

    public ResponseEntity<User>ChangeUserDetails(@PathVariable("email") String email, @RequestBody User user)  {
      User Currntuser=  userServices.changeUserDetails(email,user);
          return new ResponseEntity<User>(Currntuser,HttpStatus.OK);
    }


    //Get all User Details
    @GetMapping("/findById/{email}")

    public ResponseEntity<User>GetUserDetails(@PathVariable("username") String username)  {
        User getUserDetails=  userServices.GetUserDetails(username);
        return new ResponseEntity<>(getUserDetails,HttpStatus.OK);
    }


    //Delete User Details
    @DeleteMapping("/findById/{username}")

    public ResponseEntity<User>DeleteUserDetailsByID(@PathVariable("username") String username)  {
       User deletDetails=  userServices.DeleteUserDetailsById(username);
        return  new ResponseEntity<>(deletDetails,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        // Retrieve user information from database or user authentication provider
        User user = userServices.userlogin(email,password);
         if(user!=null){
             return new  ResponseEntity<>(user,HttpStatus.OK);
         }else {

             return  new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
         }
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleAlreadyExistsException(AlreadyExistsException exception) {
        return exception.getMessage();
    }
}
