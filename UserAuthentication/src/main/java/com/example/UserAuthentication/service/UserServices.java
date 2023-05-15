package com.example.UserAuthentication.service;

import com.example.UserAuthentication.common.UserConstant;
import com.example.UserAuthentication.entity.User;
import com.example.UserAuthentication.exception.AlreadyExistsException;
import com.example.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //CREATE NEW USER WITH USER ROLE
    public User createUser(User user) throws AlreadyExistsException {

        //Checking the Already username Exit
        Optional<User> usernameEntry = userRepository.findByUserName(user.getUserName());
        if (usernameEntry.isPresent()) {
            throw new AlreadyExistsException("Username already exists!");
        } else {
            user.setRoles(UserConstant.DEFAULT_ROLE);
            //encrypted the password for user
            String encryptedPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPwd);
            userRepository.save(user);
            return user;
        }
    }

    //CHANGE USER Details according to username
    public User changeUserDetails(String email, User user) {

        //Checking the Available username
        Optional<User> usernameEntry = userRepository.findByUserName(email);
        if (usernameEntry.isPresent()) {

            User UpdateUser = userRepository.findByUserName(email).get();
            if (UpdateUser != null) {
                String update_encryptedPwd = passwordEncoder.encode(user.getPassword());
                UpdateUser.setUserName(user.getUserName());
                UpdateUser.setPassword(update_encryptedPwd);
                UpdateUser.setRoles(user.getRoles());
                UpdateUser.setActive(user.isActive());
                userRepository.save(UpdateUser);
            }
        } else {
            throw new AlreadyExistsException("User is Not found!");
        }
        return user;
    }

    //GET ALL USER Details according to username
    public User GetUserDetails(String username) {

        Optional<User> getuserdetails = userRepository.findByUserName(username);

        if (getuserdetails.isPresent()) {

            return getuserdetails.get();
        } else {
            throw new AlreadyExistsException("User is Not found!");
        }
    }


    //Delete User according to username
    public User DeleteUserDetailsById(String username) {
        boolean AvableStatus = userRepository.findByUserName(username).isPresent();

        if (AvableStatus) {
            User getuserdetails = userRepository.findByUserName(username).get();

            if (getuserdetails != null) {
                userRepository.deleteById(getuserdetails.getId());
            }
            return getuserdetails;
        } else {
            throw new AlreadyExistsException("User is Not found!");
        }
    }


    public User userlogin(String email, String password) {

        Optional<User> loguser = null;
        try {
            loguser = userRepository.findByEmail(email);
        } catch (Exception e) {
            e.getMessage();
        }

        User user = loguser.get();
        boolean isPasswordMatched = passwordEncoder.matches(password, user.getPassword());
        if (loguser != null && isPasswordMatched) {

            return user;
        } else {
            return null;
        }
    }
}
