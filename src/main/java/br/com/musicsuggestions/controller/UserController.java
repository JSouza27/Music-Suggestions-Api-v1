package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.model.User;
import br.com.musicsuggestions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/")
  public MessageResponseDTO create(@RequestBody User newUser) {
    return userService.create(newUser);
  }
}
