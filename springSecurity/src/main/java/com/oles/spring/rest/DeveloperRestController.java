package com.oles.spring.rest;


import com.oles.spring.model.User;
import com.oles.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {

    UserRepository repository;
@Autowired
    public DeveloperRestController(UserRepository repository) {
        this.repository = repository;
    }



@GetMapping()
@PreAuthorize("hasAuthority('developers:read')")
    public List<User> getAll(){

    List<User> users= repository.findAll();
    return  users;

    }


    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
    User user = repository.findById(id).orElse(null);
        return user;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public User create(@RequestBody User user){
    User newUser=repository.save(user);
    return  newUser;
}

@DeleteMapping("/{id}")
@PreAuthorize("hasAuthority('developers:write')")
public void deleteById(@PathVariable int id){
    repository.deleteById(id);
}
}



