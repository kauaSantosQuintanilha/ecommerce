package br.com.senai.ecommerce.controller;

import br.com.senai.ecommerce.entities.User;
import br.com.senai.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")// localhost:8080/user
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public User createUsuario(@RequestBody User user){
         return  userRepository.save(user);

    }
    @GetMapping
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public  User getUserById(@PathVariable Long id){
        return  userRepository.findById(id).orElse(null);
    }
     @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
     }
     @PutMapping("/{id}")
    public  User uptadeUser(
            @PathVariable Long id,@RequestBody User user){
        User usuario=userRepository.findById(id).orElse(null);
        if (usuario !=null){
            usuario.setName(user.getName());
            usuario.setEmail(user.getEmail());
            usuario.setPassword(user.getPassword());
            return  userRepository.save(usuario);

        }
        return  null;
     }

    }




